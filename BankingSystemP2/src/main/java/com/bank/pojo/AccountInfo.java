package com.bank.pojo;

public class AccountInfo {

	private String username;
	private double totalBalance;
	private String transactionRemarks;
	private String accountType;

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public double getTotalBalance() {
		return totalBalance;
	}

	public void setTotalBalance(double balance) {
		if (balance > 0.0) {
			this.totalBalance = balance;
		}
	}

	public String getTransactionRemarks() {
	return transactionRemarks;
	}

	
	public void setTransactionRemarks(String remarks) {
		this.transactionRemarks = remarks;
	}

	public AccountInfo() {
		super();
		//this("Test", 200000, "Total amount in bank");
	}

	public AccountInfo(String username, double balance,String remarks) {
		super();
		this.username = username;
		this.totalBalance = balance;
		this.transactionRemarks = remarks;

	}
	public String toString() {
		return "AccountInfo [username="+username +",Balance = "+totalBalance+"]"; 

}
}
