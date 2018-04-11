package com.qzeng2018.springreact.controller;

import com.qzeng2018.springreact.Entity.Employee;
import com.qzeng2018.springreact.request.BaseDeleteReq;
import com.qzeng2018.springreact.request.EmployeeReq;
import com.qzeng2018.springreact.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/employee")
@PreAuthorize("hasRole('AAA')")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping(value = "/save")
    public Employee save(@RequestBody Employee motorVehicleOwner) {
        motorVehicleOwner = employeeService.save(motorVehicleOwner);
        return motorVehicleOwner;
    }

    @PostMapping(value = "/delete")
    public void delete(@RequestBody BaseDeleteReq baseDeleteReq) {
        employeeService.delete(baseDeleteReq.getId());
    }

    @PostMapping(value = "/getById")
    public Optional<Employee> getById(@RequestBody EmployeeReq employeeQueryReq) {
        Optional<Employee> employee = employeeService.getById(employeeQueryReq.getId());
        return employee;
    }

    @PostMapping(value = "/getAll")
    public List<Employee> getAll() {
        List<Employee> employees = employeeService.getAll();
        return employees;
    }
}
