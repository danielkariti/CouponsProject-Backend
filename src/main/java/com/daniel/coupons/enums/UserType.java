package com.daniel.coupons.enums;


public enum UserType {
	ADMIN("Admin"),
	CUSTOMER("Customer"),
	COMPANY("Company");
	
	private String name;
	
	UserType(String type){
		this.name = type;
	}
	
	public String getName() {
		return this.name;
	}
	
	
}
