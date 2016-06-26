package com.practice.httpservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddCookiesExample extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		Cookie cookie1 = new Cookie("name", request.getParameter("name"));
		Cookie cookie2 = new Cookie("value", request.getParameter("value"));

		response.addCookie(cookie1);
		response.addCookie(cookie2);
		
		out.println("<center>Cookie added successfully.</center>");
		out.println("<a href = '/servletpractice/httpservlet/viewcookies'>view cookies</a>");
		
	}

}
