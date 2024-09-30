package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserRepository;
import com.entity.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;

	public Mono<User> createUser(User user)
	{
		return userRepository.findById(user.getId()).switchIfEmpty(userRepository.save(user));
	}
	
	public Flux<User> findAllUsers()
	{
		Flux<User> users = userRepository.findAll();
		return users;
	}
	
	public Mono<User> findUserById(int id)
	{
		return userRepository.findById(id);
	}
}
