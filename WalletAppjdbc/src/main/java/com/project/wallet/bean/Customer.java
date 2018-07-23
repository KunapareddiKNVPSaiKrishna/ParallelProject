package com.project.wallet.bean;

public class Customer {

	
	private String Name;
	private int age;
	private String gender;
	private Long mobileNumber;
	private Long aadharNumber;
	private String email;
	private long acntNumber;
	

	public long getacntNum() {
		return acntNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.acntNumber = accountNumber;
	}

	public String getName() {
		return Name;
	}

	public void setName(String fullName) {
		this.Name = fullName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Long getmobileNumber() {
		return mobileNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.mobileNumber = phoneNumber;
	}

	public Long getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(Long aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String emailID) {
		this.email = emailID;
	}
}