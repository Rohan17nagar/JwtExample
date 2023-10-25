package com.jwt.springboot.repositories;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jwt.springboot.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	Optional<Customer> findByCustomerEmail(String customerEmail);

	@Query(nativeQuery = true, value = "SELECT DISTINCT c.city, c.customer_email FROM customer c")
	List<Map<String, Object>> findCustomerAndEmail();

	@Query(nativeQuery = true, value = "SELECT c.customer_name,addr.house_number,addr.street,addr.city FROM customer c JOIN address addr ON c.customer_id = addr.customer_id")
	List<Map<String, Object>> findCustomersWithAddress();

}
