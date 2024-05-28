package com.example.banking.service.service;

import com.example.banking.service.model.TransactionEntity;

public interface TransactionService {
    TransactionEntity transferMoney(Long senderId, Long receiverId, Double amount);
}
