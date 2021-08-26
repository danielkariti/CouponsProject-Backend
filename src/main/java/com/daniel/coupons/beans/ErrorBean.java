package com.daniel.coupons.beans;

public class ErrorBean {
	
	private int errorNumber;
	private String errorMessage;
	
	
	public ErrorBean(int errorNumber, String errorMessage) {
		this.errorNumber = errorNumber;
		this.errorMessage = errorMessage;
	}


	public int getErrorNumber() {
		return errorNumber;
	}


	public void setErrorNumber(int errorNumber) {
		this.errorNumber = errorNumber;
	}


	public String getErrorMessage() {
		return errorMessage;
	}


	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	

}
