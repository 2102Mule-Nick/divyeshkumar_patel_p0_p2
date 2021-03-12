package com.bank.ui;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.bank.exception.InvalidPassword;
import com.bank.exception.UserNotFound;
import com.bank.pojo.User;
import com.bank.service.AuthService;

public class DeleteUserMenu implements Menu {

	private Menu nextMenu;
	private Scanner scan;
	private AuthService authService;
	Logger log = Logger.getRootLogger();
	private Menu loginMenu;

	public DeleteUserMenu() {

	}

	@Override
	public Menu advance() {
		// TODO Auto-generated method stub
		return nextMenu;
	}

	@Override
	public void displayOptions() {
		User user = new User();
		System.out.println("Please enter your credentails to delete your account");
		System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		System.out.println("Please enter your username:");
		String username = scan.nextLine();
		System.out.println("Please enter your password:");
		String password = scan.nextLine();

		user.setUsername(username);
		user.setPassword(password);
		try {
			authService.removeUser(user);
			log.trace("DeleteUserMenu  - User has been deleted");
			nextMenu = loginMenu;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Menu previousMenu() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Scanner getScanner() {
		// TODO Auto-generated method stub
		return this.scan;
	}

	@Override
	public void setScanner(Scanner scan) {
		this.scan = scan;
	}

	public AuthService getAuthService() {
		return authService;
	}

	public void setAuthService(AuthService authService) {
		this.authService = authService;
	}
	public DeleteUserMenu(AuthService authService) {
		super();
		this.authService=authService;
	}
	public DeleteUserMenu(Menu loginMenu,AuthService authService) {
		super();
		this.loginMenu = loginMenu;
		this.authService=authService;
	}

}
