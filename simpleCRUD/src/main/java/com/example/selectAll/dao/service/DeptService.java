package com.example.selectAll.dao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.selectAll.dao.repository.DeptRepository;
import com.example.selectAll.entity.Dept;

@Service
@Transactional
public class DeptService {

	@Autowired
	DeptRepository repository;

	public List<Dept> selectAll() {
		return repository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

}
