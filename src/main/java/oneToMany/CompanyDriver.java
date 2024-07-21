package oneToMany;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CompanyDriver {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Company c1 = new Company();
		c1.setName("RR");
		c1.setCeo("Rajesh");
		
		Employee e1 = new Employee();
		e1.setName("Arnab");
		e1.setRoll("cleaner");
		
		Employee e2 = new Employee();
		e2.setName("Bipul");
		e2.setRoll("Manager");
		
		Employee e3 = new Employee();
		e3.setName("Sandhita");
		e3.setRoll("hr");
		
		List<Employee> emp1 = new ArrayList<Employee>();
		emp1.add(e1);
		emp1.add(e2);
		emp1.add(e3);
		
		c1.setEmp(emp1);
		
		et.begin();
	    em.persist(c1);
	    em.persist(e1);
	    em.persist(e2);
	    em.persist(e3);
	    et.commit();
	}
}
