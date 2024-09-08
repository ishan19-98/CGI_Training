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

@RestController
@RequestMapping("users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON )
	public String createUser(@RequestBody User user)
	{
		String result = userService.createUser(user);
		return result;
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON )
	public List<User> findAllUsers()
	{
		List<User> users = userService.findAllUsers();
		return users;
	}
	
	@GetMapping(value = "/{id}")
	public String findUserById(@PathVariable("id") int id)
	{
		String result = userService.findUserById(id);
		return result;
	}

}
