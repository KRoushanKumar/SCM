package com.manit.scs.demo.controller;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.manit.scs.demo.entity.User;
import com.manit.scs.demo.service.UserService;

@Controller
public class StudentController {
	
	UserService userService;
	
	
	public StudentController(UserService userService) {
		super();
		this.userService = userService;
	}


	@GetMapping("/showMyClassmates")
	public String ShowMyclassmates(Model theStudent,HttpSession request)
	{
		int year=1;
		
		User currentUser = (User) request.getAttribute("user");
		if(currentUser!=null)
		year = currentUser.getYear();
		String depart="";
		depart= currentUser.getDepartmentId();
		System.out.println(" year "+year);
		System.out.println(" Department "+depart);
		theStudent.addAttribute("students",userService.MyClassmates(year,depart));
		
		return "MyClassmate";
	}
	@GetMapping("/GroupChat")
	public String showGroupChat(Model theStudent,HttpSession request)
	{
		int year=1;
		User currentUser = (User) request.getAttribute("user");
		if(currentUser!=null)
		year = currentUser.getYear();
		String depart="";
		depart= currentUser.getDepartmentId();
		System.out.println(" year "+year);
		System.out.println(" Department "+depart);
		theStudent.addAttribute("students",userService.MyClassmates(year,depart));
		return "groupChat";
	}
	
}
