/**
 * Author: Collin Gee
 * Created: 12/7/2023
 * Summary: This file implements the EmployeeService
 *          Add business logic to this file
 *          Calls the EmployeeRepository for database calls
 **/

package com.collingee.microsoft_crud_microservice.service;
 
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.collingee.microsoft_crud_microservice.entity.Employee;
import com.collingee.microsoft_crud_microservice.repository.EmployeeRepository;
 
// Implements the Employee Service Interface
@Service 
public class EmployeeServiceImpl implements EmployeeService {
 
    @Autowired
    private EmployeeRepository employeeRepository;
 
    // Save operation
    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
 
    // Read all Employees
    @Override public List<Employee> readAllEmployees() {
        return (List<Employee>) employeeRepository.findAll();
    }

    // Read 1 Employee
    @Override public Optional<Employee> readEmployeeById(Long employeeId) {
        return employeeRepository.findById(employeeId);
    }
 
    // Update operation
    @Override
    public Employee updateEmployee(Employee employee, Long employeeId) {
        Optional<Employee> dbEmployeeOptional = employeeRepository.findById(employeeId);
        if (dbEmployeeOptional.isPresent()) {
            // Employee exists, continue to update
            employee.setEmployeeId(employeeId);
            return employeeRepository.save(employee);
        } else {
            // Employee does not exist, return null
            return null;
        }
    }
 
    // Delete Employee
    @Override
    public void deleteEmployeeById(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }
}