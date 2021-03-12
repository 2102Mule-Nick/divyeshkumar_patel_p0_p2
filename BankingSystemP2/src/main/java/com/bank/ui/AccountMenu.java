package com.bank.ui;

import java.util.Scanner;

public class AccountMenu implements Menu {
	private Scanner scan;
	private Menu nextMenu;
	private Menu loginMenu;
	private Menu withdrawMenu;
	private Menu depositMenu;
	private Menu accountSummaryMenu;
	private Menu updateMenu;
	private Menu deleteUserMenu;

	public AccountMenu() {
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
		// TODO Auto-generated method stub

		System.out.println("\nWelcome");
		System.out.println("1. Account Summary");
		System.out.println("2. Deposit Money");
		System.out.println("3. Withdraw Money");
		System.out.println("4. Update Password");
		System.out.println("5. Delete account");
		System.out.println("6. Log out");
		System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		System.out.println("Please enter a choice");
		String answer = scan.nextLine();
		if ("1".equals(answer)) {
			nextMenu = accountSummaryMenu;
		} else if ("2".equals(answer)) {
			nextMenu = depositMenu;
		} else if ("3".equals(answer)) {
			nextMenu = withdrawMenu;
		} else if ("4".equals(answer)) {
			nextMenu = updateMenu;
		}else if("5".equals(answer)) {
			nextMenu = deleteUserMenu;
		}else if("6".equals(answer)) {
			nextMenu = loginMenu;
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

	public AccountMenu(Menu depositMenu) {
		super();
		this.depositMenu = depositMenu;
	}

	public AccountMenu(Menu depositMenu, Menu accountSummaryMenu, Menu withdrawMenu,Menu updateMenu,Menu deleteUserMenu) {
		super();
		this.depositMenu = depositMenu;
		this.accountSummaryMenu = accountSummaryMenu;
		this.withdrawMenu = withdrawMenu;
		this.updateMenu = updateMenu;
		this.deleteUserMenu =deleteUserMenu;
	}

	public AccountMenu(Menu loginMenu, Menu withdrawMenu, Menu depositMenu, Menu acccountSummaryMenu,Menu updateMenu,Menu deleteUserMenu) {
		super();
		this.loginMenu = loginMenu;
		this.withdrawMenu = withdrawMenu;
		this.depositMenu = depositMenu;
		this.accountSummaryMenu = acccountSummaryMenu;
		this.updateMenu=updateMenu;
		this.deleteUserMenu=deleteUserMenu;
	}

}
