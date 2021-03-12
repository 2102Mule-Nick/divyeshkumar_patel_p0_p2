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

public boolean updateUser(User user, String new_password) throws UserNotFound,InvalidPassword;

public boolean removeUser(User user) throws UserNotFound, InvalidPassword;
}