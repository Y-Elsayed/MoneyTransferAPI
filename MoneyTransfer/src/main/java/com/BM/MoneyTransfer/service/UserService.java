package com.BM.MoneyTransfer.service;

import com.BM.MoneyTransfer.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    void save(User user);
    List<User> findAll();
}
