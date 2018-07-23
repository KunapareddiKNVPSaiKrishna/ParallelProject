package com.project.wallet.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.project.wallet.bean.Account;

public class WalletAccess implements IWalletAccess {
	
	
	Account login = new Account();
	Account details = new Account();

	static List<Account> list1 = new ArrayList<Account>();
	static List<String> list2= new ArrayList<String>();
	
	
	static HashMap<Long, Account> hm = new HashMap<Long, Account>();
	
	

	
	public boolean addAccountDetails(Account account) {

		boolean b = list1.add(account);
		if (b) {

			return true;
		} else {
			return false;
		}

	}

	
	public boolean testLogin(long accountNumber, String password) {

		Iterator<Account> it = list1.iterator();
		while (it.hasNext()) {

			Account accountDetails = (Account) it.next();
			if (accountDetails.getAcntNum() == accountNumber) {

				if (accountDetails.getPassword().equals(password)) {

					login.setAcntNum(accountNumber);

					return true;
				}
			}
		}
		return false;

	}

	
	public double showBalance() {

		Iterator<Account> it = list1.iterator();
		while (it.hasNext()) {
			Account accountDetails = (Account) it.next();
			if (accountDetails.getAcntNum() == login.getAcntNum()) {
				return accountDetails.getBal();
			}
		}

		return 0;
	}


	public boolean deposit(double amount) {

		Iterator<Account> it = list1.iterator();
		while (it.hasNext()) {

			Account accountDetails = (Account) it.next();
			if (accountDetails.getAcntNum() == login.getAcntNum()) {
				accountDetails.setDeposit(amount);
				double b = accountDetails.getBal() + accountDetails.getDeposit();
				accountDetails.setBal(b);
				
				String s1 = "The "+amount+"is deposited to "+login.getAcntNum();
				
				accountDetails.getprintTrans().add(s1);
				
				return true;
			}

		}

		return false;

	}

	
	public boolean withdraw(double amount) {

		Iterator<Account> it = list1.iterator();
		while (it.hasNext()) {

			Account accountDetails = (Account) it.next();
			if (accountDetails.getAcntNum() == login.getAcntNum()) {
				accountDetails.setWithdraw(amount);
				if(amount+500<accountDetails.getBal()) {
				double b = accountDetails.getBal() - accountDetails.getWithdraw();
				accountDetails.setBal(b);
				
				String s1 = "The "+amount+"is withdrawn "+login.getAcntNum();
				
				accountDetails.getprintTrans().add(s1);
			
				return true;
				} 
			}

		}

		return false;
	}

	
	public boolean  printTransaction() {
	
		Iterator<Account> it = list1.iterator();
		while (it.hasNext()) {
			Account accountDetails = (Account) it.next();
			if(accountDetails.getAcntNum() == login.getAcntNum()) {
				System.out.println(accountDetails.getprintTrans());
			}
		}
				
		return false;
	}
		
		
		
		
	

	
	public boolean fundTransfer(long payeeAccountNumber, double amount) {

		
		Iterator<Account> it = list1.iterator();
		while (it.hasNext()) {

			Account accountDetails = (Account) it.next();
			if (accountDetails.getAcntNum() == login.getAcntNum()) {
				accountDetails.setWithdraw(amount);
				double b = accountDetails.getBal() - accountDetails.getWithdraw();
				accountDetails.setBal(b);

				

				String s1 = "The "+amount+"is deposited to "+login.getAcntNum();
				
				accountDetails.getprintTrans().add(s1);
				
				
			}
		}
		
		Iterator<Account> it1 = list1.iterator();
		while (it1.hasNext()) {
			Account accountDetails = (Account) it1.next();
			if (accountDetails.getAcntNum() == payeeAccountNumber) {
				accountDetails.setDeposit(amount);
				double b = accountDetails.getBal() + accountDetails.getDeposit();
				accountDetails.setBal(b);

				

				String s1 = "The "+amount+"is deposited to "+payeeAccountNumber;
				
				accountDetails.getprintTrans().add(s1);
				
				
				
				return true;
			} 
		}

		return false;

	}

}
