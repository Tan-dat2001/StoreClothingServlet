package com.clothingstore.dao;

import java.util.List;

import com.clothingstore.model.Account;

public interface IAccountDAO {
	List<Account> getAllAccount();
	
	Account getAccountById(int accountId);
	
	Account getAccountByEmail(String email);
	
	List<Account> getAllAccountByStatus(String isActive);
	
	void createAccount(Account account);
	
	void updateAccount(Account account);
	
	void deleteAccount(int accountId);
}
