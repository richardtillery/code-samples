/**
 * 
 */
package com.pst.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Sort;
import org.hibernate.annotations.SortType;



/**
 */
@Entity
@Table(name="RICHDB.PERSON")
public class WebPerson implements Serializable {
	
	private static final long serialVersionUID = 393034679597868269L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column( name="ID", insertable=false, updatable=false )
	@Sort(type=SortType.NATURAL)
	private int id;

	@Column( name="FIRST_NAME")
	private String firstName;

	@Column( name="LAST_NAME")
	private String lastName;
	
	@OneToMany(targetEntity=WebPersonSkills.class, mappedBy="person", fetch=FetchType.EAGER)
	private List<WebPersonSkills> skills;
	
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
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<WebPersonSkills> getSkills() {
		return skills;
	}
	
	public void setSkills(List<WebPersonSkills> skills) {
		this.skills = skills;
	}
	
	@Override
	public String toString() {
		return this.getId() + "|" + this.getFirstName() + "|" + this.getLastName() + "|" + this.getSkills();
	}
	
}
