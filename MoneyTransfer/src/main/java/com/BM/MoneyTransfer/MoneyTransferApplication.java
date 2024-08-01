package com.BM.MoneyTransfer;

import com.BM.MoneyTransfer.dao.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MoneyTransferApplication {

    public static void main(String[] args) {
        SpringApplication.run(MoneyTransferApplication.class, args);
    }


    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository) {
        return runner -> {

        };
    }
}
