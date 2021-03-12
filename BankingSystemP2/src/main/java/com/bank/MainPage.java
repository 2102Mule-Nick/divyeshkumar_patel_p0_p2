package com.bank;

import java.util.Scanner;

import com.bank.dao.AccountInfoDao;
import com.bank.dao.AccountInfoDaoPostgres;
import com.bank.dao.UserDao;
import com.bank.dao.UserDaoPostgres;
import com.bank.service.AccountService;
import com.bank.service.AccountServiceImpl;
import com.bank.service.AuthService;
import com.bank.service.AuthServiceImpl;
import com.bank.service.DepositService;
import com.bank.service.DepositServiceImpl;
import com.bank.service.WithdrawService;
import com.bank.service.WithdrawServiceImpl;
import com.bank.ui.AccountMenu;
import com.bank.ui.AccountSummaryMenu;
import com.bank.ui.DeleteUserMenu;
import com.bank.ui.DepositMenu;
import com.bank.ui.LoginMenu;
import com.bank.ui.Menu;
import com.bank.ui.RegistrationMenu;
import com.bank.ui.UpdateMenu;
import com.bank.ui.WelcomeMenu;
import com.bank.ui.WithdrawMenu;

public class MainPage {

	public MainPage() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		UserDao userDao = new UserDaoPostgres();
		AccountInfoDao accountInfoDao = new AccountInfoDaoPostgres();
		AuthService authService = new AuthServiceImpl(userDao);
		AccountService accountService = new AccountServiceImpl(accountInfoDao);
		DepositService depositService = new DepositServiceImpl(accountInfoDao);
		WithdrawService withdrawService = new WithdrawServiceImpl(accountInfoDao);
		
		Menu removeUser = new DeleteUserMenu(authService);
		Menu update = new UpdateMenu(authService);
		Menu withdraw = new WithdrawMenu(withdrawService);
		Menu summary= new AccountSummaryMenu();
		Menu deposit = new DepositMenu(depositService);
		Menu register = new RegistrationMenu();
		Menu account = new AccountMenu(deposit,summary,withdraw,update,removeUser);
		Menu login = new LoginMenu(authService,account);
		
		
		Menu welcomeMenu = new WelcomeMenu(login,register,deposit,account,summary);
		
		((RegistrationMenu) register).setWelcomeMenu(welcomeMenu);
		((RegistrationMenu) register).setAuthService(authService);
		((RegistrationMenu) register).setAccountService(accountService);
		
		((DepositMenu) deposit).setDepositService(depositService);
		((AccountSummaryMenu) summary).setAccountService(accountService);
		((WithdrawMenu) withdraw).setWithdrawService(withdrawService);
		((DeleteUserMenu) removeUser).setAuthService(authService);
		
		login.setScanner(scan);
		register.setScanner(scan);
		welcomeMenu.setScanner(scan);
		deposit.setScanner(scan);
		account.setScanner(scan);
		summary.setScanner(scan);
		withdraw.setScanner(scan);
		update.setScanner(scan);
		removeUser.setScanner(scan);
		
		Menu nextMenu = welcomeMenu;
		do {
			nextMenu.displayOptions();
			
			nextMenu = nextMenu.advance();
		}while(nextMenu != null);
		
	}

}
