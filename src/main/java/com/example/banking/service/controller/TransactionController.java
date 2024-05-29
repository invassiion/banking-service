package com.example.banking.service.controller;

import com.example.banking.service.model.TransactionEntity;
import com.example.banking.service.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    public ResponseEntity<TransactionEntity> transferMoney(@RequestParam Long senderId, @RequestParam Long receiverId, @RequestParam Double amount) {
        TransactionEntity transaction = transactionService.transferMoney(senderId, receiverId, amount);
        return ResponseEntity.ok(transaction);
    }
}
