package com.project.wallet.dao;

import java.sql.SQLException;
import java.util.List;

import com.project.wallet.bean.Account;

public interface IWalletAccess {

	boolean testLogin(long accountNumber, String password) throws SQLException;

	boolean addAccountDetails(Account account) throws SQLException;

	double showBalance() throws SQLException;

	boolean deposit(double amount) throws SQLException;

	boolean withdraw(double amount) throws SQLException;

	boolean printTransaction() throws ClassNotFoundException, SQLException;

	boolean fundTransfer(long payeeAccountNumber, double amount) throws SQLException;
}
