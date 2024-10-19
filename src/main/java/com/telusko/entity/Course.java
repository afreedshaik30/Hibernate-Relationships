package com.telusko.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Course 
{
	//1. 1:1 cid, cname
	@Id
	private int cid;
	private String cname;

    //2. N:1 cid,cname, Student student(student_id)
//	@ManyToOne 
//	@JoinColumn(name = "student_id")
//	private Student student;
	
	//3. N:N cid,cname, List<Student> student(student_id)
	@ManyToMany
//	@JoinColumn(name = "student_id")
	private List<Student> student;
	
	//getters and setters
}