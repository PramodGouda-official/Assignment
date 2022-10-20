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

import com.valtech.spring.boot.entity.Author;
import com.valtech.spring.boot.service.AuthorService;

@Controller()
public class AuthorController {

	@Autowired
	private AuthorService authorService;
	
	@GetMapping("/authors/list")
	public String list(Model model) {
		System.out.println("List of Authors of Books");
		model.addAttribute("authors",authorService.getAllAuthors());
		return "authors/list";
	}
	
	@GetMapping("/authors/newAuthor")
	public String newAuthor(){
		return "authors/newAuthor";
	}
	
	@PostMapping("/authors/newAuthor")
	public ModelAndView saveNewAuthor(@ModelAttribute Author author, @RequestParam("submit")String submit){
		ModelAndView mnv = new ModelAndView("/authors/list");
		if(submit.equals("Cancel")){
			mnv.getModel().put("authors", authorService.getAllAuthors());
			return mnv;
		}
		authorService.saveAuthor(author);
		mnv.getModel().put("authors", authorService.getAllAuthors());
		return mnv;
	}
	
	@GetMapping("/authors/updateAuthor/{id}")
	public String updateAuthor(@PathVariable("id")int id, Model model){
		model.addAttribute("author", authorService.getAuthor(id));
		return "authors/updateAuthor";
	}
	
	@PostMapping("/authors/updateAuthor/{id}")
	public ModelAndView updateAuthor(@PathVariable("id")int id, @ModelAttribute Author author, @RequestParam("submit")String submit){
		ModelAndView view = new ModelAndView("/authors/list");
		if(submit.equals("Cancel")){
			view.addObject("authors", authorService.getAllAuthors());
			return view;
		}
		authorService.updateAuthor(author);
		view.addObject("authors", authorService.getAllAuthors());
		return view;
	}
}
