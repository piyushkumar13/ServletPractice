package com.practice.httpservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpServletExample extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 System.out.println("This is inside get");
		// response.sendRedirect("/servletpractice/index.jsp");

		PrintWriter writer = response.getWriter();
		response.setContentType("text/html");

		String userName = request.getParameter("uname");
		String userPassword = request.getParameter("upassword");

		if (request.getParameter("uname").equals("piyush") && request.getParameter("upassword").equals("kumar")) {
			writer.write("<center><b>You are successfully logged-in.</b></center>");
			writer.write("<a href='/servletpractice/httpservlet/urlrewritting?uname=" + userName
					+ "'>Click to go to your home!</a>");

		} else {
			response.sendRedirect("/servletpractice/loginpage.html");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 System.out.println("This is inside post");
		// response.sendRedirect("/servletpractice/index.jsp");

		PrintWriter writer = response.getWriter();
		response.setContentType("text/html");

		String userName = request.getParameter("uname");
		String userPassword = request.getParameter("upassword");

		if (request.getParameter("uname").equals("piyush") && request.getParameter("upassword").equals("kumar")) {
			writer.write("<center><b>You are successfully logged-in.</b></center>");
			writer.write("<a href='/servletpractice/httpservlet/urlrewritting?uname=" + userName
					+ "'>Click to go to your home!</a>");

		} else {
			response.sendRedirect("/servletpractice/loginpage.html");
		}

	}

}
