package com.valtech.tx.entity;

import java.time.LocalDateTime;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("TransferTx")
public class TransferTransaction extends Transaction {

	private long fromAcc;
	private long toAcc;
	
	public TransferTransaction() {}

	
	public TransferTransaction(float amount, boolean debit, LocalDateTime txTime, long accountId, long fromAcc, long toAcc) {
		super(amount, debit, txTime, accountId);
		this.fromAcc = fromAcc;
		this.toAcc = toAcc;
	}
	public long getFromAcc() {
		return fromAcc;
	}
	public void setFromAcc(long fromAcc) {
		this.fromAcc = fromAcc;
	}
	public long getToAcc() {
		return toAcc;
	}
	public void setToAcc(long toAcc) {
		this.toAcc = toAcc;
	}
	@Override
	public String toString() {
		return "TransferTransaction [fromAcc=" + fromAcc + ", toAcc=" + toAcc + "]";
	}
}
