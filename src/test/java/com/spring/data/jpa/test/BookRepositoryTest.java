package com.spring.data.jpa.test;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;


import com.spring.data.jpa.Application;
import com.spring.data.jpa.config.DataConfig;
import com.spring.data.jpa.config.PersistenceContext;
import com.spring.data.jpa.model.Book;
import com.spring.data.jpa.repository.BookRepository;

@RunWith(SpringRunner.class)
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = { DataConfig.class},loader = AnnotationConfigContextLoader.class )
@ContextConfiguration(classes = { PersistenceContext.class} )
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
    DirtiesContextTestExecutionListener.class,
    TransactionalTestExecutionListener.class/*,
    DbUnitTestExecutionListener.class*/ })
public class BookRepositoryTest {
	
	@Autowired
	private BookRepository repository;
	
	
	
	@Test
	public void findByTitle() throws Exception
	{
		
		
		repository.save(new Book("Java"));
		
		List<Book>  books = repository.findByTitle("Java");
		
		//List<Book>  books = repository.findAll();
		
		assertEquals(1, books.size());
		
		assertThat(books).extracting(Book::getTitle).containsOnly("Java");
	}
	
	

}
