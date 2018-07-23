package com.project.wallet.service;

public class WalletDataValidate {

public boolean validateMobileNumber(Long phoneNumber) {
		
		if(phoneNumber.toString().length()==10) {
			return true;
		}
		else
			return false;
	}
	
	
	public boolean validateAadharNumber(Long aadharNumber) {
		
		
		if(aadharNumber.toString().length()==12) {
			return true;
		}
		else
		return false;
	}
	
}
