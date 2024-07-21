package onetoone;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CountryDriver {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Country c = new Country();
		c.setName("India");
		c.setPopulation(1483333333);
		
		PrimeMinister pm = new PrimeMinister();
		pm.setName("N.M");
		pm.setAge(78);
		
		c.setPm(pm);
		pm.setC(c);
		
		et.begin();
		em.persist(c);
		em.persist(pm);
		et.commit();
	}
}
