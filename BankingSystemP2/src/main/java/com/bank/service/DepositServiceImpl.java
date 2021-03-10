package com.bank.service;

import com.bank.dao.AccountInfoDao;
import com.bank.exception.InvalidPassword;
import com.bank.exception.UserNotFound;
import com.bank.pojo.AccountInfo;

public class DepositServiceImpl implements DepositService {
	private AccountInfoDao accountInfoDao;

	public DepositServiceImpl() {
		super();
	}

	@Override
	public AccountInfo depositAmt(AccountInfo info) throws InvalidPassword, UserNotFound {
		accountInfoDao.depositInfo(info);
		return info;
	}

	public AccountInfoDao getAccountInfoDao() {
		return accountInfoDao;
	}

	public void setAccountInfoDao(AccountInfoDao accountInfoDao) {
		this.accountInfoDao = accountInfoDao;
	}

	@Override
	public AccountInfo getDepositInfo(AccountInfo info) {
		// TODO Auto-generated method stub
		return null;
	}

}
