package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.Employee;
import com.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository repository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository repository) {
		this.repository=repository;
	}
	
	@Override
	public List<Employee> getAllEmployees() {
		return repository.findAll();
	}

	@Override
	public Optional<Employee> getEmployeeByName(String name) {
		return repository.findByName(name);
	}

	@Override
	public Optional<Employee> getEmployeeById(String id) {
		return repository.findById(id);	
	}
}
