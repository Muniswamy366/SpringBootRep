package com.stu.jpa.cassandra.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface ExtendedRepository<T, ID extends Serializable> extends CrudRepository<T, ID> {

	public List<T> findAllCustomers(String firstName);
}