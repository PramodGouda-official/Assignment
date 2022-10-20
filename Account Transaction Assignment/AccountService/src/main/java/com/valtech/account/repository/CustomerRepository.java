package com.valtech.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.account.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
