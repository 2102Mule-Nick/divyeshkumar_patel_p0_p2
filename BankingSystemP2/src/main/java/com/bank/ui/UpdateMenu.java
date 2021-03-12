package com.bank.ui;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.bank.exception.InvalidPassword;
import com.bank.exception.UserNotFound;
import com.bank.pojo.User;
import com.bank.service.AuthService;

public class UpdateMenu implements Menu {
	private Menu nextMenu;
	private Scanner scan;
	private Menu loginMenu;
	private AuthService authService;
	Logger log = Logger.getRootLogger();

	public Menu getLoginMenu() {
		return loginMenu;
	}

	public void setLoginMenu(Menu loginMenu) {
		this.loginMenu = loginMenu;
	}

	public AuthService getAuthService() {
		return authService;
	}

	public void setAuthService(AuthService authService) {
		this.authService = authService;
	}

	public UpdateMenu() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Menu advance() {
		// TODO Auto-generated method stub
		return nextMenu;
	}

	@Override
	public void displayOptions() {
		User user = new User();
		System.out.println("Welcome to the update menu");
		System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		System.out.println("Please enter your username:");
		String username = scan.nextLine();
		System.out.println("Please enter your password:");
		String old_password = scan.nextLine();
		System.out.println("Enter new password:");
		String new_password = scan.nextLine();

		user.setUsername(username);
		user.setPassword(old_password);
		try {
			authService.updateUser(user, new_password);
			log.trace("UpdateMenu - UserPassword has been updated");
			nextMenu = loginMenu;
		} catch (UserNotFound e) {

		} catch (InvalidPassword e) {

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
		// TODO Auto-generated method stub
		this.scan = scan;
	}

	public UpdateMenu(Menu loginMenu, AuthService authService) {
		super();
		this.loginMenu = loginMenu;
		this.authService = authService;
	}

	public UpdateMenu(AuthService authService) {
		super();
		this.authService = authService;
	}

}
