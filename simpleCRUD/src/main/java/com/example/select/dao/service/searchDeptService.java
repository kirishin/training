package com.example.select.dao.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.selectAll.entity.Emp;

@Service
@Transactional
public class searchDeptService{
	
	@PersistenceContext
	EntityManager manager;
	
	public List<Emp> get(int id){
		return manager
				.createQuery("from Emp where dept_id = :dept_id", Emp.class)
				.setParameter("dept_id", id)
				.getResultList();
	}

}
