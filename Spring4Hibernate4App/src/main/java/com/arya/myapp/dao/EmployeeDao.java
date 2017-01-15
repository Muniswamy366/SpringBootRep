package com.arya.myapp.dao;

import java.util.List;

import com.arya.myapp.exceptions.EmployeeNotFoundException;
import com.arya.myapp.model.Employee;

public interface EmployeeDao {

	void saveEmployee(Employee employee);
	
	List<Employee> findAllEmployees();
	
	void deleteEmployeeById(int id) throws EmployeeNotFoundException;
	
	Employee findById(int id);
	
	void updateEmployee(Employee employee);
}
