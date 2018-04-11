package com.qzeng2018.springreact.repository;

import com.qzeng2018.springreact.Entity.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, String> {

}