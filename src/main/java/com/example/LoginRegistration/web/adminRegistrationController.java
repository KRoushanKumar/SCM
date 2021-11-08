package com.example.LoginRegistration.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.LoginRegistration.model.Admin;

@Controller
@RequestMapping("/adminRegistration")
public class adminRegistrationController {
	
	
	
	@ModelAttribute("admin")
	
	public Admin admin()
	{
		return new Admin();
	}
	
	@GetMapping
	public String ShowAdminRegsitrationForm()
	{
		return "adminRegistration"; 	
	}
	
	
	
}
