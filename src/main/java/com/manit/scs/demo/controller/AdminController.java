package com.manit.scs.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/system")
public class AdminController {

	@GetMapping("/admin")
	public String adminLogin()
	{
		return null;
	}
}
