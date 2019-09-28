package com.zensar.daos;

import java.util.List;

import com.zensar.entities.User;

/**
 * @author Aditee Chourasiya
 * @version 2.0
 * @creation_date 21st Sep 2019 5.30PM
 * @modification_date 28th Sep 2019 11.16AM
 * @copyright Zensar Technologies. All rights reserved.
 * @description It is Data Access Object Interface.
 * 				It is used in persistance layer of application
 *
 */
public interface UserDao {
	void insert(User user);
	void update (User user);
	void delete(User user);
	User getByUsername(String username);
	List<User> getAll();
}
