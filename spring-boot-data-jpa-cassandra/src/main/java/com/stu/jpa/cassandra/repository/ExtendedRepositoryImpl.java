package com.stu.jpa.cassandra.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public class ExtendedRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID>
		implements ExtendedRepository<T, ID> {

	@PersistenceContext
	private EntityManager entityManager;

	public ExtendedRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
		this.entityManager = entityManager;
	}

	@Override
	public List<T> findAllCustomers(String firstName) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> cQuery = builder.createQuery(getDomainClass());
		Root<T> root = cQuery.from(getDomainClass());
		cQuery.select(root);
		TypedQuery<T> query = entityManager.createQuery(cQuery);
		return query.getResultList();
	}

}