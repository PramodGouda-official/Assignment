package com.valtech.spring.boot.Repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.spring.boot.entity.Address;
import com.valtech.spring.boot.entity.Author;


@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer>{
	List<Author> findByName(String name);
	List<Author> findByPhoneNum(long phoneNum);
	List<Author> findByAddress(Address address);
	List<Author> findByNameAndPhoneNum(String name,long phoneNum);
	List<Author> findByNameAndAddress(String name, Address address);
	
	public boolean existsByName(String name);
}

