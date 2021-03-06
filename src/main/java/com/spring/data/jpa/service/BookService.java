package com.spring.data.jpa.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.data.jpa.model.Book;
import com.spring.data.jpa.repository.BookRepository;

@Service
public class BookService {

	private final BookRepository repository;

	@Autowired
	public BookService(final BookRepository repository) {
		super();
		this.repository = repository;
	}

	public void saveBook(Book book) {
		repository.save(book);
	}

	public List<Book> findAll() {
		return repository.findAll();
	}

	@Transactional
	public Book updateTitleOfBook(Long id) {

		Book book = repository.getOne(1L);
		book.setTitle("Vogi Chogi Auditing");
		return repository.save(book);

	}

}
