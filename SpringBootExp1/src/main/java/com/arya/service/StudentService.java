package com.arya.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arya.dao.StudentDao;
import com.arya.domain.Student;

@Service("studentService")
public class StudentService {

	@Autowired
	private StudentDao studentDao;
	
	public List<Student> getStudentList()
	{
		return studentDao.getListOfStudents();
	}
}
