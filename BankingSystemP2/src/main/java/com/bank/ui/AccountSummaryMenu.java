package com.bank.ui;

import java.util.Scanner;

import com.bank.pojo.AccountInfo;
import com.bank.service.AccountService;

public class AccountSummaryMenu implements Menu {
	private Menu nextMenu;
	private Scanner scan;
	private AccountService accountService;
	private Menu accountMenu;
	

	public AccountSummaryMenu() {
		super();
	}

	@Override
	public Menu advance() {
		// TODO Auto-generated method stub
		return nextMenu;
	}

	@Override
	public void displayOptions() {

		AccountInfo info = new AccountInfo();
		System.out.println("\nWelcome to your account Summary");
		System.out.println("-=-=-=-==-=-=-=--=-=-=-=");
		System.out.println("Enter your username:");
		String username = scan.nextLine();
		info.setUsername(username);
		try {
			accountService.getSummary(info);
			nextMenu = accountMenu;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Couldn't get AccountSummary");
		}

	}

	public AccountService getAccountService() {
		return accountService;
	}

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
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

	public Menu getAccountMenu() {
		return accountMenu;
	}

	public void setAccountMenu(Menu accountMenu) {
		this.accountMenu = accountMenu;
	}
	public AccountSummaryMenu(Menu accountMenu) {
		super();
		this.accountMenu= accountMenu;
	}

	public AccountSummaryMenu(AccountService accountService, Menu accountMenu) {
		super();
		this.accountService = accountService;
		this.accountMenu = accountMenu;
	}

}
