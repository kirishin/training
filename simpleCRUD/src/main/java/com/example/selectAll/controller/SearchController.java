package com.example.selectAll.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.select.dao.service.searchDeptService;
import com.example.selectAll.dao.service.DeptService;
import com.example.selectAll.dao.service.EmpService;
import com.example.selectAll.dao.service.TimecardService;

import groovy.lang.MetaClassImpl.Index;

@Controller
@RequestMapping("/selectAll")
public class SearchController {
	private static String PATH_INDEX = "selectAll/selectAll_index"; 
	private static String PATH_SELECT_EMP = "selectAll/empList"; 
	private static String PATH_SELECT_DEPT = "selectAll/deptList"; 
	private static String PATH_SELECT_TIMECARD = "selectAll/timecardList"; 
	@Autowired
	EmpService empService;
	@Autowired
	DeptService deptService;	
	@Autowired
	TimecardService timecardService;
	
	@RequestMapping(value="/" ,method=RequestMethod.GET)
	public String index(){
		return PATH_INDEX;
	}
	
	@RequestMapping(value="/emp", method=RequestMethod.GET)
	public String selectEmp(Model model){
		model.addAttribute("list", empService.selectAll());
		return PATH_SELECT_EMP;
	}

	@RequestMapping(value="/emps", method=RequestMethod.GET)
	public String selectEmps(Model model, String name){
		model.addAttribute("list", empService.selectEmp(name));
		return PATH_SELECT_EMP;
	}

	@RequestMapping(value="/dept", method=RequestMethod.GET)
	public String selectDept(Model model){
		model.addAttribute("list", deptService.selectAll());
		return PATH_SELECT_DEPT;
	}
	@RequestMapping(value="/timecard", method=RequestMethod.GET)
	public String selectTimecard(Model model){
		model.addAttribute("list", timecardService.selectAll());
		return PATH_SELECT_TIMECARD;
	}
}
