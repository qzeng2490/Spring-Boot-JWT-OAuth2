package com.qzeng2018.springreact.serviceImpl;

import com.qzeng2018.springreact.Entity.Role;
import com.qzeng2018.springreact.repository.RoleRepository;
import com.qzeng2018.springreact.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Optional<Role> getById(String id) {
        return roleRepository.findById(id);
    }
}
