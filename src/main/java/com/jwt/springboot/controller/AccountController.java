package com.jwt.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.springboot.model.CreateAccountRequest;
import com.jwt.springboot.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	
	@PostMapping("/create-account")
	public ResponseEntity<String> createAccount(@RequestBody CreateAccountRequest createAccountRequest){
		return accountService.createAccount(createAccountRequest);
	}
	
}
