package com.qzeng2018.springreact.service;

import com.qzeng2018.springreact.Entity.User;

import java.util.Optional;

public interface UserService {
    User findByUsername(String username);
    User save(User user);
    Optional<User> getById(String id);
}
