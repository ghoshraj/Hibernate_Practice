package manyToOne;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class HospitalDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Hospital h1 = new Hospital();
		h1.setName("RG");
		h1.setCeo("Rajesh");
		
		Branch b1 = new Branch();
		b1.setName("RG-marathalli");
		b1.setManager("Deba");
		
		Branch b2 = new Branch();
		b2.setName("RG-KOlkata");
		b2.setManager("Animesh");
		
		b1.setHospital(h1);
		b2.setHospital(h1);
		
		et.begin();
		em.persist(h1);
		em.persist(b1);
		em.persist(b2);
		et.commit();
		
	}

}
