package com.example.selectAll.dao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.selectAll.dao.repository.EmpRepository;
import com.example.selectAll.entity.Emp;

@Service
@Transactional
public class EmpService {

	@Autowired
	EmpRepository repository;

	public List<Emp> selectAll() {
		return repository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

}
