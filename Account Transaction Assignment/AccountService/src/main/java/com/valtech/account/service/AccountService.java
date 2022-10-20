package com.valtech.account.service;

import java.util.List;

import com.valtech.account.entity.Account;

public interface AccountService {

	Account createSavingsAccount(double bal);

	Account createCurrentAccount(double bal);

	Account updateAccount(Account acc);

	Account getAccount(long id);

	List<Account> getAllAccounts();

}