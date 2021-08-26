package com.daniel.coupons.dataobjects;


import com.daniel.coupons.beans.Coupon;

public class CouponDataObject {

	private Coupon coupon;
	
	private String companyName;

	public CouponDataObject() {
	}
	
	public CouponDataObject(Coupon coupon, String companyName) {
		this.coupon = coupon;
		this.companyName = companyName;
	}

	public Coupon getCoupon() {
		return coupon;
	}

	public void setCoupon(Coupon coupon) {
		this.coupon = coupon;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Override
	public String toString() {
		return "CouponDataObject [companyName=" + companyName + "]";
	}


}
