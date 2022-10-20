package com.valtech.spring.boot.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.spring.boot.entity.Address;
import com.valtech.spring.boot.entity.Author;


@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>{
	List<Address> findByStreet(String street);
	List<Address> findByCity(String city);
	List<Address> findByState(String state);
	List<Address> findByZipcode(int zipcode);
	List<Address> findByStreetAndCity(String street, String city);
	List<Address> findByCityAndState(String city, String state);
	List<Address> findByCityAndZipcode(String city, int zipcode);
	List<Address> findByStreetAndCityAndStateAndZipcode(String street, String city,String state,int zipcode);
	List<Address> findByAuthor(Author author);
}
