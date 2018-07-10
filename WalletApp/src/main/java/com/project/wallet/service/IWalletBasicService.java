package com.project.wallet.service;

import com.project.wallet.bean.Account;
import com.project.wallet.exception.WalletException;

public interface IWalletBasicService {

	
	int addAccDao(Account a);
	double depositDao(double money);
	double withdrawDao(double money) ;
	double showBalDao();
	boolean checkLogin(int accNo) throws WalletException;
	boolean checkPassword(String pwd);
	String currentUser();
	boolean transferAmt(int toAccNo, double money) throws WalletException;
	void printTransdetails();
}
