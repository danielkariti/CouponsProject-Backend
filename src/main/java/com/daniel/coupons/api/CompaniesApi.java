package com.daniel.coupons.api;

import java.util.ArrayList;
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

import com.daniel.coupons.beans.Company;
import com.daniel.coupons.beans.Coupon;
import com.daniel.coupons.beans.PostLoginData;
import com.daniel.coupons.exceptions.ApplicationException;
import com.daniel.coupons.logic.CompaniesController;


@RestController
@RequestMapping("/company")
public class CompaniesApi {

	@Autowired
	private CompaniesController companiesController;


	@PostMapping
	public void createCompany(@RequestBody Company company) throws ApplicationException {
		this.companiesController.createCompany(company);
	}

	@PutMapping
	public void updateCompany(@RequestBody Company company) throws ApplicationException {
		this.companiesController.updateCompany(company);
	}
	
	@DeleteMapping("/{id}")
	public void removeCompany(@PathVariable("id") long id) throws ApplicationException {
		this.companiesController.removeCompany(id);

	}
	@GetMapping("/{id}")
	public Company getCompany(@PathVariable("id")long id) throws ApplicationException {
		return this.companiesController.getCompany(id);

	}
	@GetMapping
	public List<Company> getAllCompanies() throws ApplicationException {
		return this.companiesController.getAllCompanies();
	}
	
	@GetMapping("/byName/{name}")
	public Company getCompanyByName(@PathVariable("name")String name) throws ApplicationException {
		return this.companiesController.getCompanyByName(name);
	}

}