package manyToMany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class StudentDriver {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Student s1 = new Student();
		s1.setName("Rajesh");
		s1.setAge(21);
	
		
		Student s2 = new Student();
		s2.setName("Deba");
		s2.setAge(25);
		
		Student s3 = new Student();
		s3.setName("Animesh");
		s3.setAge(23);
		
		Student s4 = new Student();
		s4.setName("Subhasis");
		s4.setAge(24);
		
		Student s5 = new Student();
		s5.setName("Surojit");
		s5.setAge(22);
		
		Course c1 = new Course();
		c1.setName("Java");
		c1.setDuration("3 months");
		
		Course c2 = new Course();
		c2.setName("SQL");
		c2.setDuration("1.5 months");
		
		Course c3 = new Course();
		c3.setName("WEB");
		c3.setDuration("1.5 months");
		
		Course c4 = new Course();
		c4.setName("Advance Java");
		c4.setDuration("2 months");
		
		List<Course> cources = new ArrayList<Course>();
		cources.add(c1);
		cources.add(c2);
		cources.add(c3);
		cources.add(c4);
		
		s1.setC(cources);
		s2.setC(cources);
		s3.setC(cources);
		s4.setC(cources);
		s5.setC(cources);
		
		List<Student>students = new ArrayList<Student>();
		students.add(s1);
		students.add(s2);
		students.add(s3);
		students.add(s4);
	    students.add(s5);
	    
	   c1.setS(students);	
	   c2.setS(students);
	   c3.setS(students);
	   c4.setS(students);
	   
	   et.begin();
	   em.persist(s1);
	   em.persist(s2);
	   em.persist(s3);
	   em.persist(s4);
	   em.persist(s5);
	   em.persist(c1);
	   em.persist(c2);
	   em.persist(c3);
	   em.persist(c4);
	   et.commit();
	}
}
