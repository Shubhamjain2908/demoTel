package com.telusko.intern.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.telusko.intern.entity.Student;

public interface StudentRepository extends JpaRepository<Student, String>
{	
	public List<Student> findAllByAgeBetweenAndCityOrderByMarks(int age1, int age2, String city);
    public List<Student> findAllByAgeBetweenOrderByMarks(int age1, int age2);
    public List<Student> findAllByCityOrderByMarks(String city);
}