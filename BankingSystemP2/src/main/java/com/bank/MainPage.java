package com.bank;

import java.util.Scanner;

import com.bank.dao.AccountInfoDao;
import com.bank.dao.UserDao;
import com.bank.dao.UserDaoPostgres;
import com.bank.service.AuthService;
import com.bank.service.AuthServiceImpl;
import com.bank.ui.AccountMenu;
import com.bank.ui.DepositMenu;
import com.bank.ui.LoginMenu;
import com.bank.ui.Menu;
import com.bank.ui.RegistrationMenu;
import com.bank.ui.WelcomeMenu;

public class MainPage {

	public MainPage() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		UserDao userDao = new UserDaoPostgres();
		AuthService authService = new AuthServiceImpl(userDao);
		
		Menu deposit = new DepositMenu();
		Menu register = new RegistrationMenu();
		Menu account = new AccountMenu(deposit);
		Menu login = new LoginMenu(authService,account);
		
		Menu welcomeMenu = new WelcomeMenu(login,register,deposit,account);
		
		((RegistrationMenu) register).setWelcomeMenu(welcomeMenu);
		((RegistrationMenu) register).setAuthService(authService);
		
		login.setScanner(scan);
		register.setScanner(scan);
		welcomeMenu.setScanner(scan);
		deposit.setScanner(scan);
		account.setScanner(scan);
		
		Menu nextMenu = welcomeMenu;
		do {
			nextMenu.displayOptions();
			
			nextMenu = nextMenu.advance();
		}while(nextMenu != null);
		
	}

}
