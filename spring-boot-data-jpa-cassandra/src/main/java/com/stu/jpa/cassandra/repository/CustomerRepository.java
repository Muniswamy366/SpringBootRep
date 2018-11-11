package com.stu.jpa.cassandra.repository;

import java.util.List;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import com.stu.jpa.cassandra.entity.Customer;

@Repository
public interface CustomerRepository extends ExtendedRepository<Customer, Long>/* CrudRepository<Customer, String> */ {

	@Query(value = "SELECT * FROM customer WHERE firstname=?0")
	public List<Customer> findByFirstname(String firstname);

	@Query("SELECT * FROM customer WHERE age > ?0 ALLOW FILTERING")
	public List<Customer> findCustomerHasAgeGreaterThan(int age);
}