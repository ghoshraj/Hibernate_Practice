package hibernateapplication;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UpdateStudentDetailsDynamically {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter id :");
		int id = sc.nextInt();
		System.out.println("Enter Name :");
		String name = sc.next();
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Student s = new Student();
		s.setName(name);
		s.setID(id);
		s.setAge(id);
		
		et.begin();
		em.merge(s);
		et.commit();
	}
}
