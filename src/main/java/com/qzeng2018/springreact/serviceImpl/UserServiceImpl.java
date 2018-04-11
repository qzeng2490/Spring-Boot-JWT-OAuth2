package com.qzeng2018.springreact.serviceImpl;

import com.qzeng2018.springreact.Entity.User;
import com.qzeng2018.springreact.repository.EmployeeRepository;
import com.qzeng2018.springreact.repository.UserRepository;
import com.qzeng2018.springreact.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getById(String id) {
        return userRepository.findById(id);
    }
}
