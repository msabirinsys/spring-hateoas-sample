package com.demo.repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.demo.model.Employee;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {
	private Logger logger=LoggerFactory.getLogger(EmployeeRepositoryImpl.class);
	
	private List<Employee> employees=Arrays.asList(new Employee[]{
			new Employee("brad", "Brad Starkenberg", "Pivotal Practice"),
			new Employee("msabir", "Muhammad Sabir", "Pivotal Practice"),
			new Employee("eric", "Eric Pereira", "Pivotal Practice"),
			new Employee("kris", "Kris Krishna", "Pivotal Practice")
			});
	
	@Override
	public List<Employee> findAll() {
		logger.debug("Returning all employees****************");
		return employees;
	}

	@Override
	public Optional<Employee> findByName(String name) {
		logger.debug("Find employee by name ****************** " + name);
		Optional<Employee> employee=employees.stream().filter(emp->emp.getName().equals(name)).findFirst();
		logger.debug("Employee found " + employee.isPresent());
		return employee;
	}

	@Override
	public Optional<Employee> findById(String id) {
		logger.debug("Find employee by id ****************** " + id);
		Optional<Employee> employee=employees.stream().filter(emp->emp.getId().equals(id)).findFirst();
		logger.debug("Employee found " + employee.isPresent());
		return employee;
	}
}
