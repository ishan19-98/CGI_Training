package com.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.dao.OrderRepository;
import com.entity.Orders;
import com.model.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class OrderService {
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	WebClient.Builder webClient;

	public Mono<String> createOrder(Orders order) {
	    return orderRepository.findById(order.getId())
	        .flatMap(existingOrder -> {
	            return Mono.just("Order with Given Id Already Exists");
	        })
	        .switchIfEmpty(
	            fetchUser(order.getUserid())
	                .flatMap(userName -> {
	                    if (userName != null) {
	                        return fetchProduct(order.getProductid())
	                            .flatMap(res -> {
	                                if (res != null) {
	                                    return orderRepository.save(order)
	                                        .then(Mono.just("Order created successfully"));
	                                } else {
	                                    return Mono.just("Product with given product id does not exist");
	                                }
	                            });
	                    } else {
	                        return Mono.just("Order cannot be placed as User does not exist");
	                    }
	                })
	        );
	}
	
	 private Mono<String> fetchProduct(int productId) {
	        return webClient.build()
	            .get()
	            .uri("http://PRODUCT-SERVICE/products/{id}", productId) // Change to your product service URL
	            .retrieve()
	            .bodyToMono(String.class)
	            .onErrorReturn(null); // Handle errors gracefully
	    }

	public Mono<User> fetchUser(Integer id)
	{
		return webClient.build().get().uri("http://USER-REACTIVE-MICRO-SERVER/users/"
				+id).retrieve().bodyToMono(User.class);
	}
	
	public Flux<Orders> findAllOrders()
	{
		return orderRepository.findAll();
	}
	
	public Mono<Orders> findOrderById(int id)
	{
		return orderRepository.findById(id);	
	}
}