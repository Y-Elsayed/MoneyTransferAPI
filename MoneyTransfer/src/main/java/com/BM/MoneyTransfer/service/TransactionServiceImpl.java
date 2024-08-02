package com.BM.MoneyTransfer.service;

import com.BM.MoneyTransfer.dao.TransactionDao;
import com.BM.MoneyTransfer.entity.Card;
import com.BM.MoneyTransfer.entity.Transaction;
import com.BM.MoneyTransfer.exception.custom.InsufficientFundsException;
import com.BM.MoneyTransfer.exception.custom.RecipientNotFoundException;
import com.BM.MoneyTransfer.exception.custom.SenderNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    TransactionDao transactionDao;
    CardService cardService;

    @Override
    @Transactional
    public Transaction save(Transaction transaction) {
        // Initially set status to "pending"
        transaction.setStatus("pending");

        try {
            validateTransaction(transaction);
            performTransaction(transaction);
            transaction.setStatus("approved");
        } catch (Exception e) {
            transaction.setStatus("denied");
        }

        // Save the transaction with its status
        return this.transactionDao.save(transaction);
    }

    @Override
    public Optional<Transaction> findById(Long id) {
        return this.transactionDao.findById(id);
    }

    @Override
    public Page<Transaction> findByEmail(String email, Pageable pageable) {
        return this.transactionDao.findByEmail(email, pageable);
    }

    protected void validateTransaction(Transaction transaction) throws SenderNotFoundException, RecipientNotFoundException, InsufficientFundsException {
        Card senderCard = cardService.getCard(transaction.getSenderCardNumber());
        if (senderCard == null) {
            throw new SenderNotFoundException("Sender not found");
        }
        if (transaction.getAmount().compareTo(senderCard.getBalance()) > 0) {
            throw new InsufficientFundsException("Insufficient funds");
        }
        Card recipientCard = cardService.getCard(transaction.getRecipientCardNumber());
        if (recipientCard == null) {
            throw new RecipientNotFoundException("Recipient not found");
        }
    }

    protected void performTransaction(Transaction transaction) {
        Card senderCard = cardService.getCard(transaction.getSenderCardNumber());
        Card recipientCard = cardService.getCard(transaction.getRecipientCardNumber());

        cardService.updateCardBalance(senderCard.getCardNumber(), senderCard.getBalance() - transaction.getAmount());
        cardService.updateCardBalance(recipientCard.getCardNumber(), recipientCard.getBalance() + transaction.getAmount());
    }

}
