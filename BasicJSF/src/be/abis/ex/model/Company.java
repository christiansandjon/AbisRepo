package be.abis.ex.model;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class Company implements Serializable{
	
	private String name;
	private String telephoneNumber;
	private VatNumber vatNr;
	@Inject
	private Address address;
	
	
	public Company(){
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTelephoneNumber() {
		return telephoneNumber;
	}
	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}
	public VatNumber getVatNr() {
		return vatNr;
	}
	public void setVatNr(VatNumber vatNr) {
		this.vatNr = vatNr;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	

}
