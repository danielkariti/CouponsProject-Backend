package com.daniel.coupons.enums;

public enum Category {
	
	FOOD("Food"),
	ELECTRICITY("Electricity"),
	VACATION("Vacation"),
	FASHION("Fashion"),
	ENTERTAINMENT("Entertainment"),
	SPORTS("Sports"),
	HEALTH("Health");
	
	private String category;
	
	Category(String category){
		this.category = category;
	}
	
	public String getCategory() {
		return this.category;
	}
	
	
}


