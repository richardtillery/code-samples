/**
 * 
 */
package com.tillery.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



/**
 * 
 * richdb.person
 * @author bond
 *
 */
@Entity
@Table(name="person", schema="richdb")
public class Person {
	
	@Column( name="firstname", length=50)
	private String firstName;
	@Column( name="lastname", length=50)
	private String lastName;
	@Id private int id;
	
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Override
	public String toString() {
		return this.id + " " + this.firstName + " " + this.lastName;
	}
	

}
