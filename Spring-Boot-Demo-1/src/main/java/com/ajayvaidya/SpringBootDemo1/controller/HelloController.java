package com.ajayvaidya.SpringBootDemo1.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
public class HelloController {
	
	@Value("${frontpage.message}")
	private String msg;
//	@RequestMapping(value = "/", method = RequestMethod.GET)
	@GetMapping("/")
	public String hello() {
		return msg;
	}
}
