package com.project.wallet.WalletApp;

import com.project.wallet.bean.Account;
import com.project.wallet.bean.Customer;

import junit.framework.Assert;
import junit.framework.TestCase;

public class AccountDetailsTest extends TestCase{
        Account acount = new Account();
        Customer customer = new Customer();
        
        
        public void testGetName() {
        	customer.setName("saikrishna");
        	Assert.assertEquals("saikrishna",customer.getName());
        	Assert.assertNotSame("krishna",customer.getName());
        	Assert.assertEquals("sai",customer.getName());
        	
        	
        }
        public void TestGetPassword() {
        	
        	acount.setPassword("saikrishna123@");
        	Assert.assertEquals("saikrishna123@",acount.getPassword());
        	Assert.assertNotSame("sai",acount.getPassword());
        	Assert.assertEquals("krishna",acount.getPassword());
        	
        }
        public void testGetGender() {
        	
        customer.setGender("Male");
        Assert.assertEquals("Male",customer.getGender());
    	Assert.assertNotSame("fsd",customer.getGender());
        }
        public void testGetAge() {
        	customer.setAge(24);
        	 Assert.assertEquals("24",customer.getAge());
         	Assert.assertNotSame("12",customer.getAge());
         	Assert.assertEquals("12",customer.getAge());
        	
        	
        }
        public void testGetMobileNumber() {
        	
        	 Assert.assertEquals("9854845484",customer.getMobileNumber());
          	Assert.assertNotSame("sai",customer.getMobileNumber());
        	
        }
        public void testGetAadharNumber() {
        	Assert.assertEquals("985484548411",customer.getAadharNumber());
          	Assert.assertNotSame("sai",customer.getAadharNumber());
        	
        }
        public void testGetEmail() {
        	Assert.assertEquals("da@gjj",customer.getEmail());
          	Assert.assertNotSame("sai",customer.getEmail());
        	
        	
        }
}
