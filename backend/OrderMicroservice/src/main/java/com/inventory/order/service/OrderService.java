package com.inventory.order.service;

import org.springframework.http.ResponseEntity;

import com.inventory.order.model.Order;

public interface OrderService {
	
	public Order saveOrder(Order order);
	public Order fetchOrderById(int id);
//	public Order updateOrder(int id, Order order);
	public ResponseEntity<?> getOrders();

	public void cancelOrder(int id);
	

}
