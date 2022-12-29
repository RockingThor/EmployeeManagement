package com.spring.project1.EmployeeManager.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.project1.EmployeeManager.exception.UserNotFoundException;
import com.spring.project1.EmployeeManager.model.Employee;
import com.spring.project1.EmployeeManager.model.EmployeeRepository;

@Service
public class EmployeeService {
	private final EmployeeRepository employeeRepo;

	@Autowired
	public EmployeeService(EmployeeRepository employeeRepo) {
		super();
		this.employeeRepo = employeeRepo;
		employeeRepo.save(new Employee("Daniel Craig","danielcraig@gmail.com",
				"Senior Dev Engineer","+919678345678","https://bootdey.com/img/Content/avatar/avatar1.png","#7894"));
		employeeRepo.save(new Employee("Ryan Renolds","ryanrenolds@gmail.com",
				"Full Stack Dev","+9197483894327","https://bootdey.com/img/Content/avatar/avatar2.png","#7894"));
		employeeRepo.save(new Employee("Tony Stark","starktony@gmail.com",
				"Product Manager","+919678345690","https://bootdey.com/img/Content/avatar/avatar4.png","#7894"));
		
	} 

	public Employee addEmployee(Employee employee) {
		employee.setEmployeeCode(UUID.randomUUID().toString());
		return employeeRepo.save(employee);
	}

	public List<Employee> allEmployee() {
		return employeeRepo.findAll();
	}

	public Employee updateEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}

	public void deleteEmployeeById(Long id) {
		employeeRepo.deleteById(id);
	}

	public Employee findEmployeeById(Long id) {
		Employee emp = employeeRepo.findById(id)
				.orElseThrow(()-> new UserNotFoundException("user by id "+id+"was not found"));
		return emp;
	}
	
}
