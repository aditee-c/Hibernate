package com.zensar.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Aditee Chourasiya
 * @version 2.0
 * @creation_date 21st Sep 2019 5.23PM
 * @modification_date 28th Sep 2019 11.20AM
 * @copyright Zensar Technologies. All rights reserved.
 * @description Java Bean class used to represent database entity.
 * 				it is also used as value object
 * 				it is used in all layers of application 
 *
 */
@Entity
@Table(name = "user_login")
public class User {
	@Id
	private String username;
	private String password;
	
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
