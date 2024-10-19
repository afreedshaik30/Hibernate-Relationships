package com.telusko.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

/* WHY?? @JoinColumn(name = "course_id")
1.Specifies the Foreign Key Column,
2.Defines Ownership of the Relationship:
   In JPA, relationships are bidirectional or unidirectional. 
   In a unidirectional one-to-one relationship, the entity that owns the relationship (here, Student) must maintain a reference to the associated entity (here, Course). 
   The @JoinColumn annotation tells JPA that the Student entity is the owner of the relationship and that the foreign key (course_id) will be placed in the Student table.
   Without @JoinColumn, JPA would try to generate default column names, 
   which may not always match the intended structure or naming conventions of your database.
*/


/* 
 * mappedBy: The mappedBy attribute indicates that the Course entity owns the relationship. 
 *           The value should match the name of the field in the Course class that references the Student.
 *           In your case, that field is students 
 *           
 * CascadeType.ALL: In the Student class, 
 *                  I added cascade = CascadeType.ALL to the @OneToMany annotation. 
 *                  This ensures that when you save a Student, all associated Course entities will also be persisted automatically.          
 */

@Entity
public class Student 
{
	@Id
	private int sid;
	private String sname;
	
//1. 2 tables ---- sid, sname, course	   
//	@OneToOne
//	@JoinColumn(name = "course_id")
//	private Course course;
	

//2.without mappedBy 3 tables with 2 tables ---- sid,sname,List<Course>
//	@OneToMany(mappedBy="student", cascade = CascadeType.ALL)
//	private List <Course> courses;

	
//3. without mappedBy 4 tables with 3 tables ---- sid,sname,List<Course>
	@ManyToMany(mappedBy="student",cascade = CascadeType.ALL)
	private List<Course> course;
	
	//getters and setters
}

