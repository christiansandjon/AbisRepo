package be.abis.ex.dao;

import java.io.IOException;
import java.util.ArrayList;

import be.abis.ex.model.Person;

public interface PersonDao {
	
	    ArrayList<Person> getAllPersons();
	    Person findPerson(String emailAddress, String passWord);
	    void addPerson(Person p) throws IOException;
	    void deletePerson(Person p) throws IOException;
	    void changePassword(Person p, String newPswd) throws IOException;

}
