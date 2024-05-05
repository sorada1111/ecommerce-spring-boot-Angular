package com.sp.ecommerce.service;

import com.sp.ecommerce.dto.Purchase;
import com.sp.ecommerce.dto.PurchaseResponse;

public interface CheckoutService {
	
	PurchaseResponse placeOrder(Purchase purchase);

}
