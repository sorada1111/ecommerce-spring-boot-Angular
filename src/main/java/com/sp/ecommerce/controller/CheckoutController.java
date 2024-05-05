package com.sp.ecommerce.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sp.ecommerce.dto.Purchase;
import com.sp.ecommerce.dto.PurchaseResponse;
import com.sp.ecommerce.service.CheckoutService;

@CrossOrigin
@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {
	
	private CheckoutService checkoutService;
	
	public CheckoutController(CheckoutService checkoutService) {
		this.checkoutService = checkoutService;
	}
	
	
	@PostMapping("/purchase")
	public PurchaseResponse placeorder(@RequestBody Purchase purchase) {
		
		PurchaseResponse purchaseResponse = checkoutService.placeOrder(purchase);
		
		return purchaseResponse;
		
	}

}
