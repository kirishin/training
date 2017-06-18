package com.example.selectAll.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.selectAll.entity.Emp;


public interface EmpRepository extends JpaRepository<Emp, Integer>{

}
