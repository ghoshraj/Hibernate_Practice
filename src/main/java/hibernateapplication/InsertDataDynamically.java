package hibernateapplication;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class InsertDataDynamically {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		for (int i = 0; i < 2; i++) {
			Student s = new Student();
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter id :");
			int id = sc.nextInt();
			System.out.println("Enter name :");
			String name = sc.next();
			System.out.println("Enter age :");
			int age = sc.nextInt();

			s.setID(id);
			s.setName(name);
			s.setAge(age);


			et.begin();
			em.persist(s);
			et.commit();
		}
	}
}
