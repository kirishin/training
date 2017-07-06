package com.example.umatsu.trainingCRUD.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/")
@Controller
public class IndexController {

	@RequestMapping(value = "/", method=GET)
	public String index() {
		return "index";
	}
}
