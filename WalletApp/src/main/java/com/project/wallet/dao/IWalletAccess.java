package com.project.wallet.dao;

import com.project.wallet.bean.Account;
import com.project.wallet.exception.WalletException;

public interface IWalletAccess {
	
	int accCreation(Account a);
	
	Account loginUser(int accNo) throws WalletException;
	
	void updateDetails(int accNo, Account a);

}


