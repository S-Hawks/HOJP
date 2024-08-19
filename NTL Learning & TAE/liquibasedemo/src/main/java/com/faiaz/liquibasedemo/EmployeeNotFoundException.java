package com.faiaz.liquibasedemo;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(String message){
        super(message);
    }
    public EmployeeNotFoundException(String message, Throwable cause){
        super(message, cause);
    }
}