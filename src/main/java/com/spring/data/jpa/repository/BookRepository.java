package com.spring.data.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.data.jpa.model.Book;


//@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	
	List<Book> findByTitle(String title);
}
