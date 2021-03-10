package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.postgresql.core.ConnectionFactory;

import com.bank.exception.UserNotFound;
import com.bank.pojo.User;
import com.bank.util.ConnectionFactoryPostgres;

public class UserDaoPostgres implements UserDao {

	Logger log = Logger.getRootLogger();
	Connection conn = ConnectionFactoryPostgres.getConnection();
	
	PreparedStatement stmt;

	public UserDaoPostgres() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createUser(User user) throws UserNotFound {

		String sql = "insert into bank_user(firstname,lastname,username, pass_word) values (?,?,?,?)";
		log.trace("User has been created ");
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, user.getFirstName());
			stmt.setString(2, user.getLastName());
			stmt.setString(3, user.getUsername());
			stmt.setString(4, user.getPassword());
			stmt.execute();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public User getUserByUsername(String username) throws UserNotFound {
		System.out.println("Inside GetUserBYUsername");
		String sql = "select username,pass_word from bank_user where username=?";
		User user = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				user = new User();
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("pass_word"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("Couldn't connect to DB");
		}
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUser(User user, String new_password) {
		 String sql = "update bank_user set pass_word = ? where username =? and pass_word = ?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, new_password);
			stmt.setString(2, user.getUsername());
			stmt.setString(3, user.getPassword());
			stmt.execute();
			conn.close();
			log.info("The information has been updated");
		} catch (SQLException e) {
			log.info("Unable to update");
		}

	}

	@Override
	public void removeUser(User user) {
		String sql = "delete from bank_user where username = ? and password = ?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, user.getUsername());
			stmt.setString(1, user.getPassword());
			stmt.executeUpdate();
			conn.close();
			log.warn("User deleted!!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub

	}

}
