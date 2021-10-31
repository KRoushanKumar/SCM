package com.example.LoginRegistration.service;

import java.util.List;

import com.example.LoginRegistration.model.Student;

public interface StudentService {
	List<Student> getAllStudent();
	Student saveStudent(Student student);
	Student updateStudent(Student student);
	Student getStudentById(Long id);
	void delectStudentById(Long id);
}
