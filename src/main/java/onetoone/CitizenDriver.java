package onetoone;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CitizenDriver {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Citizen citizen = new Citizen();
		citizen.setName("Rajesh");
		citizen.setAge(22);
		
		Adhar a = new Adhar();
		a.setAdharNumber(1234556);
		a.setAddress("Gopiballavpur");
		
		citizen.setAdhar(a);
		a.setCitizen(citizen);
		
		et.begin();
		em.persist(citizen);
		em.persist(a);
		et.commit();
	}
}
