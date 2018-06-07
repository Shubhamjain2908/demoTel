package com.sharad.demo.Resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sharad.demo.impl.StudentImpl;
import com.sharad.demo.vo.Result;

@RestController
public class StudentResource {

	@Autowired
	StudentImpl studentImpl;
	
	@RequestMapping(value = "/student",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Result> getStudentData() {
		
		return studentImpl.getStudentList();
		//return "Greetings from Spring Boot!";
	}
}
