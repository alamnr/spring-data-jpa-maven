package com.spring.data.jpa;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.data.jpa.config.DataConfig;
import com.spring.data.jpa.model.Book;
import com.spring.data.jpa.service.BookService;

public class Application {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataConfig.class);
		BookService service = context.getBean(BookService.class);
		Book book = new Book();
		book.setTitle("TOM & JERRY");
		book.setPageCount(200);
		book.setPrice(new BigDecimal(300));
		book.setPublishDate(new Date());
		service.saveBook(book);
		
		System.out.println(service.findAll());
	}

}
