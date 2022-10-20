package com.valtech.tx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.tx.entity.ChequeTransaction;
import com.valtech.tx.entity.Transaction;
import com.valtech.tx.entity.TransferTransaction;
import com.valtech.tx.entity.WithdrawTransaction;
import com.valtech.tx.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;
	

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Transaction createNewChequeTransaction(ChequeTransaction ctx ){
		return transactionRepository.save(ctx);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Transaction createNewWithdrawalTransaction(WithdrawTransaction wtx ){
		return transactionRepository.save(wtx);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Transaction createNewTransferTransaction(TransferTransaction ttx ){
		return transactionRepository.save(ttx);
	}	

	@Override
	public Transaction getTransaction(long id){
		return transactionRepository.findById(id).get();
	}

	@Override
	public List<Transaction> getAllTransactions(){
		return transactionRepository.findAll();
	}


}
