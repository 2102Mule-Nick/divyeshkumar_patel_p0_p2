package com.bank.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.bank.dao.UserDaoPostgres;
import com.bank.pojo.AccountInfo;
import com.bank.pojo.User;

class getUserInfo {

	private String username="dk";
	private String pass="dk1234";
	
	User user = new User(username,pass);
	
	@Test
	void getUserInfotest() {
	}

}

