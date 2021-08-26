package com.daniel.coupons.logic;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.daniel.coupons.beans.Company;
import com.daniel.coupons.beans.Coupon;
import com.daniel.coupons.beans.User;
import com.daniel.coupons.dao.ICompaniesDao;
import com.daniel.coupons.enums.ErrorType;
import com.daniel.coupons.exceptions.ApplicationException;
import com.daniel.coupons.utils.Utils;

@Controller
public class CompaniesController {

	@Autowired
	private ICompaniesDao companiesDao;


	public CompaniesController() {
	}

	public long createCompany(Company company) throws ApplicationException {
		if (company == null) {
			throw new ApplicationException(ErrorType.INVALID_COMPANY, "A null company");
		}

		if(company.getCompanyName() == "") {
			throw new ApplicationException(ErrorType.INVALID_COMPANY_NAME,"Blank company name");
		}

		if(!Utils.isEmailValid(company.getEmail())) {
			throw new ApplicationException(ErrorType.INVALID_EMAIL,"Invalid email address");
		}

		if(!Utils.isPhoneNumberValid(company.getPhoneNumber())) {
			throw new ApplicationException(ErrorType.INVALID_PHONE_NUMBER,"Invalid phone number");
		}

		List<Coupon>coupons = new ArrayList<>();
		List<User>users = new ArrayList<>();
		company.setCoupons(coupons);
		company.setUsers(users);
		
		try {
			this.companiesDao.save(company);
			return company.getId();
		}
		catch (Exception e) {
			throw new ApplicationException(ErrorType.INVALID_COMPANY,"Company creation has failed.");
		}

	}

	public void removeCompany(long companyId) throws ApplicationException {

		try {
			Company company = getCompany(companyId);
			companiesDao.delete(company);
		}
		catch (Exception e) {
			throw new ApplicationException(ErrorType.INVALID_COMPANY,"Failed to remove the company.");
		}
	}

	public Company getCompany(long companyId)  throws ApplicationException {
		
		try {
			Company company = companiesDao.findById(companyId).get();
			return company;
		}
		catch (Exception e) {
			throw new ApplicationException(ErrorType.INVALID_COMPANY,"Company not found.");
		}
	}

	public void updateCompany(Company company) throws ApplicationException {
		
		if (company == null) {
			throw new ApplicationException(ErrorType.INVALID_COMPANY, "A null company");
		}

		if(company.getCompanyName() == "") {
			throw new ApplicationException(ErrorType.INVALID_COMPANY_NAME,"Blank company name");
		}

		if(!Utils.isEmailValid(company.getEmail())) {
			throw new ApplicationException(ErrorType.INVALID_EMAIL,"Invalid email address");
		}

		if(!Utils.isPhoneNumberValid(company.getPhoneNumber())) {
			throw new ApplicationException(ErrorType.INVALID_PHONE_NUMBER,"Invalid phone number");
		}
	
		try {
			this.companiesDao.save(company);
		}
		catch (Exception e) {
			throw new ApplicationException(ErrorType.INVALID_COMPANY,"Failed to update company.");
		}
	}

	public List<Company> getAllCompanies() throws ApplicationException {	
		
		try {
			return this.companiesDao.getAllCompanies();
		}
		catch (Exception e) {
			throw new ApplicationException(ErrorType.INVALID_COMPANY,"No companies have been found.");
		}
	}

	public Company getCompanyByName(String name) throws ApplicationException {
		try {
			Company company = companiesDao.getCompanyByName(name);
			return company;
		}
		catch (Exception e) {
			throw new ApplicationException(ErrorType.INVALID_COMPANY,"Company not found.");
		}
	}
}

