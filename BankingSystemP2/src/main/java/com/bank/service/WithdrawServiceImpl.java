package com.bank.service;

import org.apache.log4j.Logger;

import com.bank.dao.AccountInfoDao;
import com.bank.exception.UserNotFound;
import com.bank.pojo.AccountInfo;

public class WithdrawServiceImpl implements WithdrawService {
	private AccountInfoDao accountInfoDao;
	Logger log = Logger.getRootLogger();

	public WithdrawServiceImpl() {
		super();
	}

	public AccountInfoDao getAccountInfoDao() {
		return accountInfoDao;
	}

	public void setAccountInfoDao(AccountInfoDao accountInfoDao) {
		this.accountInfoDao = accountInfoDao;
	}

	public WithdrawServiceImpl(AccountInfoDao accountInfoDao) {
		super();
		this.accountInfoDao = accountInfoDao;
	}
	@Override
	public AccountInfo withdrawAmt(AccountInfo info) throws UserNotFound {
		try {
			accountInfoDao.withdrawAmt(info);
		}catch(UserNotFound e) {
			log.trace("withdrawAmtService - couldn't withdraw");
		}
		return info;
	}

}
