package com.valtech.spring.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.valtech.spring.boot.entity.Address;
import com.valtech.spring.boot.service.AddressService;


@Controller()
public class AddressController {

	@Autowired
	private AddressService addressService;
	
	@GetMapping("/addresses/list")
	public String list(Model model) {
		System.out.println("List of Addresses of Authors");
		model.addAttribute("addresses",addressService.getAllAddresses());
		return "addresses/list";
	}
	
	@GetMapping("/addresses/newAddress")
	public String newAddress(){
		return "addresses/newAddress";
	}
	
	@PostMapping("/addresses/newAddress")
	public ModelAndView saveNewAddress(@ModelAttribute Address address, @RequestParam("submit")String submit){
		ModelAndView mnv = new ModelAndView("/addresses/list");
		if(submit.equals("Cancel")){
			mnv.getModel().put("addresses", addressService.getAllAddresses());
			return mnv;
		}
		addressService.saveAddress(address);
		mnv.getModel().put("addresses", addressService.getAllAddresses());
		return mnv;
	}
	
	@GetMapping("/addresses/updateAddress/{id}")
	public String updateAddress(@PathVariable("id")int id, Model model){
		model.addAttribute("address", addressService.getAddress(id));
		return "addresses/updateAddress";
	}
	
	@PostMapping("/addresses/updateAddress/{id}")
	public ModelAndView updateAddress(@PathVariable("id")int id, @ModelAttribute Address address, @RequestParam("submit")String submit){
		ModelAndView view = new ModelAndView("/addresses/list");
		if(submit.equals("Cancel")){
			view.addObject("addresses", addressService.getAllAddresses());
			return view;
		}
		addressService.updateAddress(address);
		view.addObject("addresses", addressService.getAllAddresses());
		return view;
	}
}
