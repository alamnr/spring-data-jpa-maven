package com.spring.data.jpa;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.data.jpa.config.DataConfig;
import com.spring.data.jpa.config.PersistenceContext;
import com.spring.data.jpa.model.Book;
import com.spring.data.jpa.repository.BookRepository;
import com.spring.data.jpa.service.BookService;
import com.spring.data.jpa.util.BookUtil;

public class Application {
	
	
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		//AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PersistenceContext.class);
		//ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("PersistenceContext.xml");
		/*ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("exampleApplicationContext-persistence.xml");
		BookService bookService = context.getBean(BookService.class);
		Book book = new Book();
		book.setTitle("TOM & JERRY");
		book.setPageCount(200);
		book.setPrice(new BigDecimal(300));
		book.setPublishDate(new Date());
		bookService.saveBook(book);
		
		System.out.println(bookService.findAll());*/
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("PersistenceContext.xml");
		BookRepository repository  = context.getBean(BookRepository.class);
		
		List<Book> books = BookUtil.create(7);
		repository.saveAll(books);
		
		Optional<Book> book = repository.findById(1L); 
		
		if(book.isPresent())
		{
			System.out.println(book);
		}
		
		repository.findAll().stream().forEach(obj->System.out.println(obj));
		
		
		
	}

}
