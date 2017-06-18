package com.example.selectAll.dao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.selectAll.dao.repository.TimecardRepository;
import com.example.selectAll.entity.Timecard;

@Service
@Transactional
public class TimecardService {

	@Autowired
	TimecardRepository repository;

	public List<Timecard> selectAll() {
		return repository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

}
