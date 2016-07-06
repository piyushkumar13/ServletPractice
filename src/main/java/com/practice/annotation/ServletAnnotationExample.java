package com.practice.annotation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

@WebServlet(
		value = { "/servlet/annotation/example", "/servlet/annotation" },
		name = "AnnotatedServlet",
		description = "This servlet describes how to use servlet annotations",
		initParams = { @WebInitParam(name = "application_name", value = "ServletPractice") })
public class ServletAnnotationExample extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

		res.setContentType("text/html");
		PrintWriter writer = res.getWriter();
		ServletConfig config = getServletConfig();
		String applicationName = config.getInitParameter("application_name");
		writer.println("<b><center> This is the web servlet annotation example.</center></b>");
		writer.write("<center> The application name is <b>" + applicationName + "</b></center>");

	}
}
