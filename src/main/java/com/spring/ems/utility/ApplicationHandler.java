package com.spring.ems.utility;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.spring.ems.exception.*;

@RestControllerAdvice
public class ApplicationHandler {

    private ResponseEntity<ErrorStructure<String>> buildErrorResponse(
            String technicalMessage,
            String userFriendlyMessage,
            HttpStatus status) {

        ErrorStructure<String> es = new ErrorStructure<>();
        es.setErrorCode(status.value());
        es.setErrormessage(technicalMessage);  
        es.setError(userFriendlyMessage);      
        return new ResponseEntity<>(es, status);
    }

    @ExceptionHandler({
        EmployeeNotFoundByIdException.class,
        EmployeeNotFoundException.class,
        EmployeeNotFoundByTitleException.class,
        EmployeeNotFoundBySalaryBetweenException.class,
        EmployeeNotFoundByEmailException.class
    })
    public ResponseEntity<ErrorStructure<String>> handleEmployeeNotFoundExceptions(RuntimeException ex) {

        if (ex instanceof EmployeeNotFoundByIdException) {
            return buildErrorResponse(ex.getMessage(), "No employee found with the given ID.", HttpStatus.NOT_FOUND);
        } 
        else if (ex instanceof EmployeeNotFoundByTitleException) {
            return buildErrorResponse(ex.getMessage(), "No employee found with the given job title.", HttpStatus.NOT_FOUND);
        } 
        else if (ex instanceof EmployeeNotFoundBySalaryBetweenException) {
            return buildErrorResponse(ex.getMessage(), "No employee found within the specified salary range.", HttpStatus.NOT_FOUND);
        } 
        else if (ex instanceof EmployeeNotFoundByEmailException) {
            return buildErrorResponse(ex.getMessage(), "No employee found with the given email address.", HttpStatus.NOT_FOUND);
        } 
        else if (ex instanceof EmployeeNotFoundException) {
            return buildErrorResponse(ex.getMessage(), "Employee object is not available in the database.", HttpStatus.NOT_FOUND);
        } 
        else {
            return buildErrorResponse(ex.getMessage(), "An unexpected error occurred while fetching employee data.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
