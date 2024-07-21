package hibernateapplication;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FetchDataDynamically {
	public static void main(String[] args) {
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

}
