package com.demo.service;

import java.util.List;
import java.util.Optional;

import com.demo.model.Employee;

public interface EmployeeService {
	List<Employee> getAllEmployees();
	Optional<Employee> getEmployeeById(String id);
	Optional<Employee> getEmployeeByName(String name);
}
