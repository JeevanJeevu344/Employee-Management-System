package com.spring.ems.exception;

public class EmployeeNotFoundByIdException extends RuntimeException {
    public EmployeeNotFoundByIdException(String message) {
        super(message);
    }
}
