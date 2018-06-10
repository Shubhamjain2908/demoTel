package com.telusko.intern.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.intern.entity.Student;
import com.telusko.intern.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping
	public List<Student> getStudent(@RequestParam(required=false) Map<String,String> allRequestParams) 
	{
		return studentService.getAllStudents();
	}
}
