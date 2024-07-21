package hibernateapplication;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FetchDataDynamicallyFromProduct {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter id : ");
		int id = sc.nextInt();
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		
		try {
			Product p = em.find(Product.class, id);
			System.out.println(p.getId());
			System.out.println(p.getBrand());
			System.out.println(p.getCategory());
			System.out.println(p.getPrice());
		} catch (Exception e) {
			System.out.println("!!!!!!!!!!!!!!!!!!!! Invalid Id !!!!!!!!!!!!!!!!");
		}
	}
}
