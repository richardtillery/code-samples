package com.tillery.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;

import com.tillery.dao.PersonServiceClassicJDBCDAO;
import com.tillery.dao.PersonServiceHibernateDAO;
import com.tillery.model.Person;

public class FetchPersonsTester {

	@Test
	public void fetchAllTest() {

		List<Person> people = null;
		try {
			PersonServiceHibernateDAO personServiceDAO = new PersonServiceHibernateDAO();
			people = personServiceDAO.fetchAllPersons();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Fetched people [" + people + "]");
		assertNotNull(people);
	}
	
	@Test
	public void dangerousSQLInjectionTest() {

		try {			
			PersonServiceClassicJDBCDAO personServiceDAO = new PersonServiceClassicJDBCDAO();
			personServiceDAO.addPerson(10, "FirstName", "\"); DROP TABLE richdb.person; -- ");
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		List<Person> people = null;
		try {
			PersonServiceHibernateDAO personServiceDAO = new PersonServiceHibernateDAO();
			people = personServiceDAO.fetchAllPersons();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Fetched people [" + people + "]");
		assertNull(people);
	}


}
