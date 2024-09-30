package com.dao;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.entity.Orders;

@Repository
public interface OrderRepository extends ReactiveCrudRepository<Orders, Integer> {

}
