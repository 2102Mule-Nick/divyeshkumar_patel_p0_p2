package com.bank.service;

import org.apache.log4j.Logger;

import com.bank.dao.AccountInfoDao;
import com.bank.exception.InvalidPassword;
import com.bank.exception.UserNotFound;
import com.bank.pojo.AccountInfo;

public class DepositServiceImpl implements DepositService {
	private AccountInfoDao accountInfoDao;
	Logger log= Logger.getRootLogger();

	public DepositServiceImpl() {
		super();
	}

	public DepositServiceImpl(AccountInfoDao accountInfoDao) {
		super();
		this.accountInfoDao=accountInfoDao;
	}

	@Override
	public AccountInfo depositAmt(AccountInfo info) throws InvalidPassword, UserNotFound {
		//Service to deposit money into the account
		try{
			accountInfoDao.depositInfo(info);
		}catch(UserNotFound e) {
			log.trace("depositAmt - couldn't deposit");
			e.printStackTrace();
		}
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
