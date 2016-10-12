package com.demo.repository;

import java.util.List;
import java.util.Optional;

import com.demo.model.Employee;

public interface EmployeeRepository {
	List<Employee> findAll();
	Optional<Employee> findById(String id);
	Optional<Employee> findByName(String name);
}
