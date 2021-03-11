package com.bank.ui;

import java.util.Scanner;

import com.bank.dao.AccountInfoDao;
import com.bank.exception.UserNameTaken;
import com.bank.exception.UserNotFound;
import com.bank.pojo.AccountInfo;
import com.bank.pojo.User;
import com.bank.service.AccountService;
import com.bank.service.AuthService;

public class RegistrationMenu implements Menu {

	private Menu welcomeMenu;
	private Menu nextMenu;
	private Scanner scan;
	private AuthService authService;
	private Menu loginMenu;
	private AccountService accountService;

	public RegistrationMenu() {

	}

	@Override
	public Menu advance() {
		// TODO Auto-generated method stub
		return nextMenu;
	}

	public AccountService getAccountService() {
		return accountService;
	}

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	@Override
	public void displayOptions() {
		// This will be displayed as the Registration Menu
		User user = new User();
		AccountInfo info = new AccountInfo();
		
		System.out.println("Enter your First Name:");
		user.setFirstName(scan.nextLine());
		
		System.out.println("Enter your Last Name:");
		user.setLastName(scan.nextLine());
		
		System.out.println("Enter a username:");
		String uname= scan.nextLine();
		user.setUsername(uname);
		info.setUsername(uname);
		
		System.out.println("Enter a password");
		user.setPassword(scan.nextLine());
		if (!authService.existingUser(user)) {
			try {
				authService.registerUser(user);
				accountService.registerAccount(info);
				nextMenu = loginMenu;
			}catch(UserNameTaken e) {
				System.out.println("This is username is taken, please enter a different username");
			nextMenu = welcomeMenu;
			} catch (UserNotFound e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("Username taken, try again");
			nextMenu = welcomeMenu;
		}

	}

	@Override
	public Menu previousMenu() {
		// TODO Auto-generated method stub
		return null;
	}

	public Menu getWelcomeMenu() {
		return welcomeMenu;
	}

	public void setWelcomeMenu(Menu welcomeMenu) {
		this.welcomeMenu = welcomeMenu;
	}

	public Menu getNextMenu() {
		return nextMenu;
	}

	public void setNextMenu(Menu nextMenu) {
		this.nextMenu = nextMenu;
	}

	public Scanner getScan() {
		return scan;
	}

	public void setScan(Scanner scan) {
		this.scan = scan;
	}

	public AuthService getAuthService() {
		return authService;
	}

	public void setAuthService(AuthService authService) {
		this.authService = authService;
	}

	@Override
	public Scanner getScanner() {
		// TODO Auto-generated method stub
		return this.scan;
	}

	@Override
	public void setScanner(Scanner scan) {
		// TODO Auto-generated method stub
		this.scan = scan;

	}

	public RegistrationMenu(AuthService authService, Menu welcomeMenu, Menu loginMenu,AccountService accountService) {
		super();
		this.welcomeMenu = welcomeMenu;
		this.authService = authService;
		this.loginMenu= loginMenu;
		this.accountService=accountService;
	}

}
