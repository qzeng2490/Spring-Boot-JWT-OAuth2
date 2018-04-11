package com.qzeng2018.springreact.repository;

import com.qzeng2018.springreact.Entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User, String> {
    User findByUsername(String username);
}