package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domains.Employee;
import com.example.demo.repositories.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repository;
	
	public List<Employee> getAll(){
		return repository.findAll();
	}
	
	public void save(Employee employee) {
		repository.save(employee);
	}
	
	public Employee get(Integer dni) {
		return repository.findById(dni).get();
	}
	
	public void delete(Integer dni) {
		repository.deleteById(dni);
	}
}
