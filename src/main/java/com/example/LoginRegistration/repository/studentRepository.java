package com.example.LoginRegistration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.LoginRegistration.model.Student;

public interface studentRepository extends JpaRepository<Student, Long> {

}
