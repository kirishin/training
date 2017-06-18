package com.example.io.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.io.form.IOForm;

@Controller
@RequestMapping("/io")
public class IOController {
	
	private static String PATH_INPUT = "para/input";
	private static String PATH_OUTPUT = "para/output";
	
	@RequestMapping("/input")
	public String input(){
		return PATH_INPUT;
	}
	
	@RequestMapping(value="/output", method = RequestMethod.GET)
	public String get(@ModelAttribute IOForm form, Model model){
		form.setMethodType("get");
		model.addAttribute("form", form);
		return PATH_OUTPUT;
	}
	
	@RequestMapping(value="/output", method = RequestMethod.POST)
	public String post(@ModelAttribute IOForm form, Model model){
		form.setMethodType("post");
		model.addAttribute("form", form);
		return PATH_OUTPUT;
	}
}
