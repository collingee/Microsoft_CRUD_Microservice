/**
 * Author: Collin Gee
 * Created: 12/7/2023
 * Summary: This Pojo file contains the structure of the Employee class
 **/

package com.collingee.microsoft_crud_microservice.entity;

import jakarta.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

// Employee Pojo
@Entity
public class Employee {

    // Primary Key of database
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long employeeId;

    @NotNull(message = "First name cannot be null")
    private String firstName;

    @NotNull(message = "Last name cannot be null")
    private String lastName;

    @NotNull(message = "Department cannot be null")
    private String department;

    @NotNull(message = "Activity status cannot be null")
    private boolean isActive;

    @PositiveOrZero(message = "Salary cannot be negative")
    private int salary;

    Employee(){}

    Employee(Long employeeId, String firstName, String lastName, String department, boolean isActive, int salary) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.isActive = isActive;
        this.salary = salary;
    }

    public Long getEmployeeId(){
        return employeeId;
    }

    public void setEmployeeId(Long employeeID){
        this.employeeId = employeeID;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getDepartment(){
        return department;
    }

    public void setDepartment(String department){
        this.department = department;
    }

    public boolean getIsActive(){
        return isActive;
    }

    public void setIsActive(boolean isActive){
        this.isActive = isActive;
    }

    public int getSalary(){
        return salary;
    }

    public void setSalary(int salary){
        this.salary = salary;
    }
}
