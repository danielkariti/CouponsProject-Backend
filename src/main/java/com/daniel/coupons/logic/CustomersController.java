package com.daniel.coupons.logic;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.daniel.coupons.beans.Customer;
import com.daniel.coupons.dao.ICustomersDao;
import com.daniel.coupons.enums.ErrorType;
import com.daniel.coupons.exceptions.ApplicationException;
import com.daniel.coupons.utils.Utils;

@Controller
public class CustomersController {

	@Autowired
	private ICustomersDao customersDao;


	public CustomersController() {

	}

	public void createCustomer(Customer customer) throws ApplicationException {

		if (customer == null) {
			throw new ApplicationException(ErrorType.INVALID_CUSTOMER,"A null customer");
		}

		if(customer.getName() == "") {
			throw new ApplicationException(ErrorType.INVALID_CUSTOMER,"Blank name");
		}


		if(!Utils.isEmailValid(customer.getEmail())) {
			throw new ApplicationException(ErrorType.INVALID_EMAIL,"Invalid email address");
		}

		byte[] hashedPassword = Utils.hashPassword(customer.getPassword());
		Base64.Encoder enc = Base64.getEncoder();
		customer.setPassword(enc.encodeToString(hashedPassword));
		
		try {
			this.customersDao.save(customer);
		}
		catch (Exception e) {
			throw new ApplicationException(ErrorType.INVALID_CUSTOMER,"Failed to create customer.");
		}
	}

	public void removeCustomer(long id) throws ApplicationException {

		try {
			Customer customer = getCustomer(id);
			customersDao.delete(customer);
		}
		catch (Exception e) {
			throw new ApplicationException(ErrorType.INVALID_CUSTOMER,"Failed to remove the customer.");
		}
	}


	public Customer getCustomer(long customerId) throws ApplicationException {

		try {
			Customer customer = customersDao.findById(customerId).get();
			return customer;
		}
		catch (Exception e) {
			throw new ApplicationException(ErrorType.INVALID_CUSTOMER,"Failed to find customer.");
		}
	}

	public void updateCustomer(Customer customer) throws ApplicationException {
		
		if (customer == null) {
			throw new ApplicationException(ErrorType.INVALID_CUSTOMER,"A null customer");
		}

		if(customer.getName() == "") {
			throw new ApplicationException(ErrorType.INVALID_CUSTOMER,"Blank name");
		}

		if(!Utils.isEmailValid(customer.getEmail())) {
			throw new ApplicationException(ErrorType.INVALID_EMAIL,"Invalid email address");
		}
		
		try {
			this.customersDao.save(customer);
		}
		catch (Exception e) {
			throw new ApplicationException(ErrorType.INVALID_CUSTOMER,"Failed to update customer.");
		}
	}

	public List<Customer> getAllCustomers() throws ApplicationException {

		try {
			return this.customersDao.getAllCustomers();
		}
		catch (Exception e) {
			throw new ApplicationException(ErrorType.INVALID_CUSTOMER,"Failed to find customers.");
		}
	}

	public List<Customer> getAllCustomersByMinAge(int minAge) throws ApplicationException {

		try {
			return this.customersDao.getAllCustomersByMinAge(minAge);
		}
		catch (Exception e) {
			throw new ApplicationException(ErrorType.INVALID_CUSTOMER,"Failed to find customers.");
		}
	}
	
}





