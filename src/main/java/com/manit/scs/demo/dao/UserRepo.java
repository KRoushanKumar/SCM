package com.manit.scs.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.manit.scs.demo.entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{


	
	String query="SELECT * FROM user where year=:year and department=:department";
//	String query="select "
//			+ "u.id,"
//			+ "u.first_name,"
//			+ "u.last_name,"
//			+ "u.image_url,"
//			+ "d.name "
//			+ "from user u left join department d "
//			+ "on u.department=d.d_id "
//			+ "where department = 2"
//			+ "and year=:year";
	@Query(value = query,nativeQuery = true)
	List<User> MyClassmates(@Param("year")  int year,@Param("department") String department);

}
