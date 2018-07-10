package com.project.wallet.bean;

import java.util.ArrayList;

public class Account {
	
	private int accNum;
	private String custName;
	private String custPhoneNo;
	private int custAge;
	private double custBal;
	static private int accNumGen = 10100;
	private String custPwd;
	ArrayList<String> tDetails = new ArrayList<String>();
	public ArrayList<String> gettDetails() {
		return tDetails;
	}
	public void settDetails(String getDetails) {
		this.tDetails.add(getDetails);
	}
	public int getAccNum() {
		return accNum;
	}
	public void setAccNum() {
		this.accNum = accNumGen++;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustPhoneNo() {
		return custPhoneNo;
	}
	public void setCustPhoneNo(String custPhoneNo) {
		this.custPhoneNo = custPhoneNo;
	}
	public int getCustAge() {
		return custAge;
	}
	public void setCustAge(int custAge) {
		this.custAge = custAge;
	}
	public double getCustBal() {
		return custBal;
	}
	public void setCustBal(double custBal) {
		this.custBal = custBal;
	}
	public String getCustPwd() {
		return custPwd;
	}
	public void setCustPwd(String custPwd) {
		this.custPwd = custPwd;
	}
}
