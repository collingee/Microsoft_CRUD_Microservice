/**
 * Author: Collin Gee
 * Created: 12/7/2023
 * Summary: This file provides an interface for the 4 CRUD actions (create, read, update and delete)
 **/

 package com.collingee.microsoft_crud_microservice.employee;

import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long>{

} 