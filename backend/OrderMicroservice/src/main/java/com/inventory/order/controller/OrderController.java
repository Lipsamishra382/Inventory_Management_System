package com.inventory.order.controller;

import com.inventory.order.Repository.OrderRepository;
import com.inventory.order.SequenceGeneratorService;
import com.inventory.order.model.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import com.inventory.order.model.Order;
import com.inventory.order.service.OrderServiceImpl;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderServiceImpl service;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;

	@Autowired
	private RestTemplate restTemplate;
	
	
	@PostMapping("/")
	public Order addOrder(@RequestBody Order order) throws Exception {
		order.setOrderId((int) sequenceGeneratorService.generateSequence(Order.SEQUENCE_NAME));
		return service.saveOrder(order);
		
	}
	
	@GetMapping("/orders")
	public ResponseEntity<?> getOrder(){
		return service.getOrders();
	}
	
	
	
	@GetMapping("/{id}")
	public Order getOrderById(@PathVariable int id) {
		return service.fetchOrderById(id);
	}
	
	@PutMapping("/update/{id}")
	public Order updateOrders(@PathVariable int id , @RequestBody Order order) throws Exception {

//		if(order.getOrderStatus()=="Cancelled"){
//			service.cancelOrder(id);
//			return service.saveOrder(order);
//		}
//		else{
			deleteOrder(id);
			return service.saveOrder(order);

//		return service.updateOrder(id, order)
		}


	@DeleteMapping("cancel/{id}")
	public void cancelOrder(@PathVariable int id){

		service.cancelOrder(id);
	}
	@DeleteMapping("delete/{id}")
	public void deleteOrder(@PathVariable int id){

		orderRepository.deleteById(id);
	}

}
