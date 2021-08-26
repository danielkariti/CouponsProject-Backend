package com.daniel.coupons.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.daniel.coupons.beans.Customer;
import com.daniel.coupons.beans.PostLoginData;
import com.daniel.coupons.beans.Purchase;
import com.daniel.coupons.exceptions.ApplicationException;
import com.daniel.coupons.logic.PurchasesController;

	@RestController
	@RequestMapping("/purchase")
	public class PurchaseApi {

		@Autowired
		private PurchasesController purchasesController;


		@PostMapping
		public void createPurchase(@RequestBody Purchase purchase, @RequestAttribute("userData") PostLoginData postLoginData) throws ApplicationException {
			purchase.setCustomer(new Customer());
			purchase.getCustomer().setId(postLoginData.getId());
			this.purchasesController.createPurchase(purchase);
		}

		@DeleteMapping("/{id}")
		public void removePurchase(@PathVariable("id") long id) throws ApplicationException {
			this.purchasesController.removePurchase(id);

		}
		@GetMapping("/{id}")
		public Purchase getPurchaseByPurchaseID(@PathVariable("id")long id) throws ApplicationException {
			return this.purchasesController.getPurchase(id);

		}
		@GetMapping("/customer")
		public List<Purchase> getAllPurchasesByUserID(@RequestAttribute("userData") PostLoginData postLoginData) throws ApplicationException {
			return this.purchasesController.getAllPurchasesByUserID(postLoginData.getId());
		}

		@GetMapping("/coupon/{coupon_id}")
		public List<Purchase> getAllPurchasesByCouponID(@RequestParam("coupon_id")long couponId) throws ApplicationException {
			return this.purchasesController.getAllPurchasesByCouponID(couponId);
		}
		
		@GetMapping
		public List<Purchase> getAllPurchases() throws ApplicationException {
			return this.purchasesController.getAllPurchases();
		}
		
		
}