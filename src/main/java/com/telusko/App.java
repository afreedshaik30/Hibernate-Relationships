package com.telusko;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.telusko.entity.Course;
import com.telusko.entity.Student;

public class App 
{
    public static void main(String[] args) 
    {
        Configuration cfg = new Configuration().configure("/com/telusko/config/hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Course.class);
        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
        SessionFactory sf = cfg.buildSessionFactory(reg);
        
// 1. @OneToOne
//        try (Session session = sf.openSession()) 
//        {
//            Transaction tx = session.beginTransaction();
//
//            // Create and save Course objects
//            Course c1 = new Course();
//            c1.setCid(1);
//            c1.setCname("Java FS");
//            session.save(c1); // Save course first
//
//            Course c2 = new Course();
//            c2.setCid(2);
//            c2.setCname("Python FS");
//            session.save(c2); // Save course first
//
//            // Now create Student objects with the saved Course references
//            Student s1 = new Student();
//            s1.setSid(101);
//            s1.setSname("Afreed");
//            s1.setCourse(c1);
//
//            Student s2 = new Student();
//            s2.setSid(102);
//            s2.setSname("Saki");
//            s2.setCourse(c2);
//            
//
//            // Save Student objects
//            session.save(s1);
//            session.save(s2);
//            tx.commit();
//        } 
//        catch (Exception e) 
//        {
//            e.printStackTrace(); // Handle exceptions properly
//        } 
        
 
// 2. @OneToMany / @ManyToOne       	  
//        try (Session session = sf.openSession()) 
//        {
//            Transaction tx = session.beginTransaction();
//
//            // Create Courses
//            Course java = new Course();
//            java.setCid(1);
//            java.setCname("Java");
//
//            Course angular = new Course();
//            angular.setCid(2);
//            angular.setCname("Angular");
//
//            Course python = new Course();
//            python.setCid(3);
//            python.setCname("Python FS");
//
//            // Create Student - s1
//            Student s1 = new Student();
//            s1.setSid(101);
//            s1.setSname("Afreed");
//
//            // List<Course> For Student 1
//            List<Course> coursesForS1 = new ArrayList<>();
//            coursesForS1.add(java);
//            coursesForS1.add(angular);
//            s1.setCourses(coursesForS1);
//            
//            // Create Student - s2
//            Student s2 = new Student();
//            s2.setSid(102);
//            s2.setSname("Salaar");
//            
//            // List<Course> For Student 2
//            List<Course> coursesForS2 = new ArrayList<>();
//            coursesForS2.add(python);
//            s2.setCourses(coursesForS2);
//
//            // Setting student reference for each course
//            java.setStudent(s1);
//            angular.setStudent(s1);
//            python.setStudent(s2);
//
//            // Save the Student (which will also save the Courses because of CascadeType.ALL)
//            	session.save(s1);
//            	session.save(s2);
//            	tx.commit();
//        } 
//        catch (Exception e) 
//        {
//            e.printStackTrace(); // Handle exceptions properly
//        }
        
// 3. @ManyToMany / @ManyToMany        
//        try( Session session = sf.openSession())
//        {
//        	Transaction tx = session.beginTransaction();
//        	
//        	//Create courses
//        	Course spring=new Course();
//        	spring.setCid(1);
//        	spring.setCname("SpringBoot");
//        	
//        	
//        	Course aws=new Course();
//        	aws.setCid(2);
//        	aws.setCname("AWS");
//        	aws.setStudent(null);
//        	
//        	//Create students
//        	Student st1=new Student();
//        	st1.setSid(560);
//        	st1.setSname("AFREED");
//        	
//        	List<Course> courseForSt1 = new ArrayList<>();
//        	courseForSt1.add(spring);
//        	courseForSt1.add(aws);
//        	st1.setCourse(courseForSt1);
//
//        	 // Assign the student to the courses
//            List<Student> studentsForCourses = new ArrayList<>();
//            studentsForCourses.add(st1);
//            spring.setStudent(studentsForCourses);
//            aws.setStudent(studentsForCourses);
//            
//            session.save(st1);
//            tx.commit();
//        }
//        catch(Exception e)
//        {
//        	e.printStackTrace();
//        }
        
    }// main()
}// class