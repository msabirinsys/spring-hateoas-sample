package com.demo.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import com.demo.model.Employee;
import com.demo.model.hateos.EmployeeResource;
import com.demo.service.EmployeeService;

@RestController
public class EmployeeController {
	private Logger logger=LoggerFactory.getLogger(EmployeeController.class);
	private EmployeeService service;
	
	@Autowired
	public EmployeeController(EmployeeService service) {
		this.service=service;
	}
	
	@GetMapping("/employee")
	public ResponseEntity<List<Employee>> getAll() {
		logger.debug("Get all Employees query");
		return ResponseEntity.status(HttpStatus.OK)
				.body(service.getAllEmployees());
	}
	
	@RequestMapping("/employee/{id}")
	public ResponseEntity<EmployeeResource> getEmployeeById(@PathVariable String id) {
		logger.debug("Get Employees by id");
		Optional<Employee> employee=service.getEmployeeById(id);
		EmployeeResource resource=new EmployeeResource(employee.get());
		//Relative link creation based on controller method
		resource.add(linkTo(methodOn(EmployeeController.class).getEmployeeById(id)).withSelfRel());
		
		//Absolute/External link added
		resource.add(new Link("http://semeserver:8080/custom", "custom_link"));
		
		//Add links with different names
		resource.add(Arrays.asList(new Link[]{
				new Link("http://someserver:8080/custom1","custom_link1"),
				new Link("http://someserver:8080/custom2","custom_link2")
			}));
		
		//Add Group of links with same name
		resource.add(Arrays.asList(new Link[]{
				new Link("http://someserver:8080/count1","count_links"),
				new Link("http://someserver:8080/count2","count_links")
			}));
		return ResponseEntity.status(HttpStatus.OK)
				.body(resource);
	}
	
}