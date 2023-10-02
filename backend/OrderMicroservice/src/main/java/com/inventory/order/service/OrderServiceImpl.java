package com.inventory.order.service;

import com.inventory.order.model.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;

import com.inventory.order.Repository.OrderRepository;
import com.inventory.order.model.Order;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderRepository repo;


	@Autowired
	private RestTemplate restTemplate;



	@Override
	public Order saveOrder(Order order) {
		// TODO Auto-generated method stub


		order.setOrderDateTime(new Date());
		return repo.save(order);
	}

	@Override
	public Order fetchOrderById(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

//	@Override
//	public Order updateOrder(int id, Order order) {
//		// TODO Auto-generated method stub
//		Order update = this.repo.findById(id);
//		update.setLocationNbr(order.getLocationNbr());
//		update.setMaterialId(order.getMaterialId());
//		update.setOrderDateTime(order.getOrderDateTime());
//		update.setOrderQty(order.getOrderQty());
//		update.setOrderStatus(order.getOrderStatus());
//		return repo.save(update);
//
//	}
	
	@Override
	public ResponseEntity<?> getOrders() {
		// TODO Auto-generated method stub
		return ResponseEntity.ok(repo.findAll());
	}

	public void cancelOrder(int id) {
		Order ord=repo.findById(id);
		Inventory inven=restTemplate.getForObject(
				"http://localhost:8081/search/"+ord.getLocationNbr(),
				Inventory.class);
		Inventory inventory= new Inventory();
		inventory.setId(inven.getId());
		inventory.setLocationNbr(inven.getLocationNbr());
		inventory.setMaterialId(inven.getMaterialId());
		inventory.setOrderQty(inven.getOrderQty()-ord.getOrderQty());
		inventory.setUpdateDateTime(inven.getUpdateDateTime());
//		inventory.setAvailableQty(inven.getAvailableQty()+ord.getOrderQty());
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("HeaderName", "value");
		headers.add("Content-Type", "application/json");
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		HttpEntity<Inventory> request = new HttpEntity<Inventory>(inventory, headers);
		restTemplate.postForObject("http://localhost:8081/orderupdate",request, Inventory.class);

//		repo.deleteById(id);
	}
	
	
}
