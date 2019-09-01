package com.spring.data.jpa.repository.custom;

import java.io.Serializable;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

@NoRepositoryBean
public interface WriteOnlyRepository<T, ID extends Serializable> extends Repository<T, ID> {
	/**
	 * Saves all given entities.
	 * 
	 * @param entities7s
	 * @return the saved entities
	 * @throws IllegalArgumentException
	 *             in case the given entity is (@literal null}.
	 */
	<S extends T> Iterable<S> save(Iterable<S> entities);
}
