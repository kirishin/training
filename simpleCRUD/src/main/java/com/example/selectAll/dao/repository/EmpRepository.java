package com.example.selectAll.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.selectAll.entity.Emp;


public interface EmpRepository extends JpaRepository<Emp, Integer>{

	@Query("select u from Emp u where u.name = :nam order by u.id asc")
	public List<Emp> findEmp(@Param("nam") String nam);
}
