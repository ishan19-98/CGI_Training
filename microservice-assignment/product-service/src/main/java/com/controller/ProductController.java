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

@RestController
@RequestMapping("products")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON )
	public String createProduct(@RequestBody Product product)
	{
		String result = productService.createProduct(product);
		return result;
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON )
	public List<Product> findAllProducts()
	{
		List<Product> products = productService.findAllProducts();
		return products;
	}
	
	@GetMapping(value = "/{id}")
	public String findProductById(@PathVariable("id") int id)
	{
		String result = productService.findProductById(id);
		return result;
	}

}
