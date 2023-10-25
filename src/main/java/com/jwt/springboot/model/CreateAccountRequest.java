package com.jwt.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CreateAccountRequest {
	private String accountNumber;
	private String accountType;
	private double balance;
	private String customerEmail;
}
