package com.sk.service;

import com.sk.model.Account;

public interface IATMService {

	public Account getLogin(long accNO,int pin);
	public boolean deposit(Account acc,double amount);
	public boolean withdraw(Account acc,double amount);
}
