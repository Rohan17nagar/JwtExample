package com.jwt.springboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jwt.springboot.entity.User;
import com.jwt.springboot.repositories.UserRepository;

@Service
public class UserService {
//	private List<User> store = new ArrayList<>();
	
//	public UserService() {
//		store.add(new User(UUID.randomUUID().toString(),"Rohan nagar","rohan@gmail.com"));
//		store.add(new User(UUID.randomUUID().toString(),"dd nagar","rddn@gmail.com"));
//		store.add(new User(UUID.randomUUID().toString(),"ff nagar","ff@g.com"));

//	}
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	public 	List<User> getUser(){
//		return this.store;
		return userRepository.findAll();
	}
	
	public User createUser(User user) {
		user.setUserId(UUID.randomUUID().toString());
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRole(user.getRole());
		return userRepository.save(user);
	}
}
