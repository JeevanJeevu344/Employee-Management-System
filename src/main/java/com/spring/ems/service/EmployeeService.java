package com.spring.ems.service;

import java.util.List;

import com.spring.ems.entity.Employee;

public interface EmployeeService {

    Employee addEmployee(Employee employee);
    List<Employee> findAllEmployees();
    Employee findByEmployeeId(int id);
    Employee updateById(int id, Employee updatedEmployee);
    Employee deleteByEmployeeId(int id);
    List<Employee> fetchByEmployeeDesignation(String designation);
    List<Employee> fetchBySalaryBetween(int salary1, int salary2);
    List<Employee> findByEmployeeEmail(String email);
    List<Employee> fetchByEmployeeTitle(String title);
}
