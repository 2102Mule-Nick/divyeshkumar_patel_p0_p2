package com.bank.service;

import org.apache.log4j.Logger;

import com.bank.dao.AccountInfoDao;
import com.bank.exception.UserNotFound;
import com.bank.pojo.AccountInfo;
import com.bank.pojo.User;
import com.esotericsoftware.minlog.Log;

public class AccountServiceImpl implements AccountService {

	private AccountInfoDao accountInfoDao;
	Logger log = Logger.getRootLogger();

	public AccountServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	public AccountServiceImpl(AccountInfoDao accountInfoDao) {
		// TODO Auto-generated constructor stub
		super();
		this.accountInfoDao = accountInfoDao;
	}

	@Override
	public AccountInfo registerAccount(AccountInfo info) throws UserNotFound {
		log.trace("RegisterAccount Method in AccountserviceImpl");
		try {
			accountInfoDao.createAccount(info);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return info;
	}

	@Override
	public AccountInfo getSummary(AccountInfo info) throws UserNotFound {
		System.out.println("getSummaryMethod");
		log.trace("getSummary Method in AccountServiceImpl");
		try {
			accountInfoDao.getInfo(info.getUsername());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return info;

	}

}
