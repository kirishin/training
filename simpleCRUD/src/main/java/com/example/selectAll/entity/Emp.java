package com.example.selectAll.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "emp")
public class Emp {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name")
	private String name;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="dept_id")
	private Dept dept;
	
//	@Column(name = "dept_id")
//	private int deptId;

	@Column(name = "working")
	private int working;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public int getWorking() {
		return working;
	}

	public void setWorking(int working) {
		this.working = working;
	}

//	public int getDeptId() {
//		return deptId;
//	}
//
//	public void setDeptId(int deptId) {
//		this.deptId = deptId;
//	}


}
