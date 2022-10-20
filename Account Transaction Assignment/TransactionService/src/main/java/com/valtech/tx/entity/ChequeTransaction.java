package com.valtech.tx.entity;

import java.time.LocalDateTime;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ChequeTx")
public class ChequeTransaction extends Transaction {

	private int chequeNo;
	private boolean outsation;
	private float collectionCharges;
	
	public ChequeTransaction() {}
			
	public ChequeTransaction(int id, float amount, boolean debit, LocalDateTime txTime, long accountId, int chequeNo, boolean outsation, float collectionCharges) {
		super(amount, debit, txTime, accountId);
		this.chequeNo = chequeNo;
		this.outsation = outsation;
		this.collectionCharges = collectionCharges;
	}

	public int getChequeNo() {
		return chequeNo;
	}
	public void setChequeNo(int chequeNo) {
		this.chequeNo = chequeNo;
	}
	public boolean isOutsation() {
		return outsation;
	}
	public void setOutsation(boolean outsation) {
		this.outsation = outsation;
	}
	public float getCollectionCharges() {
		return collectionCharges;
	}
	public void setCollectionCharges(float collectionCharges) {
		this.collectionCharges = collectionCharges;
	}
	@Override
	public String toString() {
		return "ChequeTransaction [chequeNo=" + chequeNo + ", outsation=" + outsation + ", collectionCharges="
				+ collectionCharges + "]";
	}
}
