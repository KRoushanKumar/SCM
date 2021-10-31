package com.example.LoginRegistration.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.LoginRegistration.model.User;
import com.example.LoginRegistration.web.dto.userRegistrationDto;

public interface userService extends UserDetailsService  {
	User save(userRegistrationDto registrationDto);

	
}
