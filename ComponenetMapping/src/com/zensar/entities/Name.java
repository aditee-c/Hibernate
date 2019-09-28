package com.zensar.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author Aditee Chourasiya 
 * @creation_date 26-09-19 2.41 PM
 * @modification_date 26-09-19 2.41 PM
 * @copyright All Rights reserved by Zensar Technologies
 * @version 1.0
 * @description It is a Nmae bean class
 */
@Embeddable
public class Name {
	@Column(name = "fname",length = 30)
	private String firstName;
	@Column(name = "mname", length = 10,nullable = false)
	private String middleName;
	@Column(name = "lname",length = 20)
	private String lastName;

	public Name() {
		// TODO Auto-generated constructor stub
	}

	public Name(String firstName, String middleName, String lastName) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Name [firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName + "]";
	}

}
