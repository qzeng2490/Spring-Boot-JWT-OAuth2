package com.qzeng2018.springreact.service;

import com.qzeng2018.springreact.Entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    Employee save(Employee employee);

    void delete(String id);

    List<Employee> getAll();

    Optional<Employee> getById(String id);

}
