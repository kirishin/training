package com.example.criteriaTest.dao;

import java.io.Serializable;
import java.util.List;

public interface EmpDao <T> extends Serializable {
	public List<T> getAll();

}
