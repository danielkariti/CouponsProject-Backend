package com.daniel.coupons.beans;

import com.daniel.coupons.enums.UserType;

public class PostLoginData {
	
	private long id;
	private Long companyId;
	private UserType userType;
	
	public PostLoginData(long id, UserType userType) {
		this.id = id;
		this.companyId=null;
		this.userType = userType;
		
	}
	
	public PostLoginData(long id, Long companyId, UserType userType) {
		this(id, userType);
		this.companyId = companyId;
	}
	
	public long getId() {
		return id;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public UserType getUserType() {
		return userType;
	}

	@Override
	public String toString() {
		return "PostLoginData [id=" + id + ", companyId=" + companyId + ", userType=" + userType + "]";
	}
	
}
