/**
 * 
 */
package com.pst.domain;

/**
 * 
 */
public class Person {

	private ImmuneSystemStatus immuneSystemStatus;
	private CardiovascularStatus cardiovascularStatus;
	private Diagnosis diagnosis;
	private Integer weight;
	private Float height;


	/**
	 * @return the immuneSystemStatus
	 */
	public ImmuneSystemStatus getImmuneSystemStatus() {
		return immuneSystemStatus;
	}

	/**
	 * @param immuneSystemStatus the immuneSystemStatus to set
	 */
	public void setImmuneSystemStatus(ImmuneSystemStatus immuneSystemStatus) {
		this.immuneSystemStatus = immuneSystemStatus;
	}

	/**
	 * @return the cardiovascularStatus
	 */
	public CardiovascularStatus getCardiovascularStatus() {
		return cardiovascularStatus;
	}

	/**
	 * @param cardiovascularStatus the cardiovascularStatus to set
	 */
	public void setCardiovascularStatus(CardiovascularStatus cardiovascularStatus) {
		this.cardiovascularStatus = cardiovascularStatus;
	}

	/**
	 * @return the diagnosis
	 */
	public Diagnosis getDiagnosis() {
		return diagnosis;
	}

	/**
	 * @param diagnosis the diagnosis to set
	 */
	public void setDiagnosis(Diagnosis diagnosis) {
		this.diagnosis = diagnosis;
	}

	/**
	 * @return the weight
	 */
	public Integer getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	/**
	 * @return the height
	 */
	public Float getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(Float height) {
		this.height = height;
	}

}
