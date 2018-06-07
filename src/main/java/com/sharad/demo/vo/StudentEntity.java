package com.sharad.demo.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Student")
public class StudentEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
	private long id;
	private String name;
	private String age;
	private String marks;
	private String city;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getMarks() {
		return marks;
	}
	public void setMarks(String marks) {
		this.marks = marks;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
	@Override
	public String toString() {
		return "StudentEntity [id=" + id + ", name=" + name + ", age=" + age + ", marks=" + marks + ", city=" + city
				+ "]";
	}
}
