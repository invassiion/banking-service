package com.example.banking.service.controller;

import com.example.banking.service.model.TransactionEntity;
import com.example.banking.service.service.TransactionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/transfer")
    @Operation(summary = "Transfer money between accounts", responses = {
            @ApiResponse(responseCode = "200", description = "Transfer successful"),
            @ApiResponse(responseCode = "400", description = "Invalid request parameters")
    })
    public ResponseEntity<TransactionEntity> transferMoney(@RequestParam Long senderId, @RequestParam Long receiverId, @RequestParam Double amount) {
        TransactionEntity transaction = transactionService.transferMoney(senderId, receiverId, amount);
        return ResponseEntity.ok(transaction);
    }
}
