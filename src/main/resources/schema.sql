/**
 * Author: Collin Gee
 * Created: 12/7/2023
 * Summary: This file handles the creation of the Employee table in the database
 **/

create table Employee(
    employeeId bigint auto_increment,
    firstName varchar(255) NOT NULL,
    lastName varchar(255) NOT NULL,
    department varchar(255) NOT NULL,
    isActive boolean NOT NULL,
    salary int varchar(255) NOT NULL
);