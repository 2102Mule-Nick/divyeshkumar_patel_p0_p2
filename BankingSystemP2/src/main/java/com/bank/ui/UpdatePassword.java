package com.bank.ui;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.bank.pojo.User;
import com.bank.service.AuthService;
import com.esotericsoftware.minlog.Log;

public class UpdatePassword implements Menu {

	private Menu nextMenu;
	private Scanner scan;
	private AuthService authService;
	Logger log = Logger.getRootLogger();
	
	public UpdatePassword() {
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
		System.out.println("\n Update password");
		System.out.println("=-=-=-=-=-=-=-=-=-=-");
		System.out.println("Enter username:");
		String username= scan.nextLine();
		System.out.println("Enter your old password");
		String old_password = scan.nextLine();
		System.out.println("Enter new password");
		String new_password = scan.nextLine();
		
		user.setUsername(username);
		user.setPassword(old_password);
		try {
			authService.updateUser(user, new_password);
			Log.trace("UpdateMenu - UserPassword updated");
		}catch(Exception e) {
			e.printStackTrace();
			log.trace("UpdateMenu - Couldn't update the password");
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
		return null;
	}

	@Override
	public void setScanner(Scanner scan) {
		// TODO Auto-generated method stub

	}

}
