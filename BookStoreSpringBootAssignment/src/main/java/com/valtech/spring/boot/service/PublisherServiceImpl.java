package com.valtech.spring.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.spring.boot.Repository.PublisherRepository;
import com.valtech.spring.boot.entity.Publisher;

@Service
@Transactional(propagation=Propagation.SUPPORTS)
public class PublisherServiceImpl implements PublisherService {

	@Autowired
	private PublisherRepository publisherRepository;

	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Publisher savePublisher(Publisher publisher){
		return publisherRepository.save(publisher);
	}

	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Publisher updatePublisher(Publisher publisher){
		return publisherRepository.save(publisher);
	}

	
	@Override
	public Publisher getPublisher(int id){
		return publisherRepository.getReferenceById(id);
	}

	
	@Override
	public List<Publisher> getAllPublishers(){
		return publisherRepository.findAll();
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void deletePublisher(int id) {
		publisherRepository.deleteById(id);
    }

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void deleteAllPublishers() {
		publisherRepository.deleteAll();
    }

}

