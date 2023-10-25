package com.jwt.springboot.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Branch {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long branchId;
	private String branchName;
	
	@ManyToMany(mappedBy = "branch",fetch = FetchType.EAGER)
	private List<Customer> customer;
	
}
