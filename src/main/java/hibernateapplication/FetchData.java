package hibernateapplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FetchData {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		
		try {
			Student s = em.find(Student.class, 100);
			System.out.println(s.getID());
			System.out.println(s.getName());
			System.out.println(s.getAge());
			
		} catch (Exception e) {
			System.out.println("Invalid id");
		}
	} 
}
