package com.spring.data.jpa.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.data.jpa.model.Book;
import com.spring.data.jpa.repository.BookRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private BookRepository repository;
	
	
	@Test
	public void findByTitle()
	{
		entityManager.persist(new Book("Java"));
		
		List<Book>  books = repository.findByTittle("Java");
		
		assertEquals(1, books.size());
		
		assertThat(books).extracting(Book::getTitle).containsOnly("Java");
	}
	
	

}
