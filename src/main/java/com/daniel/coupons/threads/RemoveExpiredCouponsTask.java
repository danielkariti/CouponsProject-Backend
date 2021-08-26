package com.daniel.coupons.threads;

import java.util.TimerTask;

import com.daniel.coupons.exceptions.ApplicationException;
import com.daniel.coupons.logic.CouponsController;

public class RemoveExpiredCouponsTask extends TimerTask  {

	private CouponsController couponsController;

	public RemoveExpiredCouponsTask(CouponsController couponsController) {
		this.couponsController = couponsController;
	}

	@Override
	public void run()  {			
		try {
			couponsController.removeExpiredCoupons();
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}
}
