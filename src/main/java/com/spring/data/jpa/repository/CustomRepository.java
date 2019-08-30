package com.spring.data.jpa.repository;

import java.io.Serializable;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

@NoRepositoryBean
public interface CustomRepository<T,ID extends Serializable> extends Repository<T, ID> {
	/**
	 * Saves all given entities.
	 * 
	 * @param entities
	 * @return the saved entities
	 * @throws IllegalArgumentException in case the given entity is (@literal null}.
	 */
	<S extends T> Iterable<S> save(Iterable<S> entities);
	
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
