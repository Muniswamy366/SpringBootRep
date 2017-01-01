package com.arya.DB;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.arya.domain.Student;

@Component("oracleDB")
public class OracleDB {

	List<Student> students = new ArrayList<Student>();
			
	public OracleDB()
	{
		students.add(new Student(1, "muni", 22, 111.0));
		students.add(new Student(2, "swamy", 23, 22.0));
		students.add(new Student(3, "palla", 24, 333.0));
		students.add(new Student(4, "arya", 25, 444.0));
		students.add(new Student(5, "admin web", 26, 555.0));
	}
	
	public List<Student> getStudentsFromDB()
	{
		return students;
	}

}
