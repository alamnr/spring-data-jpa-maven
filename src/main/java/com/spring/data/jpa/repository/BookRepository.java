package com.spring.data.jpa.repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.data.jpa.model.Book;


//@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
		
	/*String operator derived query*/
	public List<Book> findByTitle(String title);
	
	public List<Book> findByTitleLike(String title);
	
	public List<Book> findByTitleContaining(String title);
	
	public List<Book> findByTitleStartingWith(String title);
	
	public List<Book> findByTitleEndingWith(String title);
	
	public List<Book> findByTitleIgnoreCase(String title);
	
	/*Relational operator derived query*/
	
	public List<Book> findByPageCountEquals(int pageCount);
	
	public List<Book> findByPageCountGreaterThan(int pageCount);
	
	public List<Book> findByPageCountLessThan(int pageCount);
	
	public List<Book> findByPageCountGreaterThanEqual(int pageCount);
	
	public List<Book> findByPageCountLessThanEqual(int pageCount);
	
	public List<Book> findByPageCountBetween(int min,int max);
	
/*	Logical operator derived query*/
	
	public List<Book> findByTitleContainingOrTitleContaining(String title1,String title2);
	
	public List<Book> findByTitleContainingAndPageCountGreaterThan(String title, int pageCount);
	
	public List<Book> findByTitleNot(String title);
	
	/*Date comparison*/
	
	List<Book> findByPublishDateAfter(Date date);
	
	List<Book> findByPublishDateBefore(Date date);
	
	List<Book> findBypublishDateBetween(Date date1, Date date2); 
	
	/*Order By*/
	
	public List <Book> findByTitleContainingOrderByTitleAsc(String title);
	
	public List <Book> findByTitleContainingOrderByTitleDesc(String title);
	
	/*Limiting Query Result*/
	
	public List<Book> findTopByOrderByPageCountDesc();
	
	public List<Book> findFirstByOrderByPageCountAsc();
	
	public List<Book> findTop5ByOrderByPriceDesc();
	
	public List<Book> findTop5ByTitleOrderByPriceAsc(String title);
	
	/*Using @Query annotation for JPQL query*/
	
	
	public List<Book> queryJpql1();
	
	
	public List<Book> queryJpqlOrdinalParam(BigDecimal price);
	
	
	public List<Book> queryJpqlNamedParam(@Param("title")String title);
	
}
