package com.valtech.spring.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.spring.boot.Repository.AuthorRepository;
import com.valtech.spring.boot.entity.Author;


@Service
@Transactional(propagation=Propagation.SUPPORTS)
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorRepository authorRepository;


	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Author saveAuthor(Author author){
		return authorRepository.save(author);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Author updateAuthor(Author author){
		return authorRepository.save(author);
	}

	@Override
	public Author getAuthor(int id){
		return authorRepository.getReferenceById(id);
	}

	@Override
	public List<Author> getAllAuthors(){
		return authorRepository.findAll();
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void deleteAuthor(int id) {
		authorRepository.deleteById(id);
    }
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void deleteAllAuthors() {
		authorRepository.deleteAll();
    }

}

