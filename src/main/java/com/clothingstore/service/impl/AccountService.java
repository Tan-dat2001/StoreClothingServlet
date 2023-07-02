package com.clothingstore.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.clothingstore.dao.IAccountDAO;
import com.clothingstore.model.Account;
import com.clothingstore.service.IAccountService;

public class AccountService implements IAccountService{
	
	@Inject
	private IAccountDAO accountDAO;
	
	@Override
	public List<Account> getAllAccount() {
		
		return accountDAO.getAllAccount();
	}

	@Override
	public Account getAccountById(int accountId) {
		return accountDAO.getAccountById(accountId);
	}

	@Override
	public Account getAccountByEmail(String email) {
		return accountDAO.getAccountByEmail(email);
	}

	@Override
	public List<Account> getAllAccountByStatus(String isActive) {
		return accountDAO.getAllAccountByStatus(isActive);
	}

	@Override
	public void createAccount(Account account) {
		accountDAO.createAccount(account);
	}

	@Override
	public void updateAccount(Account account) {
		accountDAO.updateAccount(account);
		
	}

	@Override
	public void deleteAccount(int accountId) {
		accountDAO.deleteAccount(accountId);
	}

	@Override
	public boolean checkLogin(String username, String password) {
		return accountDAO.checkLogin(username, password);
	}

}
