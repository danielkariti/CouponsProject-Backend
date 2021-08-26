package com.daniel.coupons.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.daniel.coupons.beans.Purchase;
import com.daniel.coupons.dao.IPurchasesDao;
import com.daniel.coupons.enums.ErrorType;
import com.daniel.coupons.exceptions.ApplicationException;

@Controller
public class PurchasesController {

	@Autowired
	private IPurchasesDao purchasesDao;
	
	@Autowired
	private CouponsController couponsController;

	public PurchasesController() {

	}

	public void createPurchase(Purchase purchase) throws ApplicationException {
		if (purchase == null) {
			throw new ApplicationException(ErrorType.INVALID_PURCHASE,"A null purchase");
		}

		if(purchase.getAmount()<=0) {
			throw new ApplicationException(ErrorType.INVALID_AMOUNT_OF_COUPONS,"Invalid amount has been selected");
		}
		
		if(purchase.getAmount() > purchase.getCoupon().getCouponStock()) {
			throw new ApplicationException(ErrorType.INVALID_AMOUNT_OF_COUPONS_IS_TOO_HIGH,"Invalid amount has been selected");
		}
		
		try {
			this.couponsController.updateStock(purchase.getCoupon().getId(), purchase.getAmount());
			this.purchasesDao.save(purchase);
		}
		catch (Exception e) {
			throw new ApplicationException(ErrorType.INVALID_PURCHASE,"Failed to attempt purchase.");
		}
	}

	public void removePurchase(long id) throws ApplicationException {

		try {
			Purchase purchase = getPurchase(id);
			purchasesDao.delete(purchase);
		}
		catch (Exception e) {
			throw new ApplicationException(ErrorType.INVALID_PURCHASE,"Failed to remove purchase.");
		}
	}

	public Purchase getPurchase(long id)  throws ApplicationException {

		try {
			Purchase purchase = purchasesDao.findById(id).get();
			return purchase;
		}
		catch (Exception e) {
			throw new ApplicationException(ErrorType.INVALID_PURCHASE,"Could not find a purchase.");
		}
	}

	public List<Purchase> getAllPurchasesByUserID(long userId) throws ApplicationException {

		try {
			return this.purchasesDao.getAllPurchasesByUserID(userId);
		}
		catch (Exception e) {
			throw new ApplicationException(ErrorType.INVALID_PURCHASE,"No purchases have been found.");
		}

	}

	public List<Purchase> getAllPurchasesByCouponID(long couponId) throws ApplicationException {
		try {
			return this.purchasesDao.getAllPurchasesByCouponID(couponId);
		}
		catch (Exception e) {
			throw new ApplicationException(ErrorType.INVALID_PURCHASE,"No purchases have been found.");
		}
	}

	public List<Purchase> getAllPurchases() throws ApplicationException {

		try {
			return this.purchasesDao.getAllPurchases();
		}
		catch (Exception e) {
			throw new ApplicationException(ErrorType.INVALID_PURCHASE,"No purchases have been found.");
		}
	}
}

