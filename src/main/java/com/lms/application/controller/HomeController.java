package com.lms.application.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/")
	public String greet() {
		return "<a href="https://sprightly-macaron-a90af8.netlify.app/">click here </a>";
	}
}
