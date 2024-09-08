package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Orders;
import com.service.OrderService;

import jakarta.ws.rs.core.MediaType;

@RestController
@RequestMapping("orders")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON )
	public String createOrder(@RequestBody Orders order)
	{
		String result = orderService.createOrder(order);
		return result;
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON )
	public List<Orders> findAllOrderss()
	{
		List<Orders> orders = orderService.findAllOrders();
		return orders;
	}
	
	@GetMapping(value = "/{id}")
	public Optional<Orders> findOrdersById(@PathVariable("id") int id)
	{
		Optional<Orders> result = orderService.findOrderById(id);
		return result;
	}

}
