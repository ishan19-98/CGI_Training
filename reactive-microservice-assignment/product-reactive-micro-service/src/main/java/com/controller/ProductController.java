package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.WebApplicationType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Product;
import com.service.ProductService;

import jakarta.annotation.PostConstruct;
import jakarta.ws.rs.core.MediaType;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("products")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON )
	public Mono<Product> createProduct(@RequestBody Product product)
	{
		return productService.createProduct(product);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON )
	public Flux<Product> findAllProducts()
	{
		return productService.findAllProducts();
	}
	
	@GetMapping(value = "/{id}")
	public Mono<Product> findProductById(@PathVariable("id") int id)
	{
		return productService.findProductById(id);
	}

}