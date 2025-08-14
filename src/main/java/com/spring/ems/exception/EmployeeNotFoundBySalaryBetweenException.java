package com.spring.ems.exception;

public class EmployeeNotFoundBySalaryBetweenException extends RuntimeException {
    public EmployeeNotFoundBySalaryBetweenException(String message) {
        super(message);
    }
}
