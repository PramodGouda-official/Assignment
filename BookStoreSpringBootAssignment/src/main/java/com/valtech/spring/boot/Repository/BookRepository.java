package com.valtech.spring.boot.Repository;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.spring.boot.entity.Book;
import com.valtech.spring.boot.entity.Publisher;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{
	List<Book> findByName(String name);
	List<Book> findBywhenPublished(Date whenPublished);
	List<Book> findByNameAndWhenPublished(String name,Date whenPublished);
	List<Book> findByPublisher(Publisher publisher);
	
	public boolean existsByName(String name);
}
