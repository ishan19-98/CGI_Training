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
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("orders")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON )
	public Mono<String> createOrder(@RequestBody Orders order)
	{
		return orderService.createOrder(order);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON )
	public Flux<Orders> findAllOrderss()
	{
		return orderService.findAllOrders();
	}
	
	@GetMapping(value = "/{id}")
	public Mono<Orders> findOrdersById(@PathVariable("id") int id)
	{
		return orderService.findOrderById(id);
	}

}
