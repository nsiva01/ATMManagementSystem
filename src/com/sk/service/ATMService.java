package com.sk.service;

import com.sk.dao.AccountDAO;
import com.sk.model.Account;

public class ATMService implements IATMService {

	AccountDAO dao=new AccountDAO();
	@Override
	public Account getLogin(long accNO, int pin) {
      if(dao.validateUser(accNO, pin)) {
    	  return dao.getAccount(accNO);
      }

		return null;
	}
	@Override
	public boolean deposit(Account acc, double amount) {
		acc.setBalance(acc.getBalance()+amount);
		return dao.updateAccount(acc.getAccNo(), acc.getBalance());
	}
	@Override
	public boolean withdraw(Account acc, double amount) {
		if(amount>acc.getBalance()) return false;
		acc.setBalance(acc.getBalance()-amount);
		return dao.updateAccount(acc.getAccNo(),acc.getBalance());
	}

}
