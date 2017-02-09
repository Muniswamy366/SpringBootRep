package com.arya.myapp.service;

import java.util.List;

import com.arya.myapp.model.Employee;

public interface EmployeeService {

	void saveEmployee(Employee employee);

	List<Employee> findAllEmployees();

	void deleteEmployeeById(int id);

	Employee findById(int id);

	void updateEmployee(Employee employee);
	
	public String sayHello(String name);
}
