package com.valtech.tx.entity;

import java.time.LocalDateTime;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("WithdrawTx")
public class WithdrawTransaction extends Transaction{

	private String atmBranch;
	private int atmNo;
	
	public WithdrawTransaction() {}

	public WithdrawTransaction(float amount, boolean debit, LocalDateTime txTime, long accountId, String atmBranch, int atmNo) {
		super(amount, debit, txTime, accountId);
		this.atmBranch = atmBranch;
		this.atmNo = atmNo;
	}

	public String getAtmBranch() {
		return atmBranch;
	}
	public void setAtmBranch(String atmBranch) {
		this.atmBranch = atmBranch;
	}
	public int getAtmNo() {
		return atmNo;
	}
	public void setAtmNo(int atmNo) {
		this.atmNo = atmNo;
	}
	@Override
	public String toString() {
		return "WithdrawTransaction [atmBranch=" + atmBranch + ", atmNo=" + atmNo + "]";
	}	
}
