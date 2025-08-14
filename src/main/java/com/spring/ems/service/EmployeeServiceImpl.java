package com.spring.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.ems.entity.Employee;
import com.spring.ems.exception.EmployeeNotFoundByEmailException;
import com.spring.ems.exception.EmployeeNotFoundByIdException;
import com.spring.ems.exception.EmployeeNotFoundBySalaryBetweenException;
import com.spring.ems.exception.EmployeeNotFoundByDesignationException;
import com.spring.ems.exception.EmployeeNotFoundByTitleException;
import com.spring.ems.exception.EmployeeNotFoundException;
import com.spring.ems.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Override
    public Employee addEmployee(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public List<Employee> findAllEmployees() {
        List<Employee> employees = repository.findAll();
        if (employees.isEmpty()) {
            throw new EmployeeNotFoundException("No employees found");
        }
        return employees;
    }

    @Override
    public Employee findByEmployeeId(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundByIdException("Employee not found with ID: " + id));
    }

    @Override
    public Employee updateById(int id, Employee updatedEmployee) {
        Employee existingEmployee = repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundByIdException("Employee not found with ID: " + id));

        updatedEmployee.setId(existingEmployee.getId());
        return repository.save(updatedEmployee);
    }

    @Override
    public Employee deleteByEmployeeId(int id) {
        Employee employee = repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundByIdException("Employee not found with ID: " + id));

        repository.delete(employee);
        return employee;
    }

    @Override
    public List<Employee> fetchByEmployeeDesignation(String designation) {
        List<Employee> employees = repository.fetchByEmployeeDesignation(designation);
        if (employees.isEmpty()) {
            throw new EmployeeNotFoundByDesignationException("No employees found with designation: " + designation);
        }
        return employees;
    }

    @Override
    public List<Employee> fetchBySalaryBetween(int salary1, int salary2) {
        List<Employee> employees = repository.fetchBySalaryBetween(salary1, salary2);
        if (employees.isEmpty()) {
            throw new EmployeeNotFoundBySalaryBetweenException(
                    "No employees found between salary range " + salary1 + " and " + salary2);
        }
        return employees;
    }

    @Override
    public List<Employee> findByEmployeeEmail(String email) {
        List<Employee> employees = repository.findByEmail(email);
        if (employees.isEmpty()) {
            throw new EmployeeNotFoundByEmailException("No employees found with email: " + email);
        }
        return employees;
    }

    @Override
    public List<Employee> fetchByEmployeeTitle(String title) {
        List<Employee> employees = repository.fetchByEmployeeTitle(title);
        if (employees.isEmpty()) {
            throw new EmployeeNotFoundByTitleException("No employees found with title: " + title);
        }
        return employees;
    }
}
