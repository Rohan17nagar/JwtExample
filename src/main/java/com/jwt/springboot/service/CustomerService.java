package com.jwt.springboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jwt.springboot.entity.Address;
import com.jwt.springboot.entity.Branch;
import com.jwt.springboot.entity.Customer;
import com.jwt.springboot.entity.Loan;
import com.jwt.springboot.repositories.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public ResponseEntity<String> addCustomer(Customer customer) {

		Customer cust = new Customer();
		Address add = new Address();
		List<Loan> loans = new ArrayList<>();
		List<Branch> branches = new ArrayList<>();

		cust.setCity(customer.getCity());
		cust.setCustomerEmail(customer.getCustomerEmail());
		cust.setCustomerId(customer.getCustomerId());
		cust.setCustomerName(customer.getCustomerName());

		// setting address values.
		add.setCity(customer.getAddress().getCity());
		add.setHouseNumber(customer.getAddress().getHouseNumber());
		add.setPincode(customer.getAddress().getPincode());
		add.setState(customer.getAddress().getState());
		add.setStreet(customer.getAddress().getStreet());
		add.setCustomer(cust);

		// setting loan values.

		for (Loan loanData : customer.getLoan()) {
			Loan loan = new Loan();
			loan.setLoanAmount(loanData.getLoanAmount());
			loan.setLoanType(loanData.getLoanType());
			loan.setCustomer(cust);
			loans.add(loan);
		}

		for (Branch branchData : customer.getBranch()) {
			Branch branch = new Branch();
			branch.setBranchName(branchData.getBranchName());
			branches.add(branch);
		}
		cust.setBranch(branches);
		cust.setLoan(loans);
		cust.setAddress(add);

		customerRepository.save(cust);
		return new ResponseEntity<String>("Customer added successfully!!", HttpStatus.OK);
	}

	public List<Map<String, Object>> getAllCitiesAndEmails() {
		return customerRepository.findCustomerAndEmail();

	}

	public List<Map<String, Object>> getAllCustomers() {
		return customerRepository.findCustomersWithAddress();
	}

}
