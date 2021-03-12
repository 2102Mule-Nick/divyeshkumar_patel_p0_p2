package com.bank.service;

import org.apache.log4j.Logger;

import com.bank.dao.UserDao;
import com.bank.exception.InvalidPassword;
import com.bank.exception.UserNameTaken;
import com.bank.exception.UserNotFound;
import com.bank.pojo.AccountInfo;
import com.bank.pojo.User;

public class AuthServiceImpl implements AuthService {

	Logger log = Logger.getRootLogger();
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public AuthServiceImpl() {
		super();
	}

	@Override
	public boolean existingUser(User user) {
		log.trace("AuthServiceImpl.existingUser method");
		try {
			if (userDao.getUserByUsername(user.getUsername()) != null) {
				return true;
			}
		} catch (UserNotFound e) {
			return false;
		}
		return false;
	}

	@Override
	public User authenticateUser(User user) throws InvalidPassword, UserNotFound {

		User existingUser = userDao.getUserByUsername(user.getUsername());
		if (existingUser.getPassword().equals(user.getPassword())) {
			return existingUser;
		}
		throw new InvalidPassword();
	}

	@Override
	public User registerUser(User user) throws UserNameTaken {
		// TODO Auto-generated method stub
		log.trace("Register User ");
		try {
			userDao.createUser(user);
		} catch (UserNotFound e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public boolean updateUser(User user, String new_password) {
		log.info("Update User Method");
		try {
			userDao.updateUser(user,new_password) ;
			return true;
		} catch (UserNotFound e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidPassword e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean removeUser(User user)  {
		if(existingUser(user)) {
			try {
				userDao.removeUser(user);
				return true;
			} catch (UserNotFound | InvalidPassword e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		return false;
	}

	public AuthServiceImpl(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public AccountInfo checkAccount(AccountInfo info) {
		// TODO Auto-generated method stub
		return null;
	}
}
