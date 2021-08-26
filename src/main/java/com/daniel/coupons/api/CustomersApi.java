package com.daniel.coupons.api;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daniel.coupons.beans.Customer;
import com.daniel.coupons.beans.PostLoginData;
import com.daniel.coupons.beans.User;
import com.daniel.coupons.exceptions.ApplicationException;
import com.daniel.coupons.logic.CustomersController;
import com.daniel.coupons.logic.UsersController;

@RestController
@RequestMapping("/customer")
public class CustomersApi {

	@Autowired
	private CustomersController customersController;
	
	@Autowired
	private UsersController usersController;

	@PostMapping("/register")
	public void createCustomer(@RequestBody Customer customer) throws ApplicationException {
		this.customersController.createCustomer(customer);

	}
	@PutMapping
	public void updateCustomer(@RequestBody Customer customer, @RequestAttribute("userData") PostLoginData postLoginData) throws ApplicationException {
		User user = this.usersController.getUser(postLoginData.getId());
		customer.setUser(user);
		this.customersController.updateCustomer(customer);
	}

	@GetMapping
	public Customer getCustomer(@RequestAttribute("userData") PostLoginData postLoginData) throws ApplicationException {
		return this.customersController.getCustomer(postLoginData.getId());
	}

	@DeleteMapping("/{id}")
	public void removeCustomer(@PathVariable("id") long id) throws ApplicationException {
		this.customersController.removeCustomer(id);
	}

	@GetMapping("/all")
	public List<Customer> getAllCustomers() throws ApplicationException {
		return this.customersController.getAllCustomers();
	}

	@GetMapping("/age/{age}")
	public List<Customer> getAllUsersByMinAge(@PathVariable("age") int minAge) throws ApplicationException {
		return this.customersController.getAllCustomersByMinAge(minAge);
	}
}