package com.example.criteriaTest.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table
public class Emp2 {
	@Id
	private Integer id;
	private String name;
	private Integer dept;

}
