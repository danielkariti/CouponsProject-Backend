package com.daniel.coupons.beans;

public class UserLoginDetails {
	
	private String username;
	private String password;
	
	public UserLoginDetails() {
		
	}

	@Override
	public String toString() {
		return "UserLoginDetails [username=" + username + ", password=" + password + "]";
	}

	public UserLoginDetails(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
