package com.sharad.demo.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sharad.demo.dao.StudentDao;
import com.sharad.demo.vo.Age;
import com.sharad.demo.vo.Result;
import com.sharad.demo.vo.Student;
import com.sharad.demo.vo.StudentEntity;

@Component
public class StudentImpl {

	@Autowired
	StudentDao studentDao;

	Set<String> citySet;

	public List<Result> getStudentList() {
		Iterable<StudentEntity> studentList = studentDao.findAll();
		List<Result> resultList = new ArrayList<>();
		citySet = new HashSet<>();
		for (StudentEntity s : studentList) {
			citySet.add(s.getCity());

		}

		for (String city : citySet) {
			Result result = new Result();
			result.setCity(city);
			result.setAge(getAgeList(city, studentList));
			resultList.add(result);
		}

		return resultList;
	}

	private List<Age> getAgeList(String city, Iterable<StudentEntity> studentList) {
		List<Age> ageList = new ArrayList<>();

		Age age1 = new Age();
		// age1.setAge("10-20");
		ageList.add(age1);

		Age age2 = new Age();
		// age2.setAge("20-40");
		ageList.add(age2);

		Age age3 = new Age();
		// age3.setAge("40-60");
		ageList.add(age3);

		List<Student> finalstudentList1 = new ArrayList<>();
		List<Student> finalstudentList2 = new ArrayList<>();
		List<Student> finalstudentList3 = new ArrayList<>();
		for (StudentEntity s : studentList) {
			if (s.getCity().equalsIgnoreCase(city)) {
				if (10 <= Integer.parseInt(s.getAge()) && 20 > Integer.parseInt(s.getAge())) {

					Student student = new Student();
					student.setName(s.getName());
					student.setMarks(s.getMarks());
					student.setAge(s.getAge());
					finalstudentList1.add(student);
					ageList.get(0).setAgeGroup("10-20");
					ageList.get(0).setStudent(finalstudentList1);
				} else if (20 <= Integer.parseInt(s.getAge()) && 40 > Integer.parseInt(s.getAge())) {
					Student student = new Student();
					student.setName(s.getName());
					student.setMarks(s.getMarks());
					student.setAge(s.getAge());
					finalstudentList2.add(student);
					ageList.get(1).setAgeGroup("20-40");
					ageList.get(1).setStudent(finalstudentList2);
				} else {
					Student student = new Student();
					student.setName(s.getName());
					student.setMarks(s.getMarks());
					student.setAge(s.getAge());
					finalstudentList3.add(student);
					ageList.get(2).setAgeGroup("40-60");
					ageList.get(2).setStudent(finalstudentList3);
				}
			}

		}

		
		
		
		for (Age age : ageList) {
			List<String> marksList = new ArrayList<>();
			if(null != age.getStudent()) {
			for (Student s : age.getStudent()) {
				marksList.add(s.getMarks());
			}
			Collections.sort(marksList);
			if (marksList.size() > 2) {
				for (int i = 0; i <= marksList.size() - 3; i++) {
					marksList.remove(i);
				}

				marksList.forEach(s->System.out.println(s));
				System.out.println("After printing...");
				for (Student s : age.getStudent()) {
					
					if (!marksList.contains(s.getMarks())) {
						System.out.println(s.getMarks());
						age.getStudent().remove(s);
					}
				}
			}

		}
		}

		return ageList;
	}

}
