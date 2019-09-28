package com.zensar.services;

import java.util.List;

import com.zensar.daos.UserDao;
import com.zensar.entities.User;
import com.zensar.exceptions.ServiceException;
/**
 * @author Aditee Chourasiya
 * @version 2.0
 * @creation_date 21st Sep 2019 5.35PM
 * @modification_date 28th Sep 2019 11.47AM
 * @copyright Zensar Technologies. All rights reserved.
 * @description It is used in Business layer of application
 *
 */
public class UserServiceImpl implements UserService {
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void addUser(User user) throws ServiceException {
		userDao.insert(user);
	}

	@Override
	public void UpdateUser(User user) throws ServiceException {
		userDao.update(user);
	}

	@Override
	public void removeUser(User user) throws ServiceException {
		userDao.delete(user);
	}

	@Override
	public User findUserByUsername(String username) throws ServiceException {
		User user = userDao.getByUsername(username);
		return user;
		
	}

	@Override
	public List<User> findAllUsers() throws ServiceException {
		// TODO Auto-generated method stub
		
		return userDao.getAll();
	}

	@Override
	public boolean validateUser(User user) throws ServiceException {
		// TODO Auto-generated method stub
		User dbUser = findUserByUsername(user.getUsername());
		if(dbUser!= null && dbUser.getPassword().equals(user.getPassword()))
			return true;
		else 
			return false;
	}

}
