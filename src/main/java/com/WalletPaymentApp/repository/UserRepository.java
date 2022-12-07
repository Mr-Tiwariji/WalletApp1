package com.WalletPaymentApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.WalletPaymentApp.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	User save(User newUser);

	List<User> findAll();

	Object findById(int id);

}
