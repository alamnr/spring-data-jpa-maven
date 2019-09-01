package com.spring.data.jpa.repository;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.data.jpa.model.Book;


//@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	
	@Transactional
	@Modifying
	@Query("update Book b set b.pageCount = ?2 where b.title like ?1")
	public int setPageCount(String title,int pageCount);
		
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
	
	@Query("select b from Book b")
	public List<Book> queryJpql1();
	
	@Query("select b from Book b where b.price = ?1")
	public List<Book> queryJpqlOrdinalParam(BigDecimal price);
	
	@Query("select b from Book b where b.title = :title")
	public List<Book> queryJpqlNamedParam(@Param("title")String title);
	
	 /*Paging and Sorting and various return type*/
	
	List<Book> findByPageCountGreaterThan(int pageCount,Sort sort);
	
	Collection<Book> findByPageCountLessThan(int pageCount,PageRequest pageRequest);
	
	Iterable<Book> findByPageCountGreaterThan(int pageCount,Sort sort,PageRequest pageRequest);
	
	Page<Book> findByPageCountGreaterThan(int pageCount,PageRequest pageRequest);
	
	Slice<Book> findByPageCountLessThanEqual(int pageCount,PageRequest pageRequest);
}
