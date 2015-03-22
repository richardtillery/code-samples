/**
 * 
 */
package com.pst.domain;

/**
 * @author tilleryr
 *
 */
public class Employee extends Person {

	private String employeeIdentifier;
	
	public Employee() {
		super();
	}

	/**
	 * @return the employeeIdentifier
	 */
	public String getEmployeeIdentifier() {
		return employeeIdentifier;
	}

	/**
	 * @param employeeIdentifier the employeeIdentifier to set
	 */
	public void setEmployeeIdentifier(String employeeIdentifier) {
		this.employeeIdentifier = employeeIdentifier;
	}

}
