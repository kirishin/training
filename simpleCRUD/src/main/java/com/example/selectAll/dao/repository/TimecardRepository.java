package com.example.selectAll.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.selectAll.entity.Timecard;

public interface TimecardRepository  extends JpaRepository<Timecard, Integer>{

}
