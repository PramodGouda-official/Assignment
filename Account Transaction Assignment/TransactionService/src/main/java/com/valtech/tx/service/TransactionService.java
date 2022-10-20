package com.valtech.tx.service;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.tx.entity.ChequeTransaction;
import com.valtech.tx.entity.Transaction;
import com.valtech.tx.entity.TransferTransaction;
import com.valtech.tx.entity.WithdrawTransaction;

public interface TransactionService {

	Transaction createNewChequeTransaction(ChequeTransaction ctx);

	Transaction createNewWithdrawalTransaction(WithdrawTransaction wtx);

	Transaction createNewTransferTransaction(TransferTransaction ttx);

	Transaction getTransaction(long id);

	List<Transaction> getAllTransactions();

}