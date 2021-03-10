package com.bank.dao;

import com.bank.exception.UserNotFound;
import com.bank.pojo.AccountInfo;

public interface AccountInfoDao {

	public void depositInfo(AccountInfo info) throws UserNotFound;
	public AccountInfo getInfo(String username) throws UserNotFound;
	public AccountInfo createAccount(AccountInfo info);
	public void updateInfo(AccountInfo info);
	public void deleteInfo(AccountInfo info);
}
