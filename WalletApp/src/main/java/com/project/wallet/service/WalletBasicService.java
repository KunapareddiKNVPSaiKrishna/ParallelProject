package com.project.wallet.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Stream;

import com.project.wallet.bean.Account;
import com.project.wallet.dao.IWalletAccess;
import com.project.wallet.dao.WalletAccess;
import com.project.wallet.exception.WalletException;

public class WalletBasicService implements IWalletBasicService {
	Account temp = new Account();
	IWalletAccess dao;
	 public WalletBasicService() {
		 dao = new WalletAccess();
		 
	}
	 LocalDate tDate = LocalDate.now();
	 static String namePattern = "[A-Z]";
	 static String numberPattern = "(\\d){10}";
	 static String passwordPattern = "[A-Z]{1}[a-z]{2,6}(\\d){1,4}(\\W){1}";
	
	 public  boolean validateCustName(String name)
	 {	if(name.matches(namePattern))
	 		return true;
	 	else
	 		return false;
	 }
	 
	 
	 public  boolean validateCustPhoneNumber(String number) {
			if(number.matches(numberPattern))
				return true;
			else
				return false;
		}
	 
	 
public boolean validateCustAge(int age) {
	if(age<=110&&age>=1)
		return true;
	else
		return false;
	
}

public  boolean validateCustPwd(String pwd) {
	if(pwd.matches(passwordPattern))
		return true;
	else
		return false;
}

public  boolean validateAmt(double amt) {
if(amt>0.00)
	return true;
else
	return false;
}

public int addAccDao(Account a) {
	return dao.accCreation(a);
}

public double depositDao(double money) {
	temp.setCustBal(temp.getCustBal()+money);
	temp.settDetails("Date :"+tDate+" Depsoited Amount :"+money+" Total Balance :"+temp.getCustBal());
	dao.updateDetails(temp.getAccNum(),temp);
	return temp.getCustBal();
}

public double withdrawDao(double money) {
	if(money<temp.getCustBal()) {
		temp.setCustBal(temp.getCustBal()-money);
		temp.settDetails("Date :"+tDate+" Amount Withdrawn :"+money+" Total Balance :"+temp.getCustBal());
		dao.updateDetails(temp.getAccNum(),temp);
		}
		else
			System.out.println(" Low Balance :( ");
		return temp.getCustBal();
}

public double showBalDao() {
	return temp.getCustBal();
}

public boolean checkLogin(int accNo) throws WalletException {
	temp =dao.loginUser(accNo);
	if(temp!=null)
	return true;
	else 
		return false;
}

public boolean checkPassword(String pwd) {
	if(temp.getCustPwd().matches(pwd))
		return true;
	else
		return false;
}

public String currentUser() {
	return temp.getCustName();
}

public boolean transferAmt(int toAccNo, double money) throws WalletException {
	Account ftTemp =new Account();
	if(temp.getCustBal()>=money) {
	ftTemp = dao.loginUser(toAccNo);
	if(ftTemp!=null)
	{
		ftTemp.setCustBal(ftTemp.getCustBal()+money);
		temp.setCustBal(temp.getCustBal()-money);
		temp.settDetails("Date :"+tDate+" Amount Transfered :"+money+" To Acc No: "+ftTemp.getAccNum()+" Total Balance :"+temp.getCustBal());
		ftTemp.settDetails("Date :"+tDate+" Depsoited Amount :"+money+" From Acc No: "+temp.getAccNum()+" Total Balance :"+ftTemp.getCustBal());
		dao.updateDetails(temp.getAccNum(), temp);
		dao.updateDetails(ftTemp.getAccNum(), ftTemp);
		return true;
	}
	
	
}
	else if(temp.getCustBal()<money)
	{
		System.out.println("Low Balance to transfer");
	}
	
	else
		System.out.println("No such user account");
	return false;
}

public void printTransdetails() {
	ArrayList<String> tempDetails = new ArrayList<String>();
	tempDetails = temp.gettDetails();
	Stream printList = tempDetails.stream();
	printList.forEach(System.out::println);
	
}
}



