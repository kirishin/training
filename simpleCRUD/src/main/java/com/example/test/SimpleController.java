package com.example.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class SimpleController {
	
	private static String PATH_INDEX = "index";
	private static String PATH_PAGE1 = "page1";
	private static String PATH_PAGE2 = "folder/page2";

	@RequestMapping("/")
	public String getRoot(){
		return PATH_INDEX;
	}
	
	@RequestMapping("/page1")
	public String getPage1(){
		return PATH_PAGE1;
	}
	
	@RequestMapping("/page2")
	public static String goPage2(){
		return PATH_PAGE2;
	}

}
