package com.qzeng2018.springreact.serviceImpl;

import com.qzeng2018.springreact.Entity.Employee;
import com.qzeng2018.springreact.repository.EmployeeRepository;
import com.qzeng2018.springreact.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{


        @Autowired
        private EmployeeRepository employeeRepository;

        @Override
        public Employee save(Employee motorVehicleOwner) {
            return employeeRepository.save(motorVehicleOwner);
        }

        @Override
        public void delete(String id) {
            employeeRepository.deleteById(id);
        }

        @Override
        public List<Employee> getAll() {
            return (List<Employee>) employeeRepository.findAll();
        }

        @Override
        public Optional<Employee> getById(String id) {
            return employeeRepository.findById(id);
        }

}
