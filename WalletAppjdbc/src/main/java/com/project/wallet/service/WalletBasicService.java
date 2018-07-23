package com.project.wallet.service;

import java.sql.SQLException;
import java.util.List;

import com.project.wallet.bean.Account;
import com.project.wallet.dao.WalletAccess;

public class WalletBasicService implements IWalletBasicService {
	
	WalletAccess dao = new WalletAccess();

	
	public boolean addAccountDetails(Account account) throws SQLException {

		return dao.addAccountDetails(account);
	}


	public Double showBalance() throws SQLException {

		return dao.showBalance();
	}

	
	public boolean deposit(double amount) throws SQLException {

		return dao.deposit(amount);
	}

	
	public boolean withdraw(double amount) throws SQLException {

		return dao.withdraw(amount);
	}

	
	public boolean printTransaction() throws SQLException, ClassNotFoundException {

		return dao.printTransaction();
	}

	
	public boolean fundTransfer(long payeeAccountNumber, double amount) throws SQLException {

		return dao.fundTransfer(payeeAccountNumber, amount);
	}

	
	public boolean testLogin(long accountNumber, String password) throws SQLException {

		return dao.testLogin(accountNumber, password);
	}


}