package be.abis.ex.model;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

@Named
@SessionScoped
public class Address implements Serializable {
	
	private String street; 
	private int nr; 
	private String zipcode;
	private String town;
	
	
	public Address() {
	}

	public Address(String street, int nr, String zipcode, String town) {
		this.street = street;
		this.nr = nr;
		this.zipcode = zipcode;
		this.town = town;
	}



	public String getStreet() {
		return street;
	}



	public void setStreet(String street) {
		this.street = street;
	}



	public int getNr() {
		return nr;
	}



	public void setNr(int nr) {
		this.nr = nr;
	}



	public String getZipcode() {
		return zipcode;
	}



	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}



	public String getTown() {
		return town;
	}



	public void setTown(String town) {
		this.town = town;
	} 
	
	public String toString(){
		return getNr()+" "+getStreet()+" "+getZipcode()+" "+getTown();
	}

	

}
