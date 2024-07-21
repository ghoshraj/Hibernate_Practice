package manyToOne;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class BankDriver {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Bank b1 = new Bank();
		b1.setName("RR");
		b1.setIfsc("R123");
		b1.setCeo("Rajesh");

		Account a1 = new Account();
		a1.setName("Animesh");
		a1.setAccountnum(12345678);
		a1.setAddress("Kolkata");

		Account a2 = new Account();
		a2.setName("Deba");
		a2.setAccountnum(456789078);
		a2.setAddress("Asam");

		List<Account> a = new ArrayList<Account>();
		a.add(a1);
		a.add(a2);
		b1.setA(a);
		
		a1.setB(b1);
		a2.setB(b1);
		
		et.begin();
		em.persist(b1);
		em.persist(a1);
		em.persist(a2);
		et.commit();
		
	}
}
