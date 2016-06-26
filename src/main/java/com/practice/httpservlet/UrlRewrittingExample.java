package com.practice.httpservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UrlRewrittingExample extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter writer = resp.getWriter();
		resp.setContentType("text/html");

		String userName = req.getParameter("uname");

		writer.write("<center>This is <b> " + userName + "</b> home page</center>");
		writer.write("<center><a href='/servletpractice/loginpage.html'>Go back to login page</a></center>");

	}

}
