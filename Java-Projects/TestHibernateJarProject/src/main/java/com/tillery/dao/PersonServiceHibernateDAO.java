/**
 * 
 */
package com.tillery.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.tillery.model.Person;

/**
 * @author bond
 *
 */
public class PersonServiceHibernateDAO {
	
	public void addPerson(int id, String firstName, String lastName) {

		Query query = null;
		Session session = null;
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		
		try {
            // Create the SessionFactory from hibernate.cfg.xml
			Configuration configuration = new Configuration();
		    configuration.configure("hibernate.cfg.xml");
		    
		    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
		            configuration.getProperties()).build();
		    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		    
            session = sessionFactory.getCurrentSession();
            transaction = session.getTransaction();
            transaction.begin();
            Person person = new Person();
            person.setId(id);
            person.setFirstName(firstName);
            person.setLastName(lastName);
            session.persist(person);
            //session.createSQLQuery("insert into richdb.person (id, firstname, lastname) values (" + id + ", \"" + firstName + "\", \"" + lastName).executeUpdate()
            transaction.commit();
            sessionFactory.close();
        }
        catch (Throwable ex) {
            ex.printStackTrace();
        }
		

	}
	
	public List<Person> fetchAllPersons() {
		List<Person> people = new ArrayList<Person>();
		Query query = null;
		Session session = null;
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		
		try {
            // Create the SessionFactory from hibernate.cfg.xml
			Configuration configuration = new Configuration();
		    configuration.configure("hibernate.cfg.xml");
		    
		    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
		            configuration.getProperties()).build();
		    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		    
            session = sessionFactory.getCurrentSession();
            transaction = session.getTransaction();
            transaction.begin();
            //query = session.getNamedQuery("fetchAllPeople");
            //people = query.list();
            people = session.createQuery("from Person").list();
            people.get(0).setFirstName("NewFirstName1");
            transaction.commit();
            sessionFactory.close();
        }
        catch (Throwable ex) {
            ex.printStackTrace();
        }
		
		return people;
	}

}
