package com.example.selectAll.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="timecard")
public class Timecard {

	  @Id
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
	  private int id;
	  
//	  private Emp emp;
	  @Column(name="emp_id")
	  private int empId;

	  public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	@Column(name="intime")
	  private String intime;

	  @Column(name="outtime")
	  private String outime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

//	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
//	public Emp getEmp() {
//		return emp;
//	}
//
//	public void setEmp(Emp emp) {
//		this.emp = emp;
//	}

	public String getIntime() {
		return intime;
	}

	public void setIntime(String intime) {
		this.intime = intime;
	}

	public String getOutime() {
		return outime;
	}

	public void setOutime(String outime) {
		this.outime = outime;
	}
	  
	  
}
