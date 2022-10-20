package com.valtech.spring.boot.service;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.spring.boot.entity.Publisher;

public interface PublisherService {

	Publisher savePublisher(Publisher publisher);

	Publisher updatePublisher(Publisher publisher);

	Publisher getPublisher(int id);

	List<Publisher> getAllPublishers();

	void deletePublisher(int id);

	void deleteAllPublishers();

}