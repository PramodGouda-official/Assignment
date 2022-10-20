package com.valtech.tx.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.valtech.tx.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
