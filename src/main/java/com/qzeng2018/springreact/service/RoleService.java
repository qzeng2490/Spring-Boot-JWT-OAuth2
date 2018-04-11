package com.qzeng2018.springreact.service;

import com.qzeng2018.springreact.Entity.Employee;
import com.qzeng2018.springreact.Entity.Role;

import java.util.Optional;

public interface RoleService  {
    Role save(Role role);
    Optional<Role> getById(String id);
}
