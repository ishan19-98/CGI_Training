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

import com.entity.User;
import com.service.UserService;

import jakarta.annotation.PostConstruct;
import jakarta.ws.rs.core.MediaType;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON )
	public Mono<User> createUser(@RequestBody User user)
	{
		return userService.createUser(user);
		
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON )
	public Flux<User> findAllUsers()
	{
		return userService.findAllUsers();
	}
	
	@GetMapping(value = "/{id}")
	public Mono<User> findUserById(@PathVariable("id") int id)
	{
		return userService.findUserById(id);
	}

}
