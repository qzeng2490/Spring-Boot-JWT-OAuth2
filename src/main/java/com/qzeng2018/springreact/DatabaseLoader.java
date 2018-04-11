package com.qzeng2018.springreact;

import com.qzeng2018.springreact.Entity.Employee;
import com.qzeng2018.springreact.Entity.Role;
import com.qzeng2018.springreact.Entity.User;
import com.qzeng2018.springreact.repository.EmployeeRepository;
import com.qzeng2018.springreact.repository.RoleRepository;
import com.qzeng2018.springreact.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private final EmployeeRepository repositoryEmployee;
    private final UserRepository repositoryUser;
    private final RoleRepository repositoryRole;

    @Autowired
    public DatabaseLoader(EmployeeRepository repository,UserRepository repository2,RoleRepository repository3) {

        this.repositoryEmployee = repository;
        this.repositoryUser = repository2;
        this.repositoryRole = repository3;
    }

    @Override
    public void run(String... strings) throws Exception {
        this.repositoryEmployee.save(new Employee("Frodo", "Baggins", "ring bearer"));
        String encodePwd = new BCryptPasswordEncoder().encode("1");

        System.out.println("User save to DB----------------------" + encodePwd);

        Role r1 = new Role("ROLE_AAA");

        Role r2 = new Role("ROLE_BBB");

        this.repositoryRole.save(r1);
        this.repositoryRole.save(r2);

        User u = new User("zeng",encodePwd);
        u.getRoles().add(r1);

        User t = new User("qiang",encodePwd);
        t.getRoles().add(r2);

        this.repositoryUser.save(u);
        this.repositoryUser.save(t);
    }
}