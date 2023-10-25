package com.jwt.springboot.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jwt.springboot.entity.Customer;
import com.jwt.springboot.service.AccountService;
import com.jwt.springboot.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private AccountService accountService;

	@PostMapping("/addCustomer")
	public ResponseEntity<String> addCustomer(@RequestBody Customer customer) {
		return customerService.addCustomer(customer);
	}

	@GetMapping("/getCustomer/{accountNumber}")
	public ResponseEntity<List<Map<String, Object>>> getCustomerByAccountNumber(@PathVariable String accountNumber) {
		return accountService.getCustomerByAccountNumber(accountNumber);
	}

	// Get all customers with their address details:

	@GetMapping("/getAllCitiesAndEmails")
	public ResponseEntity<List<Map<String, Object>>> getAllCitiesAndEmails() {
		List<Map<String, Object>> citiesAndEmails = customerService.getAllCitiesAndEmails();
		return ResponseEntity.ok(citiesAndEmails);
	}

	@GetMapping("/getAllCustomers")
	public ResponseEntity<List<Map<String, Object>>> getAllCustomers() {
		List<Map<String, Object>> allCustomers = customerService.getAllCustomers();
		return ResponseEntity.ok(allCustomers);
	}

}
