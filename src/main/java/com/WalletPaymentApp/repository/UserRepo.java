package com.WalletPaymentApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.WalletPaymentApp.model.Users;

@Repository
public interface UserRepo extends JpaRepository<Users, String> {

	Users findByUserId(String userId);

}
