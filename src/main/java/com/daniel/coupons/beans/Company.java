package com.daniel.coupons.beans;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "companies")
public class Company {

	
	@Id
	@GeneratedValue
	@Column(name="id")
	private long id;
	
	@Column(unique = true, nullable = false)
	private String companyName;
	
	@Column(unique = true, nullable = false)
	private String email;
	
	@Column(unique = false, nullable = false)
	private String phoneNumber;
	
	@Column(nullable = false)
	private String address;
	
	@JsonIgnore
	@OneToMany(mappedBy = "company", cascade = CascadeType.REMOVE)
    private List<User> users;
	
	@JsonIgnore
	@OneToMany(mappedBy = "company", cascade = CascadeType.REMOVE)
	private List<Coupon> coupons;
	
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<User> getUsers() {
		return users;
	}
	
	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Coupon> getCoupons() {
		return coupons;
	}

	public void setCoupons(List<Coupon> coupons) {
		this.coupons = coupons;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", companyName=" + companyName + ", email=" + email + ", phoneNumber="
				+ phoneNumber + ", address=" + address + ", users=" + users + ", coupons=" + coupons + "]";
	}


	
}

