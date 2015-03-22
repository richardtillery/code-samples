package com.pst.service;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.pst.domain.WebPerson;
import com.pst.domain.WebPersonSkills;

/**
 * JUnit 
 */
public class TestPersonService {

	PersonService personService;
	
	@Before
	public void setup() {
		personService = new PersonService();
	}
	
	@Test
	public void sillyIntegerTesting() {
		System.out.println("[" + (8 << 6) + "|" + (8 << 5) + "|" + (8 << 2) + "]");
		System.out.println("[" + ((8 << 6) + (8 << 5) + (8 << 2)) + "]");
	}
	
	@Test
	public void testFetchPeople() {
		List<WebPerson> people = (List<WebPerson>) personService.fetchPeople();		
		System.out.println("TestPersonService [testFetchPeople] : " + people);
	}

	@Test
	public void testFetchPeopleSkills() {
		List<WebPersonSkills> people = (List<WebPersonSkills>) personService.fetchPeopleSkills();		
		System.out.println("TestPersonService [testFetchPeopleSkills] : " + people);
	}

	/*
	@Test
	public void testDeleteAllPeople() {
		List<WebPerson> people = (List<WebPerson>) personService.fetchPeople();
		for(WebPerson person : people) {
			personService.deletePerson(person);
		}		
	}
	
	@Test
	public void testDeletePerson() {
		for(int i = 1; i < 1001; i++) {
			WebPerson personToDelete = new WebPerson();
			personToDelete.setFirstName("FIRST" + 1);
			personToDelete.setLastName("LAST" + 1);
			personService.deletePerson(personToDelete);
		}
	}

	@Test
	public void testInsertManyPeople() throws InterruptedException {
		for(int i = 1; i < 101; i++) {
			Thread.sleep(5000);
			WebPerson newPerson = new WebPerson();
			newPerson.setFirstName("FIRST" + i);
			newPerson.setLastName("LAST" + i);
			personService.insertPerson(newPerson);			
		}
	}

	@Test
	public void testUpdatePerson() {
		WebPerson personToUpdate = new WebPerson();
		personToUpdate.setId(3);
		personToUpdate.setFirstName("FIRST" + String.valueOf(Math.random()).substring(2,5));
		personToUpdate.setLastName("LAST" + String.valueOf(Math.random()).substring(2,5));

		personService.updatePerson(personToUpdate);
	}*/

}
