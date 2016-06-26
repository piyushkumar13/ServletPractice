package com.practice.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.ServletContext;

/**
 * This is the first dispatcher class which will be called when user submit the form as defined 
 * in the index.jsp.
 * @author kumarp9
 *
 */
public class RequestDispatcherExample1 extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {

		res.setContentType("text/html");
		PrintWriter writer = res.getWriter();
		ServletContext context = getServletContext();
		System.out.println("The organisation name is : "+ context.getInitParameter("organisation_name"));

		req.setAttribute("servlet-name", "dispatcher1");

		RequestDispatcher dispatcher1 = req.getRequestDispatcher("/servlet/dispatcher2");
		dispatcher1.include(req, res);
		writer.println("<b>This is the include response</b>");
		
		System.out.println("The authentication has "+req.getAttribute("authentication"));
		if(req.getAttribute("authentication").equals("failed")){
			req.getRequestDispatcher("/index.jsp").forward(req, res);
			return;
		}
		
		System.out.println("After forward call");
		writer.write("<b>This is called after forward call.</b>");
		
	}
}
