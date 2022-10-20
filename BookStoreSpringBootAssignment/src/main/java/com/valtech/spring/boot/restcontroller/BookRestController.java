package com.valtech.spring.boot.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.spring.boot.entity.Book;
import com.valtech.spring.boot.service.BookService;

@RestController
public class BookRestController {
	
	@Autowired
	 private BookService bookService;
		
		@PostMapping("/api/book")
		public Book save(@RequestBody Book book){
			return bookService.saveBook(book);
		}
		
		@GetMapping("/api/book")
		public List<Book> getPublisher(){
			return bookService.getAllBooks();
		}
	 
		@GetMapping("/api/book/{id}")
	 public Book getPublisher(@PathVariable("id") int id){
			Book book=bookService.getBook(id);
			return book;

	 }
		
		@PutMapping("/api/book/{id}")
	    public Book updateBook(@PathVariable("id")int id, @RequestBody Book book){
  
			
	        return bookService.updateBook(book);
	    }

}
