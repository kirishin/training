package com.example.criteriaTest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.example.criteriaTest.entity.Emp2;

@Repository
public class EmpDaoJpql implements EmpDao<Emp2>{
	
	private EntityManager entityManager;
	
	public EmpDaoJpql(){}
	
	public EmpDaoJpql(EntityManager entityManager){
		this.entityManager = entityManager;
	}
	
	@Override
	public List<Emp2> getAll(){
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Emp2> query = builder.createQuery(Emp2.class);
		Root<Emp2> root = query.from(Emp2.class);
		query.select(root);
		List<Emp2> list = entityManager.createQuery(query).getResultList();
		return list;
	}

}
