package com.daniel.coupons.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.daniel.coupons.beans.Customer;


public interface ICustomersDao extends CrudRepository<Customer, Long> {
	
	@Query("SELECT c FROM Customer c")
	public List<Customer> getAllCustomers();
	
	@Query("SELECT c FROM Customer c WHERE c.age = :age")
	public List<Customer> getAllCustomersByMinAge(@Param("age")int minAge);

}
