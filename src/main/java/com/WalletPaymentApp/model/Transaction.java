package com.WalletPaymentApp.model;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Transaction {
	
	@Id
	private int id;
	private int wallet_id;
	private String Status;
	private double Amount;
	private  LocalDate date = LocalDate.now();
	private LocalTime time=LocalTime.now();
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getWallet_id() {
		return wallet_id;
	}
	public void setWallet_id(int wallet_id) {
		this.wallet_id = wallet_id;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public double getAmount() {
		return Amount;
	}
	public void setAmount(double amount) {
		Amount = amount;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}
	/**
	 * @param id
	 * @param wallet_id
	 * @param status
	 * @param amount
	 * @param date
	 * @param time
	 */
	public Transaction(int id, int wallet_id, String status, double amount, LocalDate date, LocalTime time) {
		super();
		this.id = id;
		this.wallet_id = wallet_id;
		Status = status;
		Amount = amount;
		this.date = date;
		this.time = time;
	}
	public char[] getRid() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
