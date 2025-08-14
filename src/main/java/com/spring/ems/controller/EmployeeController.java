package com.spring.ems.controller;

import com.spring.ems.entity.Employee;
import com.spring.ems.service.EmployeeService;
import com.spring.ems.utility.ResponseStructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // 1️⃣ Create Employee
    @PostMapping
    public ResponseEntity<ResponseStructure<Employee>> addEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeService.addEmployee(employee);

        ResponseStructure<Employee> rs = new ResponseStructure<>();
        rs.setStatusCode(HttpStatus.CREATED.value());
        rs.setMessage("Employee created successfully");
        rs.setData(savedEmployee);

        return new ResponseEntity<>(rs, HttpStatus.CREATED);
    }

    // 2️⃣ Get All Employees
    @GetMapping
    public ResponseEntity<ResponseStructure<List<Employee>>> getAllEmployees() {
        List<Employee> employees = employeeService.findAllEmployees();

        ResponseStructure<List<Employee>> rs = new ResponseStructure<>();
        rs.setStatusCode(HttpStatus.OK.value());
        rs.setMessage("Employees fetched successfully");
        rs.setData(employees);

        return new ResponseEntity<>(rs, HttpStatus.OK);
    }

    // 3️⃣ Get Employee by ID
    @GetMapping("/{id}")
    public ResponseEntity<ResponseStructure<Employee>> getEmployeeById(@PathVariable int id) {
        Employee employee = employeeService.findByEmployeeId(id);

        ResponseStructure<Employee> rs = new ResponseStructure<>();
        rs.setStatusCode(HttpStatus.OK.value());
        rs.setMessage("Employee fetched successfully");
        rs.setData(employee);

        return new ResponseEntity<>(rs, HttpStatus.OK);
    }

    // 4️⃣ Update Employee by ID
    @PutMapping("/{id}")
    public ResponseEntity<ResponseStructure<Employee>> updateEmployeeById(
            @PathVariable int id,
            @RequestBody Employee updatedEmployee) {

        Employee employee = employeeService.updateById(id, updatedEmployee);

        ResponseStructure<Employee> rs = new ResponseStructure<>();
        rs.setStatusCode(HttpStatus.OK.value());
        rs.setMessage("Employee updated successfully");
        rs.setData(employee);

        return new ResponseEntity<>(rs, HttpStatus.OK);
    }

    // 5️⃣ Delete Employee by ID (your snippet integrated)
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseStructure<String>> deleteEmployeeById(@PathVariable int id) {
        Employee deletedEmployee = employeeService.deleteByEmployeeId(id);

        ResponseStructure<String> rs = new ResponseStructure<>();
        if (deletedEmployee != null) {
            rs.setStatusCode(HttpStatus.OK.value());
            rs.setMessage("Employee deleted successfully");
            rs.setData("Deleted employee with ID: " + id);
            return new ResponseEntity<>(rs, HttpStatus.OK);
        } else {
            rs.setStatusCode(HttpStatus.NOT_FOUND.value());
            rs.setMessage("Employee not found");
            rs.setData("No employee found with ID: " + id);
            return new ResponseEntity<>(rs, HttpStatus.NOT_FOUND);
        }
    }

    // 6️⃣ Fetch by Designation
    @GetMapping("/designation/{designation}")
    public ResponseEntity<ResponseStructure<List<Employee>>> getByDesignation(@PathVariable String designation) {
        List<Employee> employees = employeeService.fetchByEmployeeDesignation(designation);

        ResponseStructure<List<Employee>> rs = new ResponseStructure<>();
        rs.setStatusCode(HttpStatus.OK.value());
        rs.setMessage("Employees fetched successfully by designation");
        rs.setData(employees);

        return new ResponseEntity<>(rs, HttpStatus.OK);
    }

    // 7️⃣ Fetch by Salary Range
    @GetMapping("/salary/{min}/{max}")
    public ResponseEntity<ResponseStructure<List<Employee>>> getBySalaryRange(
            @PathVariable int min,
            @PathVariable int max) {

        List<Employee> employees = employeeService.fetchBySalaryBetween(min, max);

        ResponseStructure<List<Employee>> rs = new ResponseStructure<>();
        rs.setStatusCode(HttpStatus.OK.value());
        rs.setMessage("Employees fetched successfully by salary range");
        rs.setData(employees);

        return new ResponseEntity<>(rs, HttpStatus.OK);
    }

    // 8️⃣ Fetch by Email
    @GetMapping("/email/{email}")
    public ResponseEntity<ResponseStructure<List<Employee>>> getByEmail(@PathVariable String email) {
        List<Employee> employees = employeeService.findByEmployeeEmail(email);

        ResponseStructure<List<Employee>> rs = new ResponseStructure<>();
        rs.setStatusCode(HttpStatus.OK.value());
        rs.setMessage("Employees fetched successfully by email");
        rs.setData(employees);

        return new ResponseEntity<>(rs, HttpStatus.OK);
    }

    // 9️⃣ Fetch by Title
    @GetMapping("/title/{title}")
    public ResponseEntity<ResponseStructure<List<Employee>>> getByTitle(@PathVariable String title) {
        List<Employee> employees = employeeService.fetchByEmployeeTitle(title);

        ResponseStructure<List<Employee>> rs = new ResponseStructure<>();
        rs.setStatusCode(HttpStatus.OK.value());
        rs.setMessage("Employees fetched successfully by title");
        rs.setData(employees);

        return new ResponseEntity<>(rs, HttpStatus.OK);
    }
}
