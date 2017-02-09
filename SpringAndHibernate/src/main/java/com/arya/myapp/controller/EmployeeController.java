package com.arya.myapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.arya.myapp.exceptions.CustomGenericException;
import com.arya.myapp.exceptions.ErrorResponse;
import com.arya.myapp.model.Employee;
import com.arya.myapp.service.EmployeeService;

@Controller
@RequestMapping(value = "employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public String findAllEmployees(Model model) {
		model.addAttribute("employees", employeeService.findAllEmployees());
		return "employeeList";
	}

	/*@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<String> saveEmployee(@RequestBody Employee employee) throws DataIntegrityViolationException {
		employeeService.saveEmployee(employee);
		return new ResponseEntity<String>("Employee added successfully.", HttpStatus.CREATED);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> saveEmployee(@PathVariable Integer id) {
		employeeService.deleteEmployeeById(id);
		HttpHeaders responseHeaders = new HttpHeaders();
		// ok 200 sucess, 204 for no content
		return new ResponseEntity<String>("Employee deleted successfully.", responseHeaders, HttpStatus.OK);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity<String> updateEmployee(@RequestBody Employee employee) {
		employeeService.updateEmployee(employee);
		HttpHeaders responseHeaders = new HttpHeaders();
		return new ResponseEntity<String>("Employee updated successfully.", responseHeaders, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Employee> updateEmployee(@PathVariable Integer id) {
		HttpHeaders responseHeaders = new HttpHeaders();
		return new ResponseEntity<Employee>(employeeService.findById(id), responseHeaders, HttpStatus.OK);
	}

	@RequestMapping(value = "/greet", method = RequestMethod.GET)
	public String sayHello(@RequestParam("name") String name) {
		return employeeService.sayHello(name);
	}

	// Convert a predefined exception to an HTTP Status code
	@ExceptionHandler(CustomGenericException.class)
	public ResponseEntity<ErrorResponse> handleConflict(HttpServletRequest request, CustomGenericException ex) {
		// If you are trying to add duplicate employee this method will be
		// called. 
		ErrorResponse error = new ErrorResponse();
		error.setStatusCode(ex.getErrStatusCode());
		error.setApiCode(ex.getErrApiCode());
		error.setMessage(ex.getErrMsg());
		error.setDeveloperMessage(ex.getCause().toString());
		error.setUrl(request.getRequestURL().toString());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.valueOf(Integer.valueOf(ex.getErrStatusCode())));
	}*/
	
}
