package com.valtech.spring.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.spring.boot.Repository.AddressRepository;
import com.valtech.spring.boot.entity.Address;

@Service
@Transactional(propagation=Propagation.SUPPORTS)
public class AddressServiceImpl implements AddressService {

	@Autowired
	private  AddressRepository addressRepository;


	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Address saveAddress(Address address){
		return addressRepository.save(address);
	}

	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Address updateAddress(Address address){
		return addressRepository.save(address);
	}

	
	@Override
	public Address getAddress(int id){
		return addressRepository.getReferenceById(id);
	}

	
	@Override
	public List<Address> getAllAddresses(){
		return addressRepository.findAll();
	}
	
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void deleteAddress(int id) {
		addressRepository.deleteById(id);
    }

	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void deleteAllAddresses() {
		addressRepository.deleteAll();
    }

}
