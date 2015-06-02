package com.pst.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pst.domain.WebPerson;
import com.pst.domain.WebPersonSkills;
import com.pst.service.PersonService;

/**
 * Our app's main controller
 */
@Controller
@RequestMapping("/person")
public class PersonController {

	public static Logger logger = Logger.getLogger("PersonController");
	
	private PersonService service;
	
	@RequestMapping(value={"/personUI"}, method={RequestMethod.GET})
	public ModelAndView returnPersonUI() {
		ModelAndView modalAndView = new ModelAndView("personUI");
		modalAndView.addObject("SpringMVCStoredAttribute", "V");
		return modalAndView;
	}

	@RequestMapping(value={"/fetchPeople"}, method={RequestMethod.GET}, produces={MediaType.APPLICATION_JSON})
	public List<WebPerson> fetchPeople() {
		logger.log(Level.INFO, "[PersonController] [fetchPeople] Begin");

		List<WebPerson> people = getService().fetchPeople();
		logger.log(Level.INFO, "[PersonController] [fetchPeople] People to return: [" + people + "]");
		
		logger.log(Level.INFO, "[PersonController] [fetchPeople] End");
		return people;
	}

	@RequestMapping(value={"/updatePerson"}, method={RequestMethod.POST}, produces={MediaType.APPLICATION_JSON})
	public void updatePerson(@RequestBody WebPerson person) {
		logger.log(Level.INFO, "[PersonController] [updatePerson] Begin");

		getService().updatePerson(person);
		
		logger.log(Level.INFO, "[PersonController] [updatePerson] End");
	}

	@RequestMapping(value={"/addSkill"}, method={RequestMethod.POST}, produces={MediaType.APPLICATION_JSON})
	public void addSkill(@RequestBody WebPersonSkills personSkills) {		
		logger.log(Level.INFO, "[PersonController] [addSkill] Begin [" + personSkills + "]");

		getService().addSkill(personSkills);
		
		logger.log(Level.INFO, "[PersonController] [addSkill] End");
	}

	@RequestMapping(value={"/insertPerson"}, method={RequestMethod.POST}, produces={MediaType.APPLICATION_JSON})
	public void insertPerson(@RequestBody WebPerson person) {
		logger.log(Level.INFO, "[PersonController] [insertPerson] Begin [" + person + "]");
		
		getService().insertPerson(person);
		
		logger.log(Level.INFO, "[PersonController] [insertPerson] End");
	}

	@RequestMapping(value={"/deletePerson/{personId}"}, method={RequestMethod.DELETE}, produces={MediaType.APPLICATION_JSON})
	public void deletePerson(@PathVariable String personId) {
		logger.log(Level.INFO, "[PersonController] [deletePerson] Begin for personId [" + personId + "]");

		WebPerson personToDelete = new WebPerson();
		personToDelete.setId(Integer.parseInt(personId));
		getService().deletePerson(personToDelete);
		
		logger.log(Level.INFO, "[PersonController] [deletePerson] End");
	}

	/**
	 * @return the service
	 */
	public PersonService getService() {
		return service;
	}

	/**
	 * @param service the service to set
	 */
	@Bean
	@Scope(value = "request")
	@Autowired
	public void setService(PersonService service) {
		this.service = service;
	}
	
}
