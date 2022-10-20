package com.valtech.account.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.account.entity.Customer;
import com.valtech.account.service.CustomerService;

@RestController
public class CustomerRestController {

	@Autowired
	private CustomerService customerService;

	@PostMapping("/api/customers")
	public Customer createCustomer(@RequestBody Customer c){
		return customerService.createCustomer(c);
	}


	@GetMapping("/api/customers")
	public List<Customer> getAllCustomers(){
		return customerService.getAllCustomers();
	}

	@GetMapping("/api/customers/{id}")
	public Customer getCustomer(@PathVariable("id")int id){
		return customerService.getCustomer(id);
	}
	
	@PutMapping("/api/customers/{id}")
	public Customer updateCustomer(@RequestBody Customer c, @PathVariable("id")int id){
		return customerService.updateCustomer(c);
	}
}
