package com.zensar.entities;

import java.sql.Blob;
import java.sql.Clob;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.Nullable;

/**
 * @author Aditee Chourasiya
 * @creation_date 26-09-19 2.48 PM
 * @modification_date 26-09-19 2.48 PM
 * @copyright All Rights reserved by Zensar Technologies
 * @version 1.0
 * @description It is a Customer bean class
 */
@Entity
@Table(name = "customer")
public class Customer {
	@Id
	@Column(name = "cId")
	private int customerId;
	private Name customerName;
	@Column(length = 10)
	private String gender;
	private int age;

	@Column(length = 40, nullable = false)
	private String address;
	private LocalDate birthDate;
	private Blob profilePhoto; // for photos an video
	private Clob description;
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(int customerId, Name customerName, String gender, int age, String address) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.gender = gender;
		this.age = age;
		this.address = address;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public Name getCustomerName() {
		return customerName;
	}

	public void setCustomerName(Name customerName) {
		this.customerName = customerName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public Blob getProfilePhoto() {
		return profilePhoto;
	}

	public void setProfilePhoto(Blob profilePhoto) {
		this.profilePhoto = profilePhoto;
	}

	public Clob getDescription() {
		return description;
	}

	public void setDescription(Clob description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", gender=" + gender + ", age="
				+ age + ", address=" + address + "]";
	}

}
