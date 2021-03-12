package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.bank.exception.UserNotFound;
import com.bank.pojo.AccountInfo;
import com.bank.pojo.User;
import com.bank.util.ConnectionFactoryPostgres;

public class AccountInfoDaoPostgres implements AccountInfoDao {

	Logger log = Logger.getRootLogger();
	Connection conn = ConnectionFactoryPostgres.getConnection();
	PreparedStatement stmt;

	public AccountInfoDaoPostgres() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void depositInfo(AccountInfo info) throws UserNotFound {
		System.out.println("depositInfo");
		String sql = "update account_info set total = total + ? where username =?";
		log.trace("Deposit has been made");

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setDouble(1, info.getTotalBalance());
			stmt.setString(2, info.getUsername());
			stmt.execute();
			conn.close();
		} catch (SQLException e) {
			log.info("Couldn't deposit money to your account");
			e.printStackTrace();
		}
	}

	@Override
	public AccountInfo getInfo(String username) throws UserNotFound {
		
		
		String sql = "select bu.firstname,bu.lastname,ai.username,ai.total,ai.accounttype from account_info ai,bank_user bu where ai.username = bu.username and ai.username= ?";
		AccountInfo info = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				log.info("User is present in DB");
				info = new AccountInfo();
				info.setUsername(rs.getString("username"));
				info.setTotalBalance(rs.getDouble("total"));
				System.out.println("=======================");
				System.out.println("First Name:"+rs.getString("firstname"));
				System.out.println("Last Name:"+ rs.getString("lastname"));
				System.out.println("Username:"+ info.getUsername());
				System.out.println("Total Balance:" + info.getTotalBalance());
				System.out.println("AccountType:" + rs.getString("accounttype"));
			}
		} catch (SQLException e) {
			log.error("Failed to getInfo from Database");
			e.printStackTrace();
		}
		return info;
	}

	@Override
	public AccountInfo createAccount(AccountInfo info) {
		String sql1="select nextval('account_id_seq')";
		int acc_id=0;;
		try {
			stmt= conn.prepareStatement(sql1);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				acc_id= rs.getInt("nextval");
			}
		}catch(SQLException e) {
			
		}
		
		String sql = "insert into account_info (account_id,total,accounttype,username) values (?,?,?,?)";
		log.info("Checking Account created for:" + info.getUsername());
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, acc_id);
			stmt.setDouble(2, 0.0);
			stmt.setString(3, "Checking");
			stmt.setString(4, info.getUsername());
			stmt.execute();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			log.info("Couldn't createAccount ");
		}

		return info;
	}

	@Override
	public void withdrawAmt(AccountInfo info) {
		// TODO Auto-generated method stub
		System.out.println("withdrawAmt - AccountInfoDaoPostgres");
		String sql = "update account_info set total = total - ? where username =?";
		log.trace("You have successfully withdrawn money from your account ");

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setDouble(1, info.getTotalBalance());
			stmt.setString(2, info.getUsername());
			stmt.execute();
			conn.close();
		} catch (SQLException e) {
			log.info("Couldn't withdraw money from your account");
			e.printStackTrace();
		}
	}

}
