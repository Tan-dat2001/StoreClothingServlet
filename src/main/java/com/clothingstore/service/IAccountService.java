package com.clothingstore.service;

import java.util.List;

import com.clothingstore.model.Account;

public interface IAccountService {
	List<Account> getAllAccount();

	Account getAccountById(int accountId);

	Account getAccountByEmail(String email);

	List<Account> getAllAccountByStatus(String isActive);

	void createAccount(Account account);

	void updateAccount(Account account);

	void deleteAccount(int accountId);

	boolean checkLogin(String username, String password);
	
	Account findByEmailAndPasswordAndStatus(String email, String password, String status);

}
