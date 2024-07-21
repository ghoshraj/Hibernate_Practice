package hibernateapplication;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DeleteDataFromDatabase {
	public static void main(String[] args) {
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
