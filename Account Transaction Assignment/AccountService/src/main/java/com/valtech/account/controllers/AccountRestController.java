package com.valtech.account.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.account.entity.Account;
import com.valtech.account.service.AccountService;

@RestController
public class AccountRestController {


	@Autowired
	private AccountService accountService;

	@PostMapping("/api/accounts/SB")
	public Account createSavingsAcc(@RequestParam("balance") double bal){
		return accountService.createSavingsAccount(bal);
	}

	@PostMapping("/api/accounts/CA")
	public Account createCurrentAcc(@RequestParam("balance") double bal){
		return accountService.createCurrentAccount(bal);
	}

	@GetMapping("/api/accounts")
	public List<Account> getAllAccounts(){
		return accountService.getAllAccounts();
	}

	@GetMapping("/api/accounts/{id}")
	public Account getAccount(@PathVariable("id")int id){
		return accountService.getAccount(id);
	}
	
	@PutMapping("/api/accounts/{id}")
	public Account updateAccount(@RequestBody Account acc, @PathVariable("id")int id){
		return accountService.updateAccount(acc);
	}
}
