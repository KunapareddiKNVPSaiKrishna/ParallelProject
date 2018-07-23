package com.project.wallet.dao;

import java.util.List;

import com.project.wallet.bean.Account;

public interface IWalletAccess {

	boolean testLogin(long accountNumber, String password);

	boolean addAccountDetails(Account account);

	double showBalance();

	boolean deposit(double amount);

	boolean withdraw(double amount);

	boolean printTransaction();

	boolean fundTransfer(long payeeAccountNumber, double amount);
}
