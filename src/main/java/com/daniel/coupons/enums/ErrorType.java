package com.daniel.coupons.enums;

public enum ErrorType {
	
	GENERAL_ERROR(551, "General error.", true),
	INVALID_USERNAME(552, "Username is not available.", false),
	INVALID_PASSWORD(553, "Invalid Password.", false),
	INVALID_CUSTOMER(554, "Customer doesn't exist.", false),
	INVALID_COMPANY(555, "Company doesn't exist.", false),
	INVALID_COMPANY_NAME(556, "Company name exists.", false),
	INVALID_COUPON(557, "Coupon doesn't exist.", false),
	INVALID_EMAIL(558, "Invalid Email.", false),
	INVALID_PRICE(559, "Price must be above 0.", false),
	INVALID_AMOUNT_OF_COUPONS(560, "The selected amount has to be 1 or more.", false),
	INVALID_AMOUNT_OF_COUPONS_IS_TOO_HIGH(560, "The selected amount has to be less than the amount on coupons in stock.", false),
	INVALID_PHONE_NUMBER(561, "Phone number is invalid.", false),
	INVALID_CATEGORY(562, "Must choose a category.", false),
	INVALID_COUPON_TITLE(563, "Must type a coupon name.", false),
	INVALID_PURCHASE(564, "Purchase doesn't exist.", false),
	OUT_OF_STOCK(565, "Coupon is out of stock.", false),
	INVALID_USER(566, "User doesn't exist.", false),
	FAILED_LOGIN(567, "Failed login", false),
	INVALID_DATE(568, "Date has already passed.", false);
	
	
	private int errorID;
	private String errorMessage;
	private boolean isShowTrace;
	
	ErrorType(int errorID, String errorMessage, boolean isShowTrace){
		this.errorID = errorID;
		this.errorMessage = errorMessage;
		this.isShowTrace = isShowTrace;
	}

	public int getErrorID() {
		return errorID;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public boolean isShowTrace() {
		return isShowTrace;
	}

}
