package com.bank.service;

import com.bank.exception.InvalidPassword;
import com.bank.exception.UserNotFound;
import com.bank.pojo.AccountInfo;

public interface DepositService {

	public AccountInfo depositAmt(AccountInfo info) throws InvalidPassword,UserNotFound;
	public AccountInfo getDepositInfo(AccountInfo info);
	}
