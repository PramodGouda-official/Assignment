package com.valtech.spring.boot.service;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.spring.boot.entity.Author;

public interface AuthorService {

	Author saveAuthor(Author author);

	Author updateAuthor(Author author);

	Author getAuthor(int id);

	List<Author> getAllAuthors();

	void deleteAuthor(int id);

	void deleteAllAuthors();

}