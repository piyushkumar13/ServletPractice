package com.practice.httpservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HttpSessionProfileExample extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		HttpSession session = request.getSession(false);

		if (session != null) {
			out.println("<h1><center>Welcome " + session.getAttribute("name") + "!!to your profile visit</center></h1>");
			out.println("<a href ='" + response.encodeURL("/servletpractice/httpsession/viewprofile")
					+ "'>view profile</a>");
		}

		else {
			request.getRequestDispatcher("/httpsessionwebresources/login.html").forward(request,
					response);
		}
	}
}
