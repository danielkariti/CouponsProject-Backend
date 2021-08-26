package com.daniel.coupons.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.daniel.coupons.beans.Company;

public interface ICompaniesDao extends CrudRepository<Company, Long> {
	
	@Query("SELECT c FROM Company c")
	public List<Company> getAllCompanies();

	@Query("SELECT c FROM Company c WHERE c.companyName = :companyName")
	public Company getCompanyByName(@Param("companyName") String name);


}
