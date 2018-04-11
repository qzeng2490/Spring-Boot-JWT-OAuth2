package com.qzeng2018.springreact;

import com.qzeng2018.springreact.Entity.Employee;
import com.qzeng2018.springreact.Entity.User;
import com.qzeng2018.springreact.repository.EmployeeRepository;
import com.qzeng2018.springreact.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private final EmployeeRepository repository;
    private final UserRepository repository2;

    @Autowired
    public DatabaseLoader(EmployeeRepository repository,UserRepository repository2) {

        this.repository = repository;
        this.repository2 = repository2;
    }

    @Override
    public void run(String... strings) throws Exception {
        this.repository.save(new Employee("Frodo", "Baggins", "ring bearer"));
        String encodePwd = new BCryptPasswordEncoder().encode("1");

        System.out.println("User save to DB----------------------" + encodePwd);

        this.repository2.save(new User("zeng",encodePwd));
    }
}