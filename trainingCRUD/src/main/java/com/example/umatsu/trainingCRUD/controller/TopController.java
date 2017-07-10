package com.example.umatsu.trainingCRUD.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class TopController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "/top", method = RequestMethod.GET)
	public String top() {
		return "top";
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String user() {
		return "user";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String admin() {
		return "admin";
	}

	@RequestMapping(value = "/error", method = {RequestMethod.GET, RequestMethod.POST})
	public String error() {
		return "error";
	}

	@RequestMapping(value = "/403", method = {RequestMethod.GET, RequestMethod.POST})
	public String permission() {
		return "403";
	}
}
