package com.spring.ems.exception;

public class EmployeeNotFoundByDesignationException extends RuntimeException {

    public EmployeeNotFoundByDesignationException(String message) {
        super(message);
    }
}
