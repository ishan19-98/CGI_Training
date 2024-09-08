package com.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.entity.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product,Integer> {

}
