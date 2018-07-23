package com.project.wallet.service;

import java.util.List;

import com.project.wallet.bean.Account;
import com.project.wallet.dao.WalletAccess;

public class WalletBasicService implements IWalletBasicService {
	
	WalletAccess wallet = new WalletAccess();

	
	public boolean addAccountDetails(Account account) {

		return wallet.addAccountDetails(account);
	}


	public Double showBalance() {

		return wallet.showBalance();
	}

	
	public boolean deposit(double amount) {

		return wallet.deposit(amount);
	}

	
	public boolean withdraw(double amount) {

		return wallet.withdraw(amount);
	}

	
	public boolean printTransaction() {

		return wallet.printTransaction();
	}

	
	public boolean fundTransfer(long payeeAccountNumber, double amount) {

		return wallet.fundTransfer(payeeAccountNumber, amount);
	}

	
	public boolean testLogin(long accountNumber, String password) {

		return wallet.testLogin(accountNumber, password);
	}


}