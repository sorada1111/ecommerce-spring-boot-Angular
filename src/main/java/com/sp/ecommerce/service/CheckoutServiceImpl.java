package com.sp.ecommerce.service;

import java.util.Set;
import java.util.UUID;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.stereotype.Service;

import com.sp.ecommerce.dao.CustomerRepository;
import com.sp.ecommerce.dto.Purchase;
import com.sp.ecommerce.dto.PurchaseResponse;
import com.sp.ecommerce.entity.Customer;
import com.sp.ecommerce.entity.Order;
import com.sp.ecommerce.entity.OrderItem;

import jakarta.transaction.Transactional;


@Service
public class CheckoutServiceImpl implements CheckoutService{

	
	private CustomerRepository customerRepository;
	
	public CheckoutServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	@Override
	@Transactional
	public PurchaseResponse placeOrder(Purchase purchase) {
		
		//retrieve the order info from dto
		Order order = purchase.getOrder();
		
		// generate tracking number
		String orderTrackingNumberString = generateOrderTrackingNumber();
		order.setOrderTrackingNumber(orderTrackingNumberString);
		
		// populate order with orderItems
		Set<OrderItem> orderItems = purchase.getOrderItems();
		orderItems.forEach(Item -> order.add(Item));
		
		// populate order with billingAddress and shippingAddress
		order.setBillingAddress(purchase.getBillingAddress());
		order.setShippingAddress(purchase.getShippingAddress());
		
		
		// populate customer with order
		Customer customer = purchase.getCustomer();
		customer.add(order);
		
		// save to the database
		customerRepository.save(customer);
		
		// return a response
		
		return new PurchaseResponse(orderTrackingNumberString);
	}

	private String generateOrderTrackingNumber() {
		
		// generate a random UUID number (UUID version-4)
		
		return UUID.randomUUID().toString();
	}

}
