package com.project.wallet.WalletApp;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.project.wallet.bean.Account;
import com.project.wallet.exception.WalletException;
import com.project.wallet.service.WalletBasicService;

public class User {
public static void main(String[] args) throws WalletException  {
	

	int choice, age = 0,custAccId;
	String phoneNo,name = null,pwd;
boolean nameFlag=false,ageFlag=false,pwdFlag=false,phoneNoFlag=false,amtFlag=false;
double amt;
boolean loginCheck = false;

Scanner get = new Scanner(System.in);


	WalletBasicService service = new WalletBasicService();
	do {
		System.out.println("\n************* XYZ MyWallet *************");
		System.out.println("Choose an operation");
		System.out.println("1. Create New Account");
		System.out.println("2. Login");
		System.out.println("3. Exit");
		System.out.println("******************************");
		System.out.print("\nPlease Enter a Choice : ");
		choice = get.nextInt();
		System.out.println("\n******************************");
		switch(choice)
		{
		
		
			case 1 :// Creating a new Account for the user
				{
					get.nextLine();
					//customer name
					while(nameFlag==false)
					{
						System.out.println("Enter the name of the Customer :");
						name=get.nextLine();
						nameFlag=service.validateCustName(name);
						nameFlag = true;
						if(nameFlag==false)
							System.out.println("Name should be entered in proper format(eg.Robert Downey)");
						
					}
					
			
					//Customer Age
					while(ageFlag==false)
					{
					System.out.println("Enter Customer age : ");
					
					age = get.nextInt();
					ageFlag= service.validateCustAge(age);
					if(ageFlag==false)
						{System.out.println("Age should be below 110");
					continue;}
					}
				
					
					//Customer Phone Number
					do
					{
						System.out.println("Enter Customer phone number : ");
						phoneNo = get.next();
						phoneNoFlag = service.validateCustPhoneNumber(phoneNo);
						if(phoneNoFlag==false)
							System.out.println("Phone number should be of 10 digits");
					}while(phoneNoFlag==false);
					
					//initial deposit amount
					do
					{
						System.out.println("Enter the initial amount to be deposited : ");
						amt = get.nextDouble();
						amtFlag = service.validateAmt(amt);
						if(amtFlag==false)
							System.out.println("initial deposit can be greater than 0.00");
					}while(amtFlag==false);
					//set password for the Account
					do
					{
						System.out.println("Set password for your account : ");
						pwd = get.next();
						pwdFlag = service.validateCustPwd(pwd);
						if(pwdFlag==false)
							System.out.println("incorrect pattern, password eg:Abc123@");
					}while(pwdFlag==false);
					Account newUser = new Account();
					
					newUser.setCustName(name);
					newUser.setCustAge(age);
					newUser.setCustPhoneNo(phoneNo);
					newUser.setCustBal(amt);
					newUser.setCustPwd(pwd);
					custAccId = service.addAccDao(newUser);
					System.out.println("Account created successfully");
					System.out.println("Your Account number is "+custAccId);
					break;
	}
				
			case 2:
			{	
				
				pwdFlag = false;
				System.out.println("\n************* XYZ MyWallet *************");
				System.out.println("Enter the Account Number :");
				//logic for user id check;
				custAccId = get.nextInt();
				loginCheck = service.checkLogin(custAccId);
				if(loginCheck==true)
				{
					
					do {
						System.out.println("Enter the Password");
						//logic for password check;
						pwd = get.next();
						pwdFlag = service.checkPassword(pwd);
							if(pwdFlag==true)
							{
								do {
								System.out.println("\n*********** Welcome " +service.currentUser()+" ***********");
								System.out.println("Choose an operation");
								System.out.println("1. Deposit Amount");
								System.out.println("2. Withdraw Amount");
								System.out.println("3. Show Balance");
								System.out.println("4. Fund Transfer");
								System.out.println("5. Print Transactions");
								System.out.println("6. Exit");
								System.out.println("******************************");
								System.out.print("\nPlease Enter a Choice : ");
								choice = get.nextInt();
								System.out.println("\n******************************");
								switch(choice)
								{
							
								case 1:
								{
									
									do
									{
										System.out.println("Enter the Amount to be deposited :");
										amt = get.nextDouble();
										amtFlag = service.validateAmt(amt);
										if(amtFlag==false)
											System.out.println("Amount Should be greater than 0.00");
									}while(amtFlag==false);
									amt = service.depositDao(amt);
									System.out.println("Your current balance is :"+amt);
									break;
								}
								case 2:
								{
									
									do
									{
										System.out.println("Enter the Amount to be Withdrawn :");
										amt = get.nextDouble();
										amtFlag = service.validateAmt(amt);
										if(amtFlag==false)
											System.out.println("Amount Should be greater than 0.00");
									}while(amtFlag==false);
									amt = service.withdrawDao(amt);
									System.out.println("Your current balance is :"+amt);
									break;
								}
								case 3:
								{
									
									amt = service.showBalDao();
									System.out.println("Your current balance is :"+amt);
									break;
								}
								
								case 4:
									System.out.println("Enter the Account Number to which u have to send :");
									int ftAccNo = get.nextInt();
									String ftName;
									double ftAmt;
									do
									{
										System.out.println("Enter the name of the Account Holder :");
										 ftName = get.next();
										nameFlag=service.validateCustName(ftName);
										if(nameFlag==false)
											System.out.println("Name should be entered in proper format(eg.Robert Downey)");
										
									}while(nameFlag==false);
									
									do
									{
										System.out.println("Enter the amount to be transfered : ");
										ftAmt = get.nextDouble();
										amtFlag = service.validateAmt(ftAmt);
										if(amtFlag==false)
											System.out.println("should be greater than 0.00");
									}while(amtFlag==false);
									
									boolean ftFlag = service.transferAmt(ftAccNo,ftAmt);
								if(ftFlag==true)
								{
									System.out.println("success");
								}
								break;
								case 5:
									service.printTransdetails();
									break;
							
								}
								System.out.print("Do you want to continue? 1-Yes  0 - No : ");
								choice = get.nextInt();
								}while(choice==1);
								break;
								}
							
					}while(pwdFlag==false);
				}
				else
				{
					System.out.println("invalid login, try again :(");
				}
			System.out.println("Thank You Banking With Us");	
			System.out.println("Wish to go to Main Menu ?\n");	
			
}
		
		}
		
		System.out.print("Do you want to continue? 1-Yes  0 - No : ");
		
		choice = get.nextInt();

}while(choice==1);
	}
}

