package com.valtech.spring.boot.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="Author")
public class Author {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private long phoneNum;
	@OneToOne(targetEntity=Address.class,cascade={CascadeType.MERGE, CascadeType.PERSIST},mappedBy="author")
	private Address address;
	@ManyToMany(targetEntity=Book.class,cascade={CascadeType.MERGE, CascadeType.PERSIST},mappedBy="authors")
	private Set<Book> books;
	public Author() {}

	public Author(String name, long phoneNum) {
		super();
		this.name = name;
		this.phoneNum = phoneNum;
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

	public long getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(long phoneNum) {
		this.phoneNum = phoneNum;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}
	

	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", phoneNum=" + phoneNum + ", address=" + address + ", books="
				+ books + "]";
	}

}
