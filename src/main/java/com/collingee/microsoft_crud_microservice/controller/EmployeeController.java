/**
 * Author: Collin Gee
 * Created: 12/7/2023
 * Summary: This file handles the REST CRUD actions (create, read, update and delete)
 **/

package com.collingee.microsoft_crud_microservice.controller;

import java.util.List;
import java.util.Optional;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.collingee.microsoft_crud_microservice.entity.Employee;
import com.collingee.microsoft_crud_microservice.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired private EmployeeService employeeService;

    // Create
	@PostMapping("/employee")
	public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee) {
        try { 
            // Return created Employee
            return ResponseEntity.ok().body(employeeService.createEmployee(employee));
        } catch (Exception e) {
            // Error in createEmployee
            return ResponseEntity.internalServerError().body(null);
        }
	}

    // Read all Employees
    @GetMapping("/employee")
    public ResponseEntity<List<Employee>> readAllEmployees() {
        try { 
            List<Employee> employeeList = employeeService.readAllEmployees();
            if (employeeList.isEmpty()) {
                // No Employees in the database
                return ResponseEntity.noContent().build();
            } else {
                // Successfully read all Employees from database
                return ResponseEntity.ok().body(employeeList);
            }
        } catch (Exception e) {
            // Error in readAllEmployees
            return ResponseEntity.internalServerError().body(null);
        }        
    }

    // Read 1 Employee By ID
    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> readEmployeeById(@PathVariable("id") Long employeeId) {
        try { 
            Optional<Employee> updatedEmployee = employeeService.readEmployeeById(employeeId);
            if (updatedEmployee.isPresent()){
                // Succesfully found Employee
                return ResponseEntity.ok().body(updatedEmployee.get());
            } else {
                // Failed to find Employee in database
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            // Error in readEmployeeById
            return ResponseEntity.internalServerError().body(null);
        }
    }

    // Update Employee
    @PutMapping("/employee/{id}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable("id") Long employeeId) {
        try { 
            Employee updatedEmployee = employeeService.updateEmployee(employee, employeeId);
            if (updatedEmployee == null) {
                // Employee not found
                return ResponseEntity.notFound().build();
            } else {
                // Successfully found Employee
                return ResponseEntity.ok().body(updatedEmployee);
            }
        } catch (Exception e) {
            // Error in updateEmployee
            return ResponseEntity.badRequest().body(null);
        }        
    }

    // Delete Employee
    @DeleteMapping("/employee/{id}")
    public ResponseEntity<HttpStatus> deleteEmployeeById(@PathVariable("id") Long employeeId) {
        try { 
            employeeService.deleteEmployeeById(employeeId);
            // Successfully deleted Employee
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            // Error in deleteEmployeeById
            return ResponseEntity.internalServerError().body(null);
        }           
    }
}