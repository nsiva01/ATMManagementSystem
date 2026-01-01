package com.sk.dao;

import com.sk.model.Account;

public interface IAccountDAO {

	public boolean validateUser(long accNo,int pin);
	public Account getAccount(long accNo);
	public boolean updateAccount(long accNo,double balance);
}
