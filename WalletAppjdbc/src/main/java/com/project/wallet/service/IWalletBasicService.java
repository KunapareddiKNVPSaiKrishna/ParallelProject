package com.project.wallet.service;

import java.sql.SQLException;
import java.util.List;

import com.project.wallet.bean.Account;

public interface IWalletBasicService {
	boolean testLogin(long accountNumber, String password) throws SQLException;

	boolean addAccountDetails(Account account) throws SQLException;

	Double showBalance() throws SQLException;

	boolean deposit(double amount) throws SQLException;

	boolean withdraw(double amount) throws SQLException;

	boolean printTransaction() throws SQLException, ClassNotFoundException;

	boolean fundTransfer(long payeeAccountNumber, double amount) throws SQLException;
}