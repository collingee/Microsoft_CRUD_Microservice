/**
 * Author: Collin Gee
 * Created: 12/7/2023
 * Summary: This file provides an interface for the 4 CRUD actions (create, read, update and delete)
 *          This is where the business logic functions should be defined
 **/

package com.collingee.microsoft_crud_microservice.service;

import java.util.List;
import java.util.Optional;
import com.collingee.microsoft_crud_microservice.entity.Employee;

// Interface for the 4 CRUD actions (create, read, update and delete)
public interface EmployeeService {
    Employee createEmployee(Employee employee);

    List<Employee> readAllEmployees();

    Optional<Employee> readEmployeeById(Long employeeId);
 
    Employee updateEmployee(Employee employee, Long employeeId);
 
    void deleteEmployeeById(Long employeeId);
}