package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ProductRepository;
import com.entity.Product;

@Service
public class ProductService {
	

	@Autowired
	ProductRepository productRepository;

	public String createProduct(Product product)
	{
		Optional<Product> result = productRepository.findById(product.getId());
		if(result.isPresent())
		{
			return "Product With Given Id Already Exists!";
		}
		else
		{
			productRepository.save(product);
			return "Product Is Created";
		}
	}
	
	public List<Product> findAllProducts()
	{
		List<Product> products = productRepository.findAll();
		return products;
	}
	
	public String findProductById(int id)
	{
		Optional<Product> product = productRepository.findById(id);
		if(product.isPresent())
		{
			return "Product [id=" + product.get().getId() + ", name=" + product.get().getName() + ", description=" + product.get().getDescription() + ", price=" + product.get().getPrice()
					+ ", createAt=" + product.get().getCreateAt() + "]";
		}
		return null;
	}

}
