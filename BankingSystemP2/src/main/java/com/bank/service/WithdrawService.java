package com.bank.service;

import com.bank.exception.UserNotFound;
import com.bank.pojo.AccountInfo;

public interface WithdrawService {
public AccountInfo withdrawAmt(AccountInfo info) throws UserNotFound;

}
