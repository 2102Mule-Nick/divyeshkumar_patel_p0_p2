package com.bank.dao;

import com.bank.exception.UserNotFound;
import com.bank.pojo.AccountInfo;
import com.bank.pojo.User;

public interface AccountInfoDao {

	public void depositInfo(AccountInfo info) throws UserNotFound;
	public AccountInfo getInfo(String username) throws UserNotFound;
	public AccountInfo createAccount(AccountInfo info);
	public void withdrawAmt(AccountInfo info) throws UserNotFound;
}
