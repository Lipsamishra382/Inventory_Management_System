package com.inventory.order.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.inventory.order.model.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order, Integer> {
	
	public Order findById(int id);

}
