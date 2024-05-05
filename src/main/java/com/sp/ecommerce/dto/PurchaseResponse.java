package com.sp.ecommerce.dto;

import lombok.Data;

@Data
public class PurchaseResponse {

	
	private String orderTrackingNumber;

	public PurchaseResponse(String orderTrackingNumber) {
		super();
		this.orderTrackingNumber = orderTrackingNumber;
	}
	
	
	
}
