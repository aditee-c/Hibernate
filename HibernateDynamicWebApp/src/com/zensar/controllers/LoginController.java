package com.zensar.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zensar.daos.UserDao;
import com.zensar.daos.UserDaoImpl;
import com.zensar.entities.User;
import com.zensar.exceptions.ServiceException;
import com.zensar.services.UserService;
import com.zensar.services.UserServiceImpl;
/**
 * @author Aditee Chourasiya
 * @version 2.0
 * @creation_date 21st Sep 2019 5.35PM
 * @modification_date 28th Sep 2019 11.47AM
 * @copyright Zensar Technologies. All rights reserved.
 * @description It is Controller Class
 *
 */
/**
 * Servlet implementation class LoginController
 */
@WebServlet("/checkusers")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//call business layer component
		private UserService userService;
		
		public void setUserService(UserService userService) {
			this.userService = userService;
		}
		@Override
		public void init() throws ServletException {
			// TODO Auto-generated method stub
			UserDao u = new UserDaoImpl();
			UserService us = new UserServiceImpl();
			((UserServiceImpl) us).setUserDao(u);
			setUserService(us);
		}
		
				/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			String username = request.getParameter("username");
			String password = request.getParameter("passwd");
			User clientUser = new User();
			clientUser.setUsername(username);
			clientUser.setPassword(password);
			PrintWriter out = response.getWriter() ;
			try {
				if(userService.validateUser(clientUser)) {
					//out.println("<p>Dear "+ username+" Welcome to Online Shopping</p>");
					RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
					rd.forward(request, response);
				}else {
					out.println("<p>Sorry! Invalid UserName or Password</p>");
					RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
					rd.include(request, response);
				}
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			doGet(request, response);
		}

	}
