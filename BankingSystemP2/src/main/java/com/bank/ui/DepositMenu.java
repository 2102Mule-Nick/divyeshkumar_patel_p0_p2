package com.bank.ui;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.bank.pojo.AccountInfo;
import com.bank.service.DepositService;
import com.esotericsoftware.minlog.Log;

public class DepositMenu implements Menu {
	private Scanner scan;
	private Menu nextMenu;
	private DepositService depositService;
	Logger log= Logger.getRootLogger(); 
	private Menu loginMenu;

	public DepositMenu() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Menu advance() {
		// TODO Auto-generated method stub
		return nextMenu;
	}

	@Override
	public void displayOptions() {
		AccountInfo info = new AccountInfo();
		System.out.println("\nWelcome to Deposit Menu");
		System.out.println("-=-=-=-==-=-=-=--=-=-=-=");
		
		System.out.println("Enter your username:");
		info.setUsername(scan.nextLine());
		
		System.out.println("Enter the amount you want to deposit");
		info.setTotalBalance(scan.nextDouble());
		
		try {
			depositService.depositAmt(info);
			nextMenu = loginMenu;
		}catch(Exception e) {
			log.trace("DepositMenu - couldn't deposit money");
			e.printStackTrace();
		}

	}

	public Menu getNextMenu() {
		return nextMenu;
	}

	public void setNextMenu(Menu nextMenu) {
		this.nextMenu = nextMenu;
	}

	public DepositService getDepositService() {
		return depositService;
	}

	public void setDepositService(DepositService depositService) {
		this.depositService = depositService;
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
	public DepositMenu(DepositService depositService) {
		super();
		this.depositService = depositService;
	}

	public DepositMenu(Menu loginMenu, DepositService depositService) {
		super();
		this.loginMenu = loginMenu;
		this.depositService = depositService;
	}

}
