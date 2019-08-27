package com.bitcamp.servicesImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;


import com.bitcamp.domains.AccountBean;
import com.bitcamp.services.AccountService;

public class AccountServiceImpl implements AccountService{
	private AccountBean[] accounts; 
	private AccountBean account;
	private int count;
	
	public AccountServiceImpl() {
		accounts = new AccountBean[10];
		count = 0;
	}
	@Override
	 
	public void createAccount(int money) {
		account = new AccountBean();
		account.setAccountNum(createAccountNum());
		account.setMoney(money+"");
		account.setToday(findDate());
		accounts[count]= account;
		count++;
		}

	@Override
	public String createAccountNum() {
		Random random = new Random();
		int first = 0;
		first = random.nextInt(9999);
		int twice = 0;
		twice = random.nextInt(9999);
		return String.format("%4d-%4d",first,twice);
	}

	@Override
	public AccountBean[] findAll() {
		return accounts;
	}

	@Override
	public AccountBean findByAccountNum(String accountNum) {
		account = new AccountBean();
		for(int i = 0; i<count; i++) {
			if(accountNum.equals(account.getAccountNum())) {
				account = this.accounts[i];
				break;
			}
		}
		return account;
	}

	@Override
	public int countAccounts() {
		return count;
	}

	@Override
	public boolean existAccountNum(String accountNum) {
		boolean flag = true;
		for(int i = 0; i<count; i++) {
			if(accountNum.equals(accounts[i].getAccountNum())) {
				flag = false;
				break;
			}
		}
		return flag;
	}

	@Override
	public String findDate() {
		return new SimpleDateFormat("yyyy-MM-dd hh:mm").format(new Date());
	}

	@Override
	public void depositMoney(AccountBean param) {
		double deposit = Double.parseDouble(account.getMoney()) + Double.parseDouble(param.getMoney());
		account.setMoney(String.valueOf(deposit));
		System.out.println(deposit);
	}

	@Override
	public void withdrawMoney(AccountBean param) {
		System.out.println(Double.parseDouble(account.getMoney()));
		double deposit = Double.parseDouble(account.getMoney()) - Double.parseDouble(param.getMoney());
		account.setMoney(String.valueOf(deposit));		
		System.out.println(deposit);
	}

	@Override
	public void deleteAccountNum(String accountNum) {
		for(int i =0; i<count; i++){
			if(accountNum.equals(accounts[i].getAccountNum())) {
				accounts[i] = accounts[count-1];
				count--;
				break;
			}
		}
		
	}

}
