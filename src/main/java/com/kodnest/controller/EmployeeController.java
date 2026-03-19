package com.kodnest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodnest.entity.Employee;
import com.kodnest.service.EmployeeService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/employees")
public class EmployeeController {

	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping
	public Employee createEmployee(@RequestBody Employee employee) {
	return employeeService.createEmployee(employee);
	}
	
	@GetMapping
	public List<Employee> getAllEmployee() {
		return employeeService.getAllEmployee();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {
		Employee employee = employeeService.getEmployeeById(id);
		return employee != null ? ResponseEntity.ok(employee) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public String deleteEmployee(@PathVariable int id) {
		employeeService.deleteEmployee(id);
		return "Employee deleted succeesfully!";
	}
}
