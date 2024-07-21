package onetoone;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PersonDriver {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Person p1 = new Person();
		p1.setName("Rajesh");
		p1.setAge(22);

		Person p2 = new Person();
		p2.setName("Animesh");
		p2.setAge(23);

		Person p3 = new Person();
		p3.setName("Deba");
		p3.setAge(25);

		Pan c1 = new Pan();
		c1.setId(1);
		c1.setPanNumber("R123");
		c1.setAddress("Jhargram");

		Pan c2 = new Pan();
		c2.setId(2);
		c2.setPanNumber("A123");
		c2.setAddress("Kolkata");

		Pan c3 = new Pan();
		c3.setId(3);
		c3.setPanNumber("D123");
		c3.setAddress("Assam");

		p1.setPan(c1);
		p2.setPan(c2);
		p3.setPan(c3);

		et.begin();
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		et.commit();

	}
}
