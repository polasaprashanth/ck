package com.example.Audit_manager.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Audit_manager.exception.ResourceNotFoundException;
import com.example.Audit_manager.model.Employee;
import com.example.Audit_manager.repository.EmployeeRepository;


@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	
	@GetMapping("/getallemployees")
	public List<Employee> getAllUsers() {
		return employeeRepository.findAll();
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<Employee> getUserById(
			@PathVariable(value = "id") Long userId) throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(userId)
        .orElseThrow(() -> new ResourceNotFoundException("User not found :: " + userId));
		return ResponseEntity.ok().body(employee);
	}

	@PostMapping("/createemployee")
	public Employee createUser(@Valid @RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}

	@PutMapping("/users/{id}")
	public ResponseEntity<Employee> updateUser(
			@PathVariable(value = "id") Long userId,
			@Valid @RequestBody Employee userDetails) throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(userId)
		        .orElseThrow(() -> new ResourceNotFoundException("User not found :: " + userId));
		
		employee.setEmailId(userDetails.getEmailId());
		employee.setLastName(userDetails.getLastName());
		employee.setFirstName(userDetails.getFirstName());
		
		final Employee updatedUser = employeeRepository.save(employee);
		return ResponseEntity.ok(updatedUser);
	}

	@DeleteMapping("/users/{id}")
	public Map<String, Boolean> deleteUser(
			@PathVariable(value = "id") Long userId) throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(userId)
		        .orElseThrow(() -> new ResourceNotFoundException("User not found :: " + userId));

		employeeRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
}
