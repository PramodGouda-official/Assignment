package com.valtech.account.entity;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Account {
	
	public static final String SAVINGS = "SB";
	public static final String CURRENT = "CA";
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private double bal;
	private String accType;
	private LocalDateTime dateOfCreation;
	private LocalDateTime dateOfUpdation; // Date of Latest updated
	private boolean active;
	
	@ManyToMany(targetEntity=Customer.class,cascade={CascadeType.MERGE, CascadeType.PERSIST})
	@JoinTable(name="customer_acc", joinColumns=@JoinColumn(name="account_id",referencedColumnName="id"),
	inverseJoinColumns=@JoinColumn(name="customer_id",referencedColumnName="id"))
	private Set<Customer> customers;
	
	
	public Account(int id, double bal, String accType, LocalDateTime dateOfCreation, LocalDateTime dateOfUpdation,
			boolean active) {
		this.id = id;
		this.bal = bal;
		this.accType = accType;
		this.dateOfCreation = dateOfCreation;
		this.dateOfUpdation = dateOfUpdation;
		this.active = active;
	}
	
	public Account(String accType, double bal) {
		this.bal = bal;
		this.accType = accType;
		this.dateOfCreation = LocalDateTime.now();
		this.dateOfUpdation = LocalDateTime.now();
		this.active = false;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getBal() {
		return bal;
	}
	public void setBal(double bal) {
		this.bal = bal;
	}
	public String getAccType() {
		return accType;
	}
	public void setAccType(String accType) {
		this.accType = accType;
	}
	public LocalDateTime getDateOfCreation() {
		return dateOfCreation;
	}
	public void setDateOfCreation(LocalDateTime dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}
	public LocalDateTime getDateOfUpdation() {
		return dateOfUpdation;
	}
	public void setDateOfUpdation(LocalDateTime dateOfUpdation) {
		this.dateOfUpdation = dateOfUpdation;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	public Set<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}

	public static String getSavings() {
		return SAVINGS;
	}

	public static String getCurrent() {
		return CURRENT;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", bal=" + bal + ", accType=" + accType + ", dateOfCreation=" + dateOfCreation
				+ ", dateOfUpdation=" + dateOfUpdation + ", active=" + active + "]";
	}
}
