package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserRepository;
import com.entity.User;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;

	public String createUser(User user)
	{
		Optional<User> result = userRepository.findById(user.getId());
		if(result.isPresent())
		{
			return "User With Given Id Already Exists!";
		}
		else
		{
			userRepository.save(user);
			return "User Is Created";
		}
	}
	
	public List<User> findAllUsers()
	{
		List<User> users = userRepository.findAll();
		return users;
	}
	
	public String findUserById(int id)
	{
		Optional<User> user = userRepository.findById(id);
		if(user.isPresent())
		{
		return user.get().getUsername();
		}
		else
		{
			return null;
		}
		
		
	}
}
