package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ProductRepository;
import com.entity.Product;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {
	

	@Autowired
	ProductRepository productRepository;

	public Mono<Product> createProduct(Product product)
	{
		return productRepository.findById(product.getId()).switchIfEmpty(productRepository.save(product));
	}
	
	public Flux<Product> findAllProducts()
	{
		return productRepository.findAll();
	}
	
	public Mono<Product> findProductById(int id)
	{
		return productRepository.findById(id);
	}

}