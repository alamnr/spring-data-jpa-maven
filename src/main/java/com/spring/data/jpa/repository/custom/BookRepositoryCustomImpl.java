package com.spring.data.jpa.repository.custom;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.spring.data.jpa.model.Book;


public class BookRepositoryCustomImpl implements BookRepositoryCustom{
	
	private static Logger logger = LoggerFactory.getLogger(BookRepositoryCustomImpl.class);

	@Autowired
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public void saveAndLog(Book book) {
		logger.debug("Saving the book entity" + book.toString());
		entityManager.persist(book);
		
	}

}
