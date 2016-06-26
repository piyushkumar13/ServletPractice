package com.practice.httpservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HttpSessionViewProfile extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		HttpSession session = request.getSession(false);

		if (session != null) {

			out.println("<b> Name : " + session.getAttribute("name") + "</b> <br/>");
			out.println("<b> Id : " + session.getId() + "</b><br/>");
			out.println("<a href='"+response.encodeURL("/servletpractice/httpsession/logout")+"'>logout </a>");
		}
		else {
			request.getRequestDispatcher("/httpsessionwebresources/login.html").include(request,
					response);

		}

	}

}
