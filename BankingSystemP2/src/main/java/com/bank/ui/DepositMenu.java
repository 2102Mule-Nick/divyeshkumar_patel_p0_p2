package com.bank.ui;

import java.util.Scanner;

public class DepositMenu implements Menu {
	private Scanner scan;
	private Menu nextMenu;

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

}
