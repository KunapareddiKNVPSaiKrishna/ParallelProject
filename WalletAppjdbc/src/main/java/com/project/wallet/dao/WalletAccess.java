package com.project.wallet.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.project.wallet.bean.Account;

public class WalletAccess implements IWalletAccess {

	Account login = new Account();
	DBUtil util = new DBUtil();

	int n = 0, n1 = 0;
	static ResultSet rs1;

	public boolean addAccountDetails(Account account) throws SQLException {

		try {
			String insertQuery1 = "insert into account values(?,?,?,?,?)";
			PreparedStatement pstmt1 = util.getConnection().prepareStatement(insertQuery1);

			pstmt1.setLong(1, account.getacntNum());
			pstmt1.setString(2, account.getPassword());
			pstmt1.setDouble(3, account.getBal());
			pstmt1.setDouble(4, account.getWithdraw());
			pstmt1.setDouble(5, account.getDeposit());
			n1 = pstmt1.executeUpdate();

			String insertQuery2 = "insert into customer values(?,?,?,?,?,?,?)";
			PreparedStatement pstmt2 = util.getConnection().prepareStatement(insertQuery2);

			pstmt2.setString(1, account.customer.getName());
			pstmt2.setInt(2, account.customer.getAge());
			pstmt2.setString(3, account.customer.getGender());
			pstmt2.setLong(4, account.customer.getmobileNumber());
			pstmt2.setString(5, account.customer.getEmail());
			pstmt2.setLong(6, account.customer.getAadharNumber());
			pstmt2.setLong(7, account.customer.getacntNum());
			n = pstmt2.executeUpdate();

			return true;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean testLogin(long accountNumber, String password) throws SQLException {

		try {

			String select = "select * from account";
			PreparedStatement pstmt = util.getConnection().prepareStatement(select);
			ResultSet s = pstmt.executeQuery();
			while (s.next()) {
				long acc = s.getLong("accountnumber");
				String pass = s.getString("password");
				if ((accountNumber == acc) && (password.equals(pass))) {
					login.setacntNum(accountNumber);

					return true;
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public double showBalance() throws SQLException {

		try {

			String select = "select balance from account where accountnumber=?";
			PreparedStatement pstmt = util.getConnection().prepareStatement(select);
			pstmt.setLong(1, login.getacntNum());
			ResultSet s1 = pstmt.executeQuery();
			if (s1.first()) {
				double result = s1.getDouble("balance");
				return result;
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return 0;

	}

	public boolean deposit(double amount) throws SQLException {

		try {
			double result = showBalance();

			double bal = result + amount;

			String select = "update  account set balance=? where accountnumber=?";

			PreparedStatement pstmt = util.getConnection().prepareStatement(select);
			pstmt.setDouble(1, bal);
			pstmt.setLong(2, login.getacntNum());

			pstmt.executeUpdate();

			String insert = "insert into transactions values(?,?,?)";

			PreparedStatement pstmt1 = util.getConnection().prepareStatement(insert);
			int transid = (int) (Math.random() * 10000 + 9999);
			String details = (" amount : " + amount + " is credited");
			pstmt1.setLong(1, login.getacntNum());
			pstmt1.setInt(2, transid);
			pstmt1.setString(3, details);
			pstmt1.executeUpdate();

			return true;

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;

	}

	public boolean withdraw(double amount) throws SQLException {

		double result = showBalance();


		double bal = result - amount;

			

		String select = "update  account set balance=? where accountnumber=?";

		PreparedStatement pstmt;
		try {
			pstmt = util.getConnection().prepareStatement(select);

			pstmt.setDouble(1, bal);
			pstmt.setLong(2, login.getacntNum());

			pstmt.executeUpdate();

			String insert = "insert into transactions values(?,?,?)";

			PreparedStatement pstmt1 = util.getConnection().prepareStatement(insert);
			int transid = (int) (Math.random() * 10000 + 9999);
			String details = (" amount : " + amount + " is withdrawn/transfered");
			pstmt1.setLong(1, login.getacntNum());
			pstmt1.setInt(2, transid);
			pstmt1.setString(3, details);
			pstmt1.executeUpdate();
			return true;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	public boolean printTransaction() throws ClassNotFoundException, SQLException {

		String select = "select * from transactions where accountnumber=?";
		PreparedStatement pstmt = util.getConnection().prepareStatement(select);

		pstmt.setLong(1, login.getacntNum());
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {

			System.out.println(rs.getString(3));
		}
		return true;
	}

	public boolean fundTransfer(long payeeAccountNumber, double amount) throws SQLException {

		withdraw(amount);

		try {

			String select = "select balance from account where accountnumber=?";
			PreparedStatement pstmt = util.getConnection().prepareStatement(select);
			pstmt.setLong(1, payeeAccountNumber);
			ResultSet s1 = pstmt.executeQuery();
			if (s1.first()) {

				double result = s1.getDouble("balance");
				double bal = result + amount;
				String select1 = "update  account set balance=? where accountNumber=?";

				PreparedStatement pstmt1 = util.getConnection().prepareStatement(select1);
				pstmt1.setDouble(1, bal);
				pstmt1.setLong(2, payeeAccountNumber);

				pstmt1.executeUpdate();

				String insert = "insert into transactions values(?,?,?)";

				PreparedStatement pstmt2 = util.getConnection().prepareStatement(insert);
				int transid = (int) (Math.random() * 10000 + 9999);
				String details = ( amount + " is tranasfered from " + login.getacntNum());
				pstmt2.setLong(1, login.getacntNum());
				pstmt2.setInt(2, transid);
				pstmt2.setString(3, details);
				pstmt2.executeUpdate();

				return true;

			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;

	}

}