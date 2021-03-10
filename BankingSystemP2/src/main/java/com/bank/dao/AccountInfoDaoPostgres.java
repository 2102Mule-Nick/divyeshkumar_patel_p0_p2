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
	
		String sql = "insert into Account_info () values()";
		log.trace("Deposit has been made");
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, info.getUsername());
			stmt.execute();
			conn.close();
		} catch (SQLException e) {
			log.info("Couldn't deposit money to your account");
			e.printStackTrace();
		}
	}

	@Override
	public AccountInfo getInfo(String username) throws UserNotFound {
	String sql = "select * from bank_user where username= ?";
	User user =null;
	try {
		stmt=conn.prepareStatement(sql);
		stmt.setString(1, username);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			log.info("User is present in DB");
			user = new User();
			user.setUsername(rs.getString("username"));
			user.setFirstName(rs.getString("firstname"));
			user.setLastName(rs.getString("lastname"));
		}
	}catch(SQLException e) {
		log.error("Failed to getInfo from Database");
	}
		return null;
	}	
	
	@Override
	public AccountInfo createAccount(AccountInfo info) {
		
		String sql = "select user_id from bank_user where username=?";
		User user =null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, user.getUsername());
			ResultSet rs= stmt.executeQuery();
			while(rs.next()) {
				info.setUsername("user_id");
			}
		}catch(SQLException e) {
			log.error("Error in createAccount Method ");
			e.printStackTrace();
		}
		
		return info;
	}

	@Override
	public void updateInfo(AccountInfo info) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteInfo(AccountInfo info) {
		// TODO Auto-generated method stub

	}

	


}
