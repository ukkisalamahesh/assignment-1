package com.example.Assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Assignment.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Long> {

}