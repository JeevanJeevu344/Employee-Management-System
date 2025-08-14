package com.spring.ems.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring.ems.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // JPQL by designation
    @Query("FROM Employee e WHERE e.designation = ?1")
    List<Employee> fetchByEmployeeDesignation(String designation);

    // Native SQL query for salary range
    @Query(value = "SELECT * FROM employee WHERE salary BETWEEN ?1 AND ?2", nativeQuery = true)
    List<Employee> fetchBySalaryBetween(int salary1, int salary2);

    // Derived query by email
    List<Employee> findByEmail(String email);
    
    List<Employee> findByDesignation(String designation);
    
    @Query("SELECT e FROM Employee e WHERE e.title = :title")
    List<Employee> fetchByEmployeeTitle(@Param("title") String title);



}
