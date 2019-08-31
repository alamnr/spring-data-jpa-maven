package com.spring.data.jpa.repository;

import java.io.Serializable;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

@NoRepositoryBean
public interface BaseReadOnlyRepository<T,ID extends Serializable> extends Repository<T, ID> {
	
	
	/**
	 * Retrieves an entity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the entity with the given id or {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	T findOne(ID id);

	/**
	 * Returns all instances of the type.
	 * 
	 * @return all entities
	 */
	Iterable<T> findAll();
}
