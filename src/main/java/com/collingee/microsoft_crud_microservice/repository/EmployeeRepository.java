/**
 * Author: Collin Gee
 * Created: 12/7/2023
 * Summary: This file provides an interface for the 4 CRUD actions (create, read, update and delete)
 **/

 package com.collingee.microsoft_crud_microservice.repository;

import org.springframework.data.repository.CrudRepository;
import com.collingee.microsoft_crud_microservice.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long>{

} 