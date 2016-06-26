package com.practice.httpservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HttpSessionLogout extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		HttpSession session = request.getSession(false);

		if (session != null) {
			session.invalidate();
			out.println("<b> <center> You are successfully logged out. </center> <b>");

		} else {
			request.getRequestDispatcher("/servletcontext/httpsessionwebresources/login.html").include(request,
					response);
		}
	}

}
