package be.abis.ex.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.Locale;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import be.abis.ex.dao.PersonDao;
import be.abis.ex.model.Person;

@Named("controller")
@SessionScoped
public class HomeController implements Serializable {

	// injects
	@Inject
	Person person;

	@Inject
	@Named("personDaoFile")
	PersonDao personDao;
	
	private String lang="en";

	// getters and setters
	public PersonDao getPersonDao() {
		return personDao;
	}

	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	// login
	public String login() {

		String email = person.getEmailAddress();
		String password = person.getPassword();
		
		Person p = personDao.findPerson(email, password);
		if (p != null) {
			this.person = p;
			return "welcome?faces-redirect=true";
		} else {
			System.out.println("mauvais mauvais ");
			this.addPassWordErrorMessage();
			return "login";
		}
	}

	// session out
	public void invalidate() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	}

	// logout
	public String logout() {
		this.invalidate();

		return "login?faces-redirect=true";
	}

	// register
	public String register() {
		try {
			personDao.addPerson(this.person);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "registerOK?faces-redirect=true";

	}
	
	// change language 
	public String changeLanguage(String value){
		UIViewRoot viewRoot = FacesContext.getCurrentInstance().getViewRoot();
		Locale usedLocale = viewRoot.getLocale();
		viewRoot.setLocale(new Locale(value));
		
		return "login";
	}
	  

	private void addPassWordErrorMessage() {
		String message = "mauvais login ou mot de passe. ressayez encore ";
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage myFacesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
		context.addMessage(null, myFacesMessage);
		System.out.println("methode add mauvais ");
	}

}
