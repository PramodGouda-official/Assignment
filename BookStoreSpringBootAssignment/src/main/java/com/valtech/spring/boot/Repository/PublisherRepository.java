package com.valtech.spring.boot.Repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.spring.boot.entity.Publisher;


@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Integer>{
	List<Publisher> findByName(String name);
	List<Publisher> findByAddress(String address);
	List<Publisher> findByPhoneNum(long phoneNum);
	List<Publisher> findByNameAndPhoneNum(String name,long phoneNum);
	List<Publisher> findByNameAndAddress(String name, String address);
	
	public boolean existsByName(String name);
}

