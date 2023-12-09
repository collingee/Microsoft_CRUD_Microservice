# Microsoft_CRUD_Microservice
Setup: [Link to Spring and Java Setup with Visual Studio Code](https://code.visualstudio.com/docs/java/java-spring-boot#:~:text=To%20install%2C%20launch%20VS%20Code,and%20then%20follow%20the%20wizard.)

This repository holds the code responsible for handling CRUD actions for billions of employees with high RPS. Take Home Exam for Microsoft job. See "Collin Gee Technical Document.docx" for the technical documentation.

Import the "Microsoft CRUD API Testing.postman_collection" file into [Postman](https://www.postman.com/downloads/) for working examples of each CRUD action.

JSON example to include in http body for create and update
{
    "employeeId": 128,
    "firstName": "updated",
    "lastName": "updated",
    "department": "updated",
    "isActive": false,
    "salary": 1234
}
