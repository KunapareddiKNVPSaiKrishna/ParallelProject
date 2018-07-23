package com.project.wallet.service;

import java.util.List;

import com.project.wallet.bean.Account;

public interface IWalletBasicService {
	boolean testLogin(long accountNumber, String password);

	boolean addAccountDetails(Account account);

	Double showBalance();

	boolean deposit(double amount);

	boolean withdraw(double amount);

	boolean printTransaction();

	boolean fundTransfer(long payeeAccountNumber, double amount);
}
