package com.arya.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.arya.DB.OracleDB;
import com.arya.dao.StudentDao;
import com.arya.domain.Student;

@Repository("studentDao")
public class StudentDaoImpl implements StudentDao{

	@Autowired
	private OracleDB oracleDB;
	
	@Override
	public List<Student> getListOfStudents() {
		return oracleDB.getStudentsFromDB();
	}

	
}
