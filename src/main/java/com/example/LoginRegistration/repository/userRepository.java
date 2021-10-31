package com.example.LoginRegistration.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.LoginRegistration.model.User;

@Repository
public interface userRepository extends JpaRepository<User , Long>{
	
	User findByEmail(String email );

}
