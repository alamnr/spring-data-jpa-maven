package com.spring.data.jpa;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.data.jpa.config.DataConfig;
import com.spring.data.jpa.config.PersistenceContext;
import com.spring.data.jpa.model.Book;
import com.spring.data.jpa.service.BookService;

public class Application {
	
	
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PersistenceContext.class);
		BookService bookService = context.getBean(BookService.class);
		Book book = new Book();
		book.setTitle("TOM & JERRY");
		book.setPageCount(200);
		book.setPrice(new BigDecimal(300));
		book.setPublishDate(new Date());
		bookService.saveBook(book);
		
		System.out.println(bookService.findAll());
	}

}
