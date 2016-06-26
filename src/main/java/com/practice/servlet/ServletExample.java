package com.practice.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * This class implements the servlet interface. This class has to implement all
 * the classes defined in the servlet interface. In this class, I am getting the
 * initialization parameters defined in the web.xml. Here, all the context as
 * well as the servlet specific initialization parameter, I am fetching. To
 * fetch the initialization parameter from the context using method
 * getInitParameter of the ServletContext class and to get the initialization
 * parameter from the servlet configuration using the getInitParameter of the
 * ServletConfig.
 * 
 * @author kumarp9
 *
 */
public class ServletExample implements Servlet {

	private String emailAddress;
	private String authorName;
	private ServletConfig config;

	public void init(ServletConfig config) throws ServletException {

		this.config = config;
		emailAddress = config.getInitParameter("email_address");
		authorName = config.getInitParameter("author_name");
	}

	public ServletConfig getServletConfig() {
		return config;
	}

	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

		res.setContentType("text/html");

		String name = req.getParameter("input_name");
		String password = req.getParameter("input_password");

		ServletContext context = req.getServletContext();

		PrintWriter writer = res.getWriter();
		writer.write("The organisation name is : <b> " + context.getInitParameter("organisation_name") + "</b><br/>");
		writer.write("The database name is : <b> " + context.getInitParameter("db_name") + "</b><br/>");
		writer.write("The database password is : <b> " + context.getInitParameter("db_password") + "</b><br/>");
		writer.write("Author's email address : <b> " + emailAddress + "</b><br/>");
		writer.write("author's name : <b>" + authorName + "</b><br/>");
		writer.write("Your name is : <b>" + name + "</b><br/>");
		writer.write("Your password is : <b> " + password + "</b><br/>");
		writer.write("You are logged in successfully");

		writer.flush();
	}

	public String getServletInfo() {
		return null;
	}

	public void destroy() {

	}

}
