package com.techprimers.jpa.springdatajpahibernateexample.resource;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class Users {

	@Id
	private Integer id;
	private String name;
	private Integer salary;

	public Users() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

}
