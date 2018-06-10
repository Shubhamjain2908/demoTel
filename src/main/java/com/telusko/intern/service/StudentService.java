package com.telusko.intern.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telusko.intern.entity.Student;
import com.telusko.intern.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository sR;
	
	public List<Student> getAllStudents() 
	{
		return sR.findAll();
	}
}
