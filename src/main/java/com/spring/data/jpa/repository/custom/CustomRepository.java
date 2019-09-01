package com.spring.data.jpa.repository.custom;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.data.jpa.model.Book;

public interface CustomRepository extends JpaRepository<Book, Long>, BookRepositoryCustom {
	public List<Book> findByPageCountGreaterThan(int pageCount,Sort sort);
}
