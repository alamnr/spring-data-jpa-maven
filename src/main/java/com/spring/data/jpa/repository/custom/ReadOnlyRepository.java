package com.spring.data.jpa.repository.custom;


import java.io.Serializable;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

@NoRepositoryBean
public interface ReadOnlyRepository<T,ID extends Serializable> extends Repository<T, ID> {

	T findOne(ID id);
	Iterable<T> findAll();
}
