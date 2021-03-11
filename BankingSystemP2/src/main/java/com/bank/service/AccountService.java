package com.bank.service;

import com.bank.exception.UserNotFound;
import com.bank.pojo.AccountInfo;
import com.bank.pojo.User;

public interface AccountService {

	public AccountInfo registerAccount(AccountInfo info) throws UserNotFound;

	public AccountInfo getSummary(AccountInfo info) throws UserNotFound;
	

}
