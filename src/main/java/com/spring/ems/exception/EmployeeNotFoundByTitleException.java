package com.spring.ems.exception;

public class EmployeeNotFoundByTitleException extends RuntimeException {
    public EmployeeNotFoundByTitleException(String message) {
        super(message);
    }
}
