package com.valtech.spring.boot.service;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.spring.boot.entity.Address;

public interface AddressService {

	Address saveAddress(Address address);

	Address updateAddress(Address address);

	Address getAddress(int id);

	List<Address> getAllAddresses();

	void deleteAddress(int id);

	void deleteAllAddresses();

}