package com.bank.ui;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.bank.exception.InvalidPassword;
import com.bank.exception.UserNotFound;
import com.bank.pojo.User;
import com.bank.service.AuthService;

public class LoginMenu implements Menu{
	
	private Logger loginLog = Logger.getRootLogger();
	private AuthService authService;
	private Scanner scan;
	private Menu nextMenu;
	private Menu accountMenu;

	public LoginMenu() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Menu advance() {
		// TODO Auto-generated method stub
		return nextMenu;
	}

	@Override
	public void displayOptions() {
		System.out.println("\n Enter your credentials to proceed");
		System.out.println("=====================================");
		
		System.out.println("Please enter your username:");
		String username= scan.nextLine();
		
		System.out.println("Please enter your password:");
		String password = scan.nextLine();
		
		User user = new User(username, password);
		try {
			authService.authenticateUser(user);
			loginLog.info("User has logged in");
			System.out.println("-=-=-=-=-=-=-=-=-=-=");
			nextMenu = accountMenu;
			
		} catch (InvalidPassword e) {
			// TODO Auto-generated catch block
			System.out.println("Incorrect Password - Please try again");
			nextMenu = this;
		} catch (UserNotFound e) {
			// TODO Auto-generated catch block
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
		// TODO Auto-generated method stub
		this.scan= scan;

		
	}
	public LoginMenu(AuthService authService) {
		super();
		this.authService = authService;
		
	}

	public LoginMenu(AuthService authService, Menu accountMenu) {
		super();
		this.authService = authService;		
		this.accountMenu = accountMenu;
		
	}

}
