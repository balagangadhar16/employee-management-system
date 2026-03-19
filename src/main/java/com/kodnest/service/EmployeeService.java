package com.kodnest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnest.entity.Employee;
import com.kodnest.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}
	
	public Employee getEmployeeById(int id) {
		return employeeRepository.findById(id).orElse(null);
	}
	
	public void deleteEmployee(int id) {
		employeeRepository.deleteById(id);
	}
}
