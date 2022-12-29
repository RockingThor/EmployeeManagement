package com.spring.project1.EmployeeManager;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.project1.EmployeeManager.model.Employee;
import com.spring.project1.EmployeeManager.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeResource {
	private final EmployeeService service;

	public EmployeeResource(EmployeeService service) {
		super();
		this.service = service;
	}

	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployee() {
		List<Employee> employees = service.allEmployee();
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}

	@GetMapping("/find/{Id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("Id") Long Id) {
		Employee emp = service.findEmployeeById(Id);
		return new ResponseEntity<>(emp, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
		Employee emp=service.addEmployee(employee);
		return new ResponseEntity<>(emp,HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
		Employee emp=service.updateEmployee(employee);
		return new ResponseEntity<>(emp,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{Id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable("Id") Long Id){
		service.deleteEmployeeById(Id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	

}
