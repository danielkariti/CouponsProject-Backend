package com.daniel.coupons.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.daniel.coupons.beans.Company;
import com.daniel.coupons.beans.Coupon;
import com.daniel.coupons.beans.PostLoginData;
import com.daniel.coupons.dataobjects.CouponDataObject;
import com.daniel.coupons.enums.Category;
import com.daniel.coupons.exceptions.ApplicationException;
import com.daniel.coupons.logic.CouponsController;


@RestController
@RequestMapping("/coupon")
public class CouponsApi {

	@Autowired
	private CouponsController couponsController;
	

	@PostMapping
	public void createCoupon(@RequestBody Coupon coupon, @RequestAttribute("userData") PostLoginData postLoginData) throws ApplicationException {
		coupon.setCompany(new Company());
		coupon.getCompany().setId(postLoginData.getCompanyId());
		this.couponsController.createCoupon(coupon);

	}
	@PutMapping
	public void updateCoupon(@RequestBody Coupon coupon) throws ApplicationException {
		this.couponsController.updateCoupon(coupon);
	}

	@GetMapping("/{id}")
	public Coupon getCoupon(@PathVariable("id") long id) throws ApplicationException {
		return this.couponsController.getCoupon(id);
	}

	@DeleteMapping("/{id}")
	public void removeCoupon(@PathVariable("id") long id) throws ApplicationException {
		this.couponsController.removeCoupon(id);
	}

	@GetMapping
	public List<CouponDataObject> getAllCoupons() throws ApplicationException {
		return this.couponsController.getAllCoupons();
	}

	@GetMapping("/byCategory/{category}")
	public List<Coupon> findByCategory(@PathVariable("category")String category) throws ApplicationException {
		Category categoryName = Category.valueOf(category.toUpperCase());
		return this.couponsController.findByCategory(categoryName);

	}

	@GetMapping("/byCompany")
	public List<Coupon> getAllCouponsByCompanyId(@RequestAttribute("userData") PostLoginData postLoginData) throws ApplicationException {
		System.out.println(postLoginData.getCompanyId());
		return this.couponsController.getAllCouponsByCompanyId(postLoginData.getCompanyId());
	}
	
	@GetMapping("/company")
	public List<Coupon> getAllCouponsByCompany(@RequestParam("id")long companyId) throws ApplicationException {
		return this.couponsController.getAllCouponsByCompanyId(companyId);
	}

}