package com.example.LoginRegistration.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.LoginRegistration.model.Student;
import com.example.LoginRegistration.repository.studentRepository;

@Service
public class StudentServiceImpl implements StudentService{

	private studentRepository StudentRepository;
	
	
	public StudentServiceImpl(studentRepository studentRepository) {
		super();
		StudentRepository = studentRepository;
	}


	@Override
	public List<Student> getAllStudent() {
		return StudentRepository.findAll();
	}


	@Override
	public Student saveStudent(Student student) {
		return StudentRepository.save(student);
		
	}


	@Override
	public Student getStudentById(Long id) {
		return StudentRepository.findById(id).get();
	}


	@Override
	public Student updateStudent(Student student) {
		return StudentRepository.save(student);
	}


	@Override
	public void delectStudentById(Long id) {
		StudentRepository.deleteById(id);
	}

	
	
}
