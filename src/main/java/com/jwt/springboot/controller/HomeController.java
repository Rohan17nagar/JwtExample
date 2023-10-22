package com.jwt.springboot.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.springboot.entity.User;
import com.jwt.springboot.service.UserService;

import jakarta.annotation.security.RolesAllowed;

@RestController
@RequestMapping("/home")
public class HomeController {

	@Autowired
	private UserService userService;
	
	// http://localhost:8080/home/user
	@GetMapping("/user")
	public List<User> getUser() {
		System.out.println("getting current users.");
		return userService.getUser();
	} 
	
	@GetMapping("/loggedInUser")
	public String getLoggedInUser(Principal principal) {
		return principal.getName();
	}
}
