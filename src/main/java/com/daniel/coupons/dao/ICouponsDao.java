package com.daniel.coupons.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.daniel.coupons.beans.Coupon;
import com.daniel.coupons.dataobjects.CouponDataObject;
import com.daniel.coupons.enums.Category;


public interface ICouponsDao extends CrudRepository<Coupon, Long> {
	
	@Query("SELECT c FROM Coupon c WHERE c.category = :category")
	public List<Coupon> findByCategory(@Param("category")Category category);

	@Query("SELECT NEW com.daniel.coupons.dataobjects.CouponDataObject(c, c.company.companyName) FROM Coupon c")
	public List<CouponDataObject> getAllCoupons();
	
//	@Query("SELECT c from Coupon c")
//	public List<Coupon> getAllCoupons();

	@Query("SELECT c FROM Coupon c WHERE c.company.id = :companyId")
	public List<Coupon> getAllCouponsByCompanyId(@Param("companyId") long companyID);


	@Query("SELECT couponStock FROM Coupon c WHERE id = :id")
	public int getCouponStock(@Param("id") long id);
	
	
	@Transactional
	@Modifying
	@Query("DELETE FROM Coupon WHERE expirationDate < :currentDate")
	public void removeExpiredCoupons(@Param("currentDate")Date currentDate);

}
