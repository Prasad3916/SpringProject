package com.lms.application.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/")
	public String greet() {
		return "<script>\r\n"
				+ "location.href=\"https://sprightly-macaron-a90af8.netlify.app/\"\r\n"
				+ "</script>";
	}
}
