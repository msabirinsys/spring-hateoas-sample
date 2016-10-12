package com.demo.model.hateos;

import org.springframework.hateoas.ResourceSupport;

import com.demo.model.Employee;

public class EmployeeResource extends ResourceSupport {
	public Employee employee;
	
	public EmployeeResource(Employee employee) {
		this.employee=employee;
	}
}
