package com.arya.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arya.domain.Student;
import com.arya.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;

	@RequestMapping("/muni")
	public String sayHello1()
	{
		return "Hello...";
	}
	
	@RequestMapping("/students")
	public ResponseEntity<List<Student>> getStudents()
	{
		HttpHeaders responseHeaders = new HttpHeaders();
		return new ResponseEntity<List<Student>>(studentService.getStudentList(), responseHeaders, HttpStatus.OK);
	}
	
}
