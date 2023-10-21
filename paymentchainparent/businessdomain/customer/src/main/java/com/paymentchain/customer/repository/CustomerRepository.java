package com.paymentchain.customer.repository;

import com.paymentchain.customer.entity.Customer;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

    public interface CustomerRepository extends JpaRepository<Customer, Long> {

        //Para personalizar el query
        @Query("SELECT c FROM Customer c where c.code = ?1")
        Customer findByCode(String code);

        Optional<Customer> findByIban(String iban);

    }
