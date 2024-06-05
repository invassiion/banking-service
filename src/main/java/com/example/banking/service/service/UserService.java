package com.example.banking.service.service;

import com.example.banking.service.model.UserEntity;

import java.util.Optional;


public interface UserService {
    Optional<UserEntity> findUserById(Long id);
    Optional<UserEntity> findUserByUsername(String username);
    UserEntity createUser(UserEntity userEntity);
    UserEntity updateUser(UserEntity userEntity);
    void deleteUser(Long id);
}
