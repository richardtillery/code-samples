/**
 * 
 */
package com.pst.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.pst.domain.WebPerson;
import com.pst.domain.WebPersonSkills;

/**
 * Spring bean - DAO for WebPerson operations
 */
@Component
public class PersonService {

	public static Logger logger = Logger.getLogger("PersonService");

	/**
	 * fetch all people
	 * @return List of People or empty List
	 */
	public List<WebPerson> fetchPeople() {

		List<WebPerson> people = new ArrayList<>();
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Criteria criteria = session.createCriteria(WebPerson.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			people = (List<WebPerson>) criteria.list(); 
			session.getTransaction().commit();
		} catch(Exception e) {
			logger.log(Level.SEVERE, "Unhandled exception ", e);
		}

		return people;
	}
	
	public List<WebPersonSkills> fetchPeopleSkills() {

		List<WebPersonSkills> peopleSkills = new ArrayList<>();
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			peopleSkills = (List<WebPersonSkills>) session.createCriteria(WebPersonSkills.class).list();
			session.getTransaction().commit();
		} catch(Exception e) {
			logger.log(Level.SEVERE, "Unhandled exception ", e);
		}

		return peopleSkills;
	}

	/**
	 * Insert a WebPerson 
	 * @param personToInsert a whole new person object
	 * @return boolean success indicator
	 */
	public boolean addSkill(WebPersonSkills personSkills) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {			
			session.beginTransaction();
			session.persist(personSkills);
			session.getTransaction().commit();
		} catch(Exception e) {
			logger.log(Level.SEVERE, "Unhandled exception ", e);
			return false;
		}
		return true;
	}



	/**
	 * Insert a WebPerson 
	 * @param personToInsert a whole new person object
	 * @return boolean success indicator
	 */
	public boolean insertPerson(WebPerson personToInsert) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {			
			session.beginTransaction();
			session.persist(personToInsert);
			session.getTransaction().commit();
		} catch(Exception e) {
			logger.log(Level.SEVERE, "Unhandled exception ", e);
			return false;
		}
		return true;
	}

	/**
	 * Update a WebPerson 
	 * @param personToUpdate assumed to be a detached entity
	 * @return boolean success indicator
	 */
	public boolean updatePerson(WebPerson personToUpdate) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {			
			session.beginTransaction();
			session.update(personToUpdate);
			session.getTransaction().commit();
		} catch(Exception e) {
			logger.log(Level.SEVERE, "Unhandled exception ", e);
			return false;
		}
		return true;
	}

	/**
	 * Delete a WebPerson
	 * @param personToUpdate assumed to be a detached entity
	 * @return boolean success indicator
	 */
	public boolean deletePerson(WebPerson personToDelete) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {			
			session.beginTransaction();
			session.delete(personToDelete);
			session.getTransaction().commit();
		} catch(Exception e) {
			logger.log(Level.SEVERE, "Unhandled exception ", e);
			return false;
		}
		logger.log(Level.INFO, "Is Active [" + session.isOpen() + "]");
		return true;
	}
}
