package com.project.wallet.bean;

import java.time.LocalDate;
import java.util.List;

public class Account {

	
	public Customer customer;

	private List<String> pTrans;
	
	

	private long acntNum;
	private String password;
	private LocalDate date;
	private int transactionID;
	private double bal;
	private double withdraw;
	private double deposit;

	
	@Override
	public String toString() {
		return "AccountDetails [customer=" + customer + ", accountNumber=" + acntNum + ", password=" + password
				+ ", date=" + date + ", transId=" + transactionID + ", balance=" + bal + ", withdraw=" + withdraw
				+ ", deposit=" + deposit + "]";
	}
	
	public List<String> getpTrans() {
		return pTrans;
	}

	public void setpTrans(List<String> pTrans) {
		this.pTrans = pTrans;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public long getacntNum() {
		return acntNum;
	}

	public void setacntNum(long accountNumber) {
		this.acntNum = accountNumber;
	}

	public double getBal() {
		return bal;
	}

	public void setBal(double balance) {
		this.bal = balance;
	}

	public double getWithdraw() {
		return withdraw;
	}

	public void setWithdraw(double withdraw) {
		this.withdraw = withdraw;
	}

	public double getDeposit() {
		return deposit;
	}

	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate localDate) {
		this.date = localDate;
	}

	
	
	
}
