package com.valtech.account.entity;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private long mobile;
	private LocalDate dob;
	private String address;
	private String custType;
	private int pincode;
	@ManyToMany(targetEntity=Account.class,cascade={CascadeType.MERGE, CascadeType.PERSIST},mappedBy="customers")
	private Set<Account> accounts;
	
	public Customer() {}
	
	public Customer(int id, String name, String email, long mobile, LocalDate dob, String address, String custType,
			int pincode) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.dob = dob;
		this.address = address;
		this.custType = custType;
		this.pincode = pincode;
	}
	
	public Customer(String name, String email, long mobile, LocalDate dob, String address, String custType,
			int pincode) {
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.dob = dob;
		this.address = address;
		this.custType = custType;
		this.pincode = pincode;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCustType() {
		return custType;
	}
	public void setCustType(String custType) {
		this.custType = custType;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public Set<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", mobile=" + mobile + ", dob=" + dob
				+ ", address=" + address + ", custType=" + custType + ", pincode=" + pincode + "]";
	}	
}
