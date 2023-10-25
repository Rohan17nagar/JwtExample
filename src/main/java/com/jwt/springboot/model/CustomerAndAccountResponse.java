package com.jwt.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerAndAccountResponse {

	private String account_number;
	private String customer_name;
	private double balance;
	private String city;
}
