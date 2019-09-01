package com.spring.data.jpa.repository.custom;

import java.io.Serializable;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.Query;


import org.assertj.core.util.Arrays;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public class BaseRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID>
implements BaseRepository<T, ID>{
	
	private JpaEntityInformation<T, ?> entityInformation;
	
	
	EntityManager entityManager;

	public BaseRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
		this.entityInformation = entityInformation;
		this.entityManager = entityManager;
	}

	@Override
	public List<T> findByIds(ID... ids) {
		Query query = this.entityManager.createQuery(" select e from  "+ this.entityInformation.getEntityName()
		+ " e where e."+this.entityInformation.getIdAttribute().getName()+" in :ids");
		query.setParameter("ids", Arrays.asList(ids));
		return query.getResultList();
	}

}
