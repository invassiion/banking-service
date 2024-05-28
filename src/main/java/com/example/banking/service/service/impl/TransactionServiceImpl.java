package com.example.banking.service.service.impl;

import com.example.banking.service.exceptions.TransferMoneyException;
import com.example.banking.service.exceptions.UserNotFoundException;
import com.example.banking.service.model.TransactionEntity;
import com.example.banking.service.model.UserEntity;
import com.example.banking.service.repository.TransactionRepository;
import com.example.banking.service.repository.UserRepository;
import com.example.banking.service.service.TransactionService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public TransactionEntity transferMoney(Long senderId, Long receiverId, Double amount) {
        UserEntity sender = userRepository.findById(senderId).orElseThrow( () -> new UserNotFoundException("Sender Not Found"));
        UserEntity receiver = userRepository.findById(senderId).orElseThrow( () -> new UserNotFoundException("Receiver Not Found"));

        if (sender.getCurrentBalance() < amount) {
            throw new TransferMoneyException("Insufficient balance");
        }

        sender.setCurrentBalance(sender.getCurrentBalance() - amount);
        receiver.setCurrentBalance(receiver.getCurrentBalance() + amount);

        userRepository.save(sender);
        userRepository.save(receiver);

        TransactionEntity transaction = TransactionEntity.builder()
                .senderId(senderId)
                .receiverId(receiverId)
                .amount(amount)
                .transactionDate(new Date())
                .build();

        return transactionRepository.save(transaction);
    }
}
