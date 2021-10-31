package com.example.LoginRegistration.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.LoginRegistration.service.userService;
import com.example.LoginRegistration.web.dto.userRegistrationDto;

@Controller
@RequestMapping("/registration")
public class userRegistrationController {
	private userService userService;

	public userRegistrationController(userService userService) {
		super();
		this.userService = userService;
	}
	
	@ModelAttribute("user")
	
	public userRegistrationDto UserRegistrationDto()
	{
		return new userRegistrationDto();
	}
	
	
	@GetMapping
	public String ShowRegsitrationForm()
	{
		return "Registration"; 	
	}
	
	@PostMapping
	public String RegisterUserAccount(@ModelAttribute("user") userRegistrationDto registrationDto )
	{
		userService.save(registrationDto);
		return "redirect:/registration?success";
	}
}
