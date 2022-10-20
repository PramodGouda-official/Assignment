package com.valtech.spring.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.valtech.spring.boot.service.BookService;

@Controller()
public class BookController {

	@Autowired
	private BookService bookService;
	
	@GetMapping("/books/list")
	public String list(Model model) {
		System.out.println("List of Books in BookStore");
		model.addAttribute("books",bookService.getAllBooks());
		return "books/list";
	}
	
}
