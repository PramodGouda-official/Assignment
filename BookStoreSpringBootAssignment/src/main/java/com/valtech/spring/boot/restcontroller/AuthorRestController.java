package com.valtech.spring.boot.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.valtech.spring.boot.entity.Address;
import com.valtech.spring.boot.entity.Author;
import com.valtech.spring.boot.service.AddressService;
import com.valtech.spring.boot.service.AuthorService;


@RestController
public class AuthorRestController {
	@Autowired
	private AuthorService authorService;
	@Autowired
	private AddressService addressService;

	@PostMapping("/api/author")
	public Author save(@RequestBody Author author){
		ModelAndView view=new ModelAndView("authors/list");
		return author;
	}

	@GetMapping("/api/authors")
	public List<Author> getCars(){
		return authorService.getAllAuthors();
	}

	@GetMapping("/api/authors/{id}")
	public Author getAuthor(@PathVariable("id") int id){
		Author author=authorService.getAuthor(id);

		return author;
	}

	@PutMapping("/api/authors/{id}")
	public Author updateAuthor(@PathVariable("id")int id, @RequestBody Author author){
		author.setId(id);
		return authorService.updateAuthor(author);
	}
}
