/**
 * 
 */
package com.pst.servlet;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import com.pst.domain.Person;

/**
 * Base Servlet for JMesa Items
 */
public abstract class JmesaBaseServlet extends HttpServlet {

	private static final long serialVersionUID = -2386424815309593682L;

	public void createAndStorePersonList(HttpServletRequest request) {
		
		//set up people list
		List<Person> personList = new ArrayList<Person>();
		
		Person newPerson = new Person();
		newPerson.setAge(20);
		newPerson.setPersonName("Developer 1");
		newPerson.setFavoriteColor("blue");
		Calendar birthDate = Calendar.getInstance();
		birthDate.set(1995, 0, 1);
		newPerson.setBirthDate(birthDate.getTime());
		Calendar hireDate = Calendar.getInstance();
		hireDate.add(Calendar.DATE, -5);
		newPerson.setHireDate(hireDate.getTime());
		List<String> hobbies = new ArrayList<String>();
		hobbies.add("video games");
		hobbies.add("movies");
		newPerson.setHobbies(hobbies);
		personList.add(newPerson);

		Person newPerson1 = new Person();
		newPerson1.setAge(30);
		newPerson1.setPersonName("Developer 2");
		newPerson1.setFavoriteColor("red");
		Calendar birthDate1 = Calendar.getInstance();
		birthDate1.set(1985, 0, 1);
		newPerson1.setBirthDate(birthDate1.getTime());
		newPerson1.setHireDate(Calendar.getInstance().getTime());
		List<String> hobbies1 = new ArrayList<String>();
		hobbies1.add("development");
		hobbies1.add("golf");
		hobbies1.add("stock market gambling");
		newPerson1.setHobbies(hobbies1);
		personList.add(newPerson1);

		request.getSession().setAttribute("personList", personList);
	}
}
