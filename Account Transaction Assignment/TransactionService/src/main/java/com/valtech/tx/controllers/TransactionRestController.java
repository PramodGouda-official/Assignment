package com.valtech.tx.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.tx.entity.ChequeTransaction;
import com.valtech.tx.entity.Transaction;
import com.valtech.tx.entity.TransferTransaction;
import com.valtech.tx.entity.WithdrawTransaction;
import com.valtech.tx.service.TransactionService;

@RestController
public class TransactionRestController {
	
	@Autowired
	private TransactionService transactionService;

	@PostMapping("/api/transactions/ctx")
	public Transaction createChequeTx(@RequestBody ChequeTransaction ctx){
		return transactionService.createNewChequeTransaction(ctx);
	}

	@PostMapping("/api/transactions/wtx")
	public Transaction createWithdrawalTx(@RequestBody WithdrawTransaction wtx){
		return transactionService.createNewWithdrawalTransaction(wtx);
	}
	
	@PostMapping("/api/transactions/ttx")
	public Transaction createTransferTx(@RequestBody TransferTransaction ttx){
		return transactionService.createNewTransferTransaction(ttx);
	}


	@GetMapping("/api/transactions")
	public List<Transaction> getAllTransactions(){
		return transactionService.getAllTransactions();
	}

	@GetMapping("/api/transactions/{id}")
	public Transaction getTransaction(@PathVariable("id")int id){
		return transactionService.getTransaction(id);
	}
}
