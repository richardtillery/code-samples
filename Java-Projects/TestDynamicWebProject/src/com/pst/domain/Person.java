/**
 * 
 */
package com.pst.domain;

import java.util.Date;
import java.util.List;

/**
 * A Person
 */
public class Person {

	private String personName;
	private Integer age;
	private Date birthDate;
	private Date hireDate;
	private String favoriteColor;
	private List<String> hobbies;
	/**
	 * @return the personName
	 */
	public String getPersonName() {
		return personName;
	}
	/**
	 * @param personName the personName to set
	 */
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	/**
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(Integer age) {
		this.age = age;
	}
	/**
	 * @return the birthDate
	 */
	public Date getBirthDate() {
		return birthDate;
	}
	/**
	 * @param birthDate the birthDate to set
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	/**
	 * @return the hireDate
	 */
	public Date getHireDate() {
		return hireDate;
	}
	/**
	 * @param hireDate the hireDate to set
	 */
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	/**
	 * @return the favoriteColor
	 */
	public String getFavoriteColor() {
		return favoriteColor;
	}
	/**
	 * @param favoriteColor the favoriteColor to set
	 */
	public void setFavoriteColor(String favoriteColor) {
		this.favoriteColor = favoriteColor;
	}
	/**
	 * @return the hobbies
	 */
	public List<String> getHobbies() {
		return hobbies;
	}
	/**
	 * @param hobbies the hobbies to set
	 */
	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}
	
}
