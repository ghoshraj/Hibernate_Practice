package Assignment;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class BranchDriver {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Hospital h1 = new Hospital();
		h1.setName("RR");
		h1.setCEO("Rajesh");
		
		Branch2 b1 = new Branch2();
		b1.setName("RR-Marathalli");
		b1.setManager("Deba");
		
		Branch2 b2 = new Branch2();
		b2.setName("RR-Kolkata");
		b2.setManager("Animesh");
		
		Address a1 = new Address();
		a1.setCity("Hugli");
		a1.setLandmark("Near fruit Juice Bar");
		a1.setPincode(952152);
		
		Address a2 = new Address();
		a2.setCity("Bangalore");
		a2.setLandmark("Near KLM Mall");
		a2.setPincode(952152);
		
		Doctor d1 = new Doctor();
		d1.setName("Sandhita");
		d1.setSpecalization("Gynaecology");
		d1.setYOE(3);
		
		Doctor d2 = new Doctor();
		d2.setName("Subha");
		d2.setSpecalization("Surgery");
		d2.setYOE(5);
		
		Doctor d3 = new Doctor();
		d3.setName("Nabanita");
		d3.setSpecalization("Cardiology");
		d3.setYOE(2);
		
		Doctor d4 = new Doctor();
		d1.setName("Rumki");
		d1.setSpecalization("Neurology");
		d1.setYOE(4);
		
		Patient p1 = new Patient();
		p1.setName("Surojit");
		p1.setBg("O+");
		p1.setAge(22);
		p1.setWeight(58);
		
		Patient p2 = new Patient();
		p2.setName("Bibek");
		p2.setBg("O-");
		p2.setAge(25);
		p2.setWeight(78);
		
		Disease di1 = new Disease();
		di1.setName("Heart-Attack");
		di1.setFee(10000000); 
		
		Disease di2 = new Disease();
		di2.setName("Hepatitice C");
		di2.setFee(500000);
		
		Encounter e1 = new Encounter();
		e1.setName("Surojit");
		e1.setAge(22);
		e1.setSymptom("Heart-Attack");
		
		Encounter e2 = new Encounter();
		e2.setName("Bibek");
		e2.setAge(24);
		e2.setSymptom("Hepatitice C");
		
		//Branch2
		b1.setAddress(a2);
		b2.setAddress(a1);
		
		List<Doctor> doctors = new LinkedList<Doctor>();
		doctors.add(d1);
		doctors.add(d2);
		doctors.add(d3);
		doctors.add(d4);
		
		List<Patient>patients = new LinkedList<Patient>();
		patients.add(p1);
		patients.add(p2);
		
		List<Encounter>encounters = new LinkedList<Encounter>();
		encounters.add(e1);
		encounters.add(e2);
		
		List<Disease>diseases = new LinkedList<Disease>();
		diseases.add(di1);
		diseases.add(di2);
		
		List<Branch2>Branch2s = new LinkedList<Branch2>();
		Branch2s.add(b1);
		Branch2s.add(b2);
		
		b1.setDoctors(doctors);
		b2.setDoctors(doctors);
		
		b1.setPatients(patients);
		b2.setPatients(patients);
		
		p1.setE(encounters);
		p2.setE(encounters);
		
		p1.setD(diseases);
		p2.setD(diseases);
		
		di1.setP(patients);
		di2.setP(patients);
		
		h1.setB(Branch2s);
		
		et.begin();
		em.persist(h1);
		em.persist(b1);
		em.persist(b2);
		em.persist(a1);
		em.persist(a2);
		em.persist(d1);
		em.persist(d2);
		em.persist(d3);
		em.persist(d4);
		em.persist(p1);
		em.persist(p2);
		em.persist(di1);
		em.persist(di2);
		em.persist(e1);
		em.persist(e2);
		et.commit();
	}
}
