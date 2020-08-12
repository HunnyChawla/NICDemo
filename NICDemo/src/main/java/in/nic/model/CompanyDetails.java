package in.nic.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CompanyDetails {
	@Id
	private int id;
	private String name;
	private String cin;
	private String city;
	private String postalcode;
	
	public CompanyDetails() {
		super();
	}

	public CompanyDetails(int id, String name, String cin, String city, String postalcode) {
		super();
		this.id = id;
		this.name = name;
		this.cin = cin;
		this.city = city;
		this.postalcode = postalcode;
	}

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

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	@Override
	public String toString() {
		return "CompanyDetails [id=" + id + ", name=" + name + ", cin=" + cin + ", city=" + city + ", postalcode="
				+ postalcode + "]";
	}
	
}
