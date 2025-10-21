package com.lms.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.application.model.Admin;

@RestController
public class AdminController {

	@Autowired
	Admin admin;
	
	@GetMapping("/admin/")
	@CrossOrigin
	public Admin getAdmin() {
		admin.setUsername("admin");
		admin.setPassword("admin123");
		return admin;
	}
	
	
}
