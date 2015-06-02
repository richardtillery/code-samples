/**
 * 
 */
package com.pst.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Sort;
import org.hibernate.annotations.SortType;

/**
 * Person's skills
 */
@Entity
@Table(name="RICHDB.PERSON_SKILLS")
public class WebPersonSkills implements Serializable {
	
	private static final long serialVersionUID = 4054971766857327625L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column( name="ID", insertable=false, updatable=false )
	@Sort(type=SortType.NATURAL)
	private int id;

	@Column( name="PERSON_ID" )
	private int personId;

	@ManyToOne
	@JoinColumn(name="PERSON_ID", insertable=false, updatable=false)
	private WebPerson person;
	
	@Column( name="SKILL_TYPE")
	private String skillType;
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the id
	 */
	public int getPersonId() {
		return personId;
	}
	/**
	 * @param id the id to set
	 */
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	/**
	 * @return the firstName
	 */
	public String getSkillType() {
		return skillType;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setSkillType(String skillType) {
		this.skillType = skillType;
	}

	//public WebPerson getPerson() {
//		return person;
	//}
	
	//public void setPerson(WebPerson person) {
		//this.person = person;
	//}
	
	@Override
	public String toString() {
		return this.getId() + "|" + this.getSkillType() + "|" + this.getPersonId();
	}
	
	
}