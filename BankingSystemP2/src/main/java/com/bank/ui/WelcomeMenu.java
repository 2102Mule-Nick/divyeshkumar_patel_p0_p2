package com.bank.ui;

import java.util.Scanner;

public class WelcomeMenu implements Menu {

	private Scanner scan;
	private Menu loginMenu;
	private Menu registrationMenu;
	private Menu nextMenu;
	private Menu accountMenu;
	private Menu depositMenu;
	private Menu accountSummaryMenu;

	public WelcomeMenu() {
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	public Menu advance() {
		// TODO Auto-generated method stub
		return nextMenu;
	}

	@Override
	public void displayOptions() {
		System.out.println("Welcome to our Bank");
		System.out.println("1. Register for an account ");
		System.out.println("2. Login to your account");
		System.out.println("Please select an option");
		System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		
		String answer = scan.nextLine();

		if("1".equals(answer)) {
			nextMenu = registrationMenu;
		}else if("2".equals(answer)) {
			nextMenu = loginMenu;
		}else {
			System.out.println("Invalid Input");
			nextMenu =this;
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
	public WelcomeMenu(Menu loginMenu,Menu registrationMenu,Menu depositMenu,Menu accountMenu,Menu accountSummaryMenu) {
		super();
		this.loginMenu= loginMenu;
		this.registrationMenu = registrationMenu;
		this.depositMenu = depositMenu;
		this.accountMenu = accountMenu;
		this.accountSummaryMenu = accountSummaryMenu;
		
	}

}
