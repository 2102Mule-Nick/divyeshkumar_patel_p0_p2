package com.bank.ui;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.bank.pojo.AccountInfo;
import com.bank.service.WithdrawService;

public class WithdrawMenu implements Menu {

	private Scanner scan;
	private Menu nextMenu;
	private WithdrawService withdrawService;
	private Menu loginMenu;
	Logger log = Logger.getRootLogger();

	public WithdrawMenu() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Menu advance() {
		// TODO Auto-generated method stub
		return nextMenu;
	}

	@Override
	public void displayOptions() {

		// Menu to withdraw money from Account
		AccountInfo info = new AccountInfo();
		System.out.println("\nWelcome to Withdraw Menu");
		System.out.println("-=-=-=-==-=-=-=--=-=-=-=");

		System.out.println("Enter your username:");
		info.setUsername(scan.nextLine());

		System.out.println("Enter the amount you want to withdraw");
		info.setTotalBalance(scan.nextDouble());

		try {
			withdrawService.withdrawAmt(info);
			nextMenu = loginMenu;
		} catch (Exception e) {
			log.trace("DepositMenu - couldn't deposit money");
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
		this.scan = scan;

	}

	public WithdrawService getWithdrawService() {
		return withdrawService;
	}

	public void setWithdrawService(WithdrawService withdrawService) {
		this.withdrawService = withdrawService;
	}
	
	public WithdrawMenu(WithdrawService withdrawService) {
		super();
		this.withdrawService= withdrawService;
	}
	public WithdrawMenu(Menu loginMenu,WithdrawService withdrawService) {
		super();
		this.loginMenu = loginMenu;
		this.withdrawService=withdrawService;
	}
	

}
