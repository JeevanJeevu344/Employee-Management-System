package com.spring.ems.exception;

public class EmployeeNotFoundByEmailException extends RuntimeException {
    public EmployeeNotFoundByEmailException(String message) {
        super(message);
    }
}
