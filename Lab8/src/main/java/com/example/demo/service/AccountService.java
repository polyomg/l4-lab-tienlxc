package com.example.demo.service;

import com.example.demo.entity.Account;

public interface AccountService {
    Account findById(String username);
}