package com.dao;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.entity.User;

@Repository
public interface UserRepository extends ReactiveCrudRepository<User, Integer> {

}
