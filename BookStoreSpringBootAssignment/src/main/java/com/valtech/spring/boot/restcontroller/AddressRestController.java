package com.valtech.spring.boot.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.spring.boot.entity.Address;
import com.valtech.spring.boot.service.AddressService;

@RestController
public class AddressRestController {

	
	@Autowired
	 private AddressService addressService;
		
		@PostMapping("/api/address")
		public Address save(@RequestBody Address address){
			return addressService.saveAddress(address);
		}
		
		@GetMapping("/api/address")
		public List<Address> getAddress(){
			return addressService.getAllAddresses();
		}
	 
		@GetMapping("/api/address/{id}")
	 public Address getAddress(@PathVariable("id") int id){
			Address author=addressService.getAddress(id);
			return author;

	 }
		
		@PutMapping("/api/address/{id}")
	    public Address updateAddress(@PathVariable("id")int id, @RequestBody Address address){
			address.setId(id);
	        return addressService.updateAddress(address);
	    }
}
