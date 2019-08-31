package com.spring.data.jpa;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.helpers.BoundedFIFO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.data.jpa.config.DataConfig;
import com.spring.data.jpa.config.PersistenceContext;
import com.spring.data.jpa.model.Book;
import com.spring.data.jpa.repository.BookRepository;
import com.spring.data.jpa.repository.BaseReadOnlyRepository;
import com.spring.data.jpa.repository.BookReadOnlyRepository;
import com.spring.data.jpa.service.BookService;
import com.spring.data.jpa.util.BookUtil;

public class Application {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws ParseException {
		// AnnotationConfigApplicationContext context = new
		// AnnotationConfigApplicationContext(PersistenceContext.class);
		// ClassPathXmlApplicationContext context = new
		// ClassPathXmlApplicationContext("PersistenceContext.xml");
		/*
		 * ClassPathXmlApplicationContext context = new
		 * ClassPathXmlApplicationContext("exampleApplicationContext-persistence.xml");
		 * BookService bookService = context.getBean(BookService.class); Book book = new
		 * Book(); book.setTitle("TOM & JERRY"); book.setPageCount(200);
		 * book.setPrice(new BigDecimal(300)); book.setPublishDate(new Date());
		 * bookService.saveBook(book);
		 * 
		 * System.out.println(bookService.findAll());
		 */

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("PersistenceContext.xml");
		BookRepository bookRepository = context.getBean(BookRepository.class);

		List<Book> books = BookUtil.create(7);
		bookRepository.saveAll(books);
		
	

		/*Optional<Book> optional = repository.findById(1L);
		Book myBook = null ;
		if (optional.isPresent()) {
			System.out.println(optional.get());
			myBook = optional.get();
		}
		
		//myBook.setBookId(1000L);

		myBook.setTitle("War and Peace");

		repository.saveAndFlush(myBook);
		// repository.findAll().stream().forEach(obj->System.out.println(obj));

		optional = repository.findById(1L);

		if (optional.isPresent()) {
			System.out.println(optional.get());
		}
		
		repository.findAll().stream().forEach(obj->System.out.println(obj));
		
		optional = repository.findById(1000L);

		if (optional.isPresent()) {
			System.out.println(optional.get());
		}
*/
		
		//repository.deleteById(1L);
		//repository.delete(repository.findById(1L).get());
		//repository.deleteAll(repository.findAllById((Arrays.asList(1L,2L,3L))));
		//repository.deleteInBatch(repository.findAllById((Arrays.asList(1L,2L,3L))));
		//repository.deleteAll();
		//repository.deleteAllInBatch();
		
		//repository.findAll().stream().forEach(obj->System.out.println(obj));
		
		/*CustomRepositoryImpl customRepository = context.getBean(CustomRepositoryImpl.class);
		
		customRepository.save(books);
		
		System.out.println(customRepository.findOne(1L));
		
		customRepository.findAll().iterator().forEachRemaining(obj->System.out.println(obj));*/
		
		/*bookRepository.findByTitle("1984").stream().forEach(obj->System.out.println(obj));
		bookRepository.findByTitleIgnoreCase("ulysses").stream().forEach(obj->System.out.println(obj));
		
		Date date1= new SimpleDateFormat("mm/dd/yyyy").parse("10/22/1995");
		Date date2= new SimpleDateFormat("mm/dd/yyyy").parse("10/22/1997");
		bookRepository.findBypublishDateBetween(date1, date2).stream().forEach(obj->System.out.println(obj));
		*/
		bookRepository.findTopByOrderByPageCountDesc().stream().forEach(obj->System.out.println(obj));
		
		bookRepository.findFirstByOrderByPageCountAsc().stream().forEach(obj->System.out.println(obj));
		
		bookRepository.findTop5ByOrderByPriceDesc().stream().forEach(obj->System.out.println(obj));
	}
		
}
