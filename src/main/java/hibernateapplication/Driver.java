package hibernateapplication;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Driver {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter id :");
		int id = sc.nextInt();
		System.out.println("Enter name :");
		String name = sc.next();
		System.out.println("Enter age :");
		int age = sc.nextInt();
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Student s = new Student();
//		s.setID(1);
//		s.setName("Rajesh");
//		s.setAge(22);
		s.setID(id);
		s.setName(name);
		s.setAge(age);
		
		et.begin();
		em.persist(s);
		et.commit();
	}
}
