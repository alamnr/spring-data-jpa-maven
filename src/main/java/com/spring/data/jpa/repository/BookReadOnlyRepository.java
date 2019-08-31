package com.spring.data.jpa.repository;

import org.springframework.data.repository.NoRepositoryBean;

import com.spring.data.jpa.model.Book;

@NoRepositoryBean
public interface BookReadOnlyRepository extends BaseReadOnlyRepository<Book, Long> {
  //	public Book findByTitle(String title);
}
