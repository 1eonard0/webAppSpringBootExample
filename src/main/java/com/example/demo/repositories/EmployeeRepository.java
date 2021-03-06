package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domains.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
