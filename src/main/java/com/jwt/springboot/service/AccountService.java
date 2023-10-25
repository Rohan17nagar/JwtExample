package com.jwt.springboot.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jwt.springboot.entity.Account;
import com.jwt.springboot.entity.Customer;
import com.jwt.springboot.model.CreateAccountRequest;
import com.jwt.springboot.repositories.AccountRepository;
import com.jwt.springboot.repositories.CustomerRepository;

@Service
public class AccountService {

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	CustomerRepository customerRepository;

	public ResponseEntity<String> createAccount(CreateAccountRequest createAccountRequest) {
		try {
			Optional<Customer> customer = Optional
					.of(customerRepository.findByCustomerEmail(createAccountRequest.getCustomerEmail())
							.orElseThrow(() -> new RuntimeException("error")));

			System.out.println("Customer data" + createAccountRequest + "  " + customer);

			if (customer.isPresent()) {

				Account account = new Account();
				account.setAccountNumber(createAccountRequest.getAccountNumber());
				account.setAccountType(createAccountRequest.getAccountType());
				account.setBalance(createAccountRequest.getBalance());
				account.setCustomer(customer.get());
				accountRepository.save(account);

				return new ResponseEntity<String>("Account created successfully", HttpStatus.OK);
			}

		} catch (RuntimeException e) {
			return new ResponseEntity<String>(
					"Customer not found with Email " + createAccountRequest.getCustomerEmail(), HttpStatus.BAD_REQUEST);
		}
		return null;
	}

	public ResponseEntity<List<Map<String, Object>>> getCustomerByAccountNumber(String accountNumber) {

		System.out.println("acccount>>>" + accountNumber);

		List<Map<String, Object>> str = accountRepository.findCustomerAndAccountDetailsByAccountNumber(accountNumber);
		System.out.println("ccc>>>" + str);
		return new ResponseEntity<List<Map<String, Object>>>(str, HttpStatus.OK);
	}

}
