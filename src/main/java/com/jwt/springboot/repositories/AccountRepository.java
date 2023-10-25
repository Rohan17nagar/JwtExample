package com.jwt.springboot.repositories;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jwt.springboot.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    // @Query(nativeQuery = true,value = "SELECT c.customer_name, a.account_number,
    // a.balance " +
    // "FROM account a " +
    // "JOIN customer c ON a.customer_id = c.customer_id " +
    // "WHERE a.account_number = :accountNumber")
    // @Query(nativeQuery = true, value = "SELECT city FROM customer")
    // List<CustomerAndAccountResponse>
    // findCustomerAndAccountDetailsByAccountNumber(
    // @Param("accountNumber") String accountNumber);

    // @Query("SELECT DISTINCT c.city,c.customer_email FROM customer c")

    @Query(nativeQuery = true, value = "SELECT c.customer_name, a.account_number, a.balance " +
            "FROM account a " +
            "JOIN customer c ON a.customer_id = c.customer_id " +
            "WHERE a.account_number = :accountNumber")
    List<Map<String, Object>> findCustomerAndAccountDetailsByAccountNumber(
            @Param("accountNumber") String accountNumber);

}
