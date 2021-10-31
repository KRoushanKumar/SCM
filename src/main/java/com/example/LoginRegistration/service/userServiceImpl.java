package com.example.LoginRegistration.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.LoginRegistration.model.Role;
import com.example.LoginRegistration.model.User;
import com.example.LoginRegistration.repository.userRepository;
import com.example.LoginRegistration.web.dto.userRegistrationDto;

@Service
public class userServiceImpl implements userService{

	@Autowired
	private userRepository userRepo;
	
	
	
	public userServiceImpl(userRepository userRepo) {
		super();
		this.userRepo = userRepo;
	}
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	

	@Override
	public User save(userRegistrationDto registrationDto)
	{
		User user  = new User(registrationDto.getFirstName(),
				registrationDto.getLastName(),registrationDto.getEmail(),
				passwordEncoder.encode(registrationDto.getPass()),Arrays.asList(new Role("Role_user")) );
		
		return userRepo.save(user);
	}


	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByEmail(username);
		if(user==null)
		{
			throw new UsernameNotFoundException("Invalid username or password");
		}
		 
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPass(),mapRolesToAuthorities(user.getRoles()));
		
	}
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles)
	{
		return roles.stream().map(role-> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}

}
