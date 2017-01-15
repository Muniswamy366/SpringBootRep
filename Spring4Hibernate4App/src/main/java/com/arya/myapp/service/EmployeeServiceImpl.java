package com.arya.myapp.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.arya.myapp.dao.EmployeeDao;
import com.arya.myapp.exceptions.CustomGenericException;
import com.arya.myapp.exceptions.EmployeeNotFoundException;
import com.arya.myapp.model.Employee;

@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
	
	private static final Logger logger = Logger.getLogger(EmployeeServiceImpl.class);

	@Autowired
	private EmployeeDao employeeDao;
	
	public void saveEmployee(Employee employee) {
		logger.info("saveEmployee() -- START");
		try {
			employeeDao.saveEmployee(employee);
		} catch (DataAccessException e) {
			logger.error("saveEmployee() excetpion while saving employee.. ",e);
			throw new CustomGenericException("Employee already exist with id " + employee.getId(), HttpStatus.CONFLICT.toString(), 
					HttpStatus.CONFLICT.toString(),e);
		}
		logger.info("saveEmployee() -- END");
	}

	public List<Employee> findAllEmployees() {
		return employeeDao.findAllEmployees();
	}

	public void deleteEmployeeById(int id) {
		try {
			employeeDao.deleteEmployeeById(id);
		} catch (EmployeeNotFoundException e) {
			logger.error("deleteEmployeeById() excetpion while deleting employee.. ",e);
			throw new CustomGenericException(e.getMessage(), HttpStatus.NOT_FOUND.toString(), HttpStatus.NOT_FOUND.toString(), e);
		}
	}

	public Employee findById(int id) {
		return employeeDao.findById(id);
	}

	public void updateEmployee(Employee employee){
		employeeDao.updateEmployee(employee);
	}
	
	public String sayHello(String name) {
		try {
			if (name == null || name.isEmpty()) {
				// http://localhost:8080/employee/greet?name
				throw new IllegalArgumentException("The 'name' parameter must not be null or empty");
			}
			if (StringUtils.isNumeric(name)) {
				throw new IllegalArgumentException("Invalid employee name requested");
			}
		} catch (CustomGenericException e) {
			logger.error("sayHello() excetpion in sayHello() method ",e);
			throw new CustomGenericException(e.getMessage(), HttpStatus.BAD_REQUEST.toString(), HttpStatus.BAD_REQUEST.toString(), e);
		}
		return String.format("Hello %s!", name);
	}
}
