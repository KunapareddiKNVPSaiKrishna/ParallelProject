package com.project.wallet.dao;

import java.util.TreeMap;

import com.project.wallet.bean.Account;
import com.project.wallet.exception.WalletException;

public class WalletAccess implements IWalletAccess {
	
	TreeMap<Integer, Account> map = new TreeMap<Integer, Account>();
	
	public int accCreation(Account a) {
		a.setAccNum();
		map.put(a.getAccNum(), a);
		return a.getAccNum();
	}

	public Account loginUser(int accNo) throws WalletException {
		Account temp = new Account();
		
		try {
			temp = map.get(accNo);
			return temp;
				
		}
		catch(NullPointerException e) {
			if(temp==null)
			throw new WalletException("There is no such Account");
		}
		return null;
	}

	public void updateDetails(int accNo, Account a) {
		map.replace(accNo, a);
		
	}

}
