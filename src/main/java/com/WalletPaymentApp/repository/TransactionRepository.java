package com.WalletPaymentApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.WalletPaymentApp.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

	

	Transaction save(Transaction transaction);

}
