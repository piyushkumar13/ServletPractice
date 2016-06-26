package com.practice.httpservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewCookiesExample extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		Cookie[] cookies = request.getCookies();

		System.out.println(cookies.length);
		for (int i = 0, j = 1; i < cookies.length; i++) {

			out.println("<table><tr><td>Value of cookie [" + j + "]: </td><td>" + cookies[i].getValue()
					+ " </td></tr></table>");

			cookies[i].setMaxAge(0);// Here, setting the max age of cookie to
									// zero to delete the cookies in the
									// browser.
			response.addCookie(cookies[i]);// Deletion of the cookie is
											// completed by setting the cookie
											// with maxAge=0 in the response.
			j++;
		}

		out.println("<a href= '/servletpractice/AddCookies.html'>Click here to go back to add cookies page</a>");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
