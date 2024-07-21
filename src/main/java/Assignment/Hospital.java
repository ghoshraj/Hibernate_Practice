package Assignment;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "hospitalrr")
public class Hospital {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String CEO;
	
	@OneToMany
	private List<Branch2>Branch2s;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCEO() {
		return CEO;
	}

	public void setCEO(String cEO) {
		CEO = cEO;
	}

	public List<Branch2> getB() {
		return Branch2s;
	}

	public void setB(List<Branch2> b) {
		this.Branch2s = b;
	}

}
