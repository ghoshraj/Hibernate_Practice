package hibernateapplication;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveDataDynamically {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter id :");
		int id = sc.nextInt();
		System.out.println("Enter brand : ");
		String brand = sc.next();
		System.out.println("Enter Category :");
		String cat = sc.next();
		System.out.println("Enter price :");
		double price = sc.nextDouble();
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Product p = new Product();
		p.setId(id);
		p.setBrand(brand);
		p.setCategory(cat);
		p.setPrice(price);
		
		et.begin();
		em.persist(p);
		et.commit();
	}
}
