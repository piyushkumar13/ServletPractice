package com.practice.httpservlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HttpSessionExample extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher;

		if (request.getParameter("uname").equals("piyush") && request.getParameter("upassword").equals("kumar")) {

			HttpSession session = request.getSession();
			session.setAttribute("name", "Piyush");
			dispatcher = request.getRequestDispatcher("/httpsessionwebresources/home.html");
			dispatcher.include(request, response);
		} else {
			dispatcher = request.getRequestDispatcher("/httpsessionwebresources/login.html");
			dispatcher.forward(request, response);
		}
	}

}
