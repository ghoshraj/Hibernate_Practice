package hibernateapplication;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class AllCrudOperation {

	// insert data...
	public static void insert() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

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

	// fetch data
	public static void display() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter id :");
		int id = sc.nextInt();

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();

		try {
			Student s = em.find(Student.class, id);
			System.out.println(s.getID());
			System.out.println(s.getName());
			System.out.println(s.getAge());
		} catch (Exception e) {
			System.out.println("Invalid id");
		}
	}

	// update data
	public static void update() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter id :");
		int id = sc.nextInt();
		System.out.println("Enter Name :");
		//String name = sc.next();
		int age = sc.nextInt();

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Student s = em.find(Student.class, id);
		//s.s(name);
		s.setAge(age);
		
		et.begin();
		em.merge(s);
		et.commit();
	}

	// delete data
	public static void delete() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter id you want to delete");
		int id = sc.nextInt();

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		try {
			Student s = em.find(Student.class, id);
			et.begin();
			em.remove(s);
			et.commit();
		} catch (Exception e) {
			System.out.println("Invalid id ");
		}

	}
}
