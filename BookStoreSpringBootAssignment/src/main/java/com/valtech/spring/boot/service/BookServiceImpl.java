package com.valtech.spring.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.spring.boot.Repository.BookRepository;
import com.valtech.spring.boot.entity.Book;

@Service
@Transactional(propagation=Propagation.SUPPORTS)
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Book saveBook(Book book){
		return bookRepository.save(book);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Book updateBook(Book book){
		return bookRepository.save(book);
	}

	@Override
	public Book getBook(int id){
		return bookRepository.getReferenceById(id);
	}

	@Override
	public List<Book> getAllBooks(){
		return bookRepository.findAll();
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void deleteBook(int id) {
		bookRepository.deleteById(id);
    }

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void deleteAllBooks() {
		bookRepository.deleteAll();
    }

}
