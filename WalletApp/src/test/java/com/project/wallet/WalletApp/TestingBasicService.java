package com.project.wallet.WalletApp;

import static org.junit.Assert.*;

import org.junit.Test;

import com.project.wallet.bean.Account;
import com.project.wallet.dao.WalletAccess;
import com.project.wallet.exception.WalletException;
import com.project.wallet.service.WalletBasicService;

import junit.framework.Assert;

public class TestingBasicService {

	@Test
	public void testValidatePhoneNo() {
		WalletBasicService check = new WalletBasicService();
	
	Assert.assertEquals(true, check.validateCustPhoneNumber("9874563210"));
		
	}
	
	@Test
	public void testValidateName() {
		WalletBasicService check = new WalletBasicService();
	
	Assert.assertEquals(true, check.validateCustName("Peter Parker"));
		
	}
	
	@Test
	public void testValidatePwd() {
		WalletBasicService check = new WalletBasicService();
	
	Assert.assertEquals(true, check.validateCustPwd("Abcd123@"));
		
	}

	@Test
	public void testValidateAge()
	{
		WalletBasicService check = new WalletBasicService();
		Assert.assertEquals(true, check.validateCustAge(34));
	}
	
	@Test
	public void testValidateAmt()
	{
		WalletBasicService check = new WalletBasicService();
		Assert.assertEquals(true, check.validateAmt(2000.00));
	}
	@Test
	public void testValidatePhoneNoFail() {
		WalletBasicService check = new WalletBasicService();
	
	assertEquals(false, check.validateCustPhoneNumber("8745621212121"));
		
	}
	
	@Test
	public void testValidateNameFail() {
		WalletBasicService check = new WalletBasicService();
	
	Assert.assertEquals(false, check.validateCustName("Matt123"));
		
	}
	
	@Test
	public void testValidatePwdFail() {
		WalletBasicService check = new WalletBasicService();
	
	Assert.assertEquals(false, check.validateCustPwd("@! SAm.IY"));
		
	}

	@Test
	public void testValidateAgeFail()
	{
		WalletBasicService check = new WalletBasicService();
		Assert.assertEquals(false, check.validateCustAge(152));
	}
	
	@Test
	public void testValidateAmtFail()
	{
		WalletBasicService check = new WalletBasicService();
		Assert.assertEquals(false, check.validateAmt(0.00));
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testAccCreation()
	{
		WalletAccess w = new WalletAccess();
		Account a = new Account();
		Assert.assertEquals(10100,w.accCreation(a));
		Account a1 = new Account();
		Assert.assertEquals(10101,w.accCreation(a1));
		Account a2 = new Account();
		Assert.assertEquals(10102,w.accCreation(a2));
		
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testDepositAmt()
	{
		WalletBasicService w = new WalletBasicService();
		Account a = new Account();
		Assert.assertEquals(2000.00, w.depositDao(2000.00));
		Assert.assertEquals(4000.00, w.depositDao(2000.00));
		
	}
	@SuppressWarnings("deprecation")
	@Test
	public void testWithdrawAmt() throws Exception
	{
		WalletBasicService w = new WalletBasicService();
		Account a = new Account();
		
		Assert.assertEquals(4000.00, w.depositDao(4000.00));
		Assert.assertEquals(2000.00, w.withdrawDao(2000.00));
		Assert.assertEquals(00.00, w.withdrawDao(2000.00));
		
	}
	
	@Test
	public void testDispBal()
	{
		WalletBasicService w = new WalletBasicService();
		Account a = new Account();
		Assert.assertEquals(0.00,w.showBalDao());
		
		
	}
	
	@Test
	public void testLogin() throws WalletException
	{
		WalletAccess w = new WalletAccess();
		Account a = new Account();
		w.accCreation(a);
		Account a1 = new Account();
		w.accCreation(a1);
		Account a2 = new Account();
		w.accCreation(a2);
		Account a3 = new Account();
		w.accCreation(a3);
		System.out.println(a3.getAccNum());
		Assert.assertEquals(a1, w.loginUser(10104));
	}
}
