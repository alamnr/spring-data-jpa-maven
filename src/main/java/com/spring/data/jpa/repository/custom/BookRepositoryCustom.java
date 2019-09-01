package com.spring.data.jpa.repository.custom;

import com.spring.data.jpa.model.Book;

public interface BookRepositoryCustom {

	public void saveAndLog(Book book);
}
