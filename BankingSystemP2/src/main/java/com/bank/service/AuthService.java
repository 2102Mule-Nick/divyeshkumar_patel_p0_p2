package com.bank.service;

import com.bank.exception.InvalidPassword;
import com.bank.exception.UserNameTaken;
import com.bank.exception.UserNotFound;
import com.bank.pojo.AccountInfo;
import com.bank.pojo.User;
import com.bank.ui.AccountMenu;

public interface AuthService {

public boolean existingUser(User user);

public User authenticateUser(User user) throws InvalidPassword, UserNotFound;

public AccountInfo checkAccount(AccountInfo info);
public User registerUser(User user) throws UserNameTaken;

public User updateUser(User user, String password);

public boolean removeUser(User user);
}