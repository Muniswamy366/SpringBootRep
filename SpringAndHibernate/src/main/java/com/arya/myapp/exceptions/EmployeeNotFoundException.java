package com.arya.myapp.exceptions;

public class EmployeeNotFoundException extends Exception {

	private static final long serialVersionUID = -5650001909533862839L;
	
	public EmployeeNotFoundException(String msg){
		super(msg);
	}
}
