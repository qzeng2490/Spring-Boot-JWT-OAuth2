package com.qzeng2018.springreact.controller;

import com.qzeng2018.springreact.Entity.Employee;
import com.qzeng2018.springreact.Entity.User;
import com.qzeng2018.springreact.request.EmployeeReq;
import com.qzeng2018.springreact.request.UserReq;
import com.qzeng2018.springreact.service.EmployeeService;
import com.qzeng2018.springreact.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/signup")
    public User save(@RequestBody User user) {
        user = userService.save(user);
        return user;
    }

    @PostMapping(value = "/getById")
    public Optional<User> getById(@RequestBody UserReq userQueryReq) {
        Optional<User> user = userService.getById(userQueryReq.getId());
        return user;
    }

}
