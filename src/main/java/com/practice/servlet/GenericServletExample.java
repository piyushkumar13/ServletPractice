package com.practice.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.GenericServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * This class extends the GenericServlet class which is an adapter class to the
 * Servlet interface and user implemented servlet class. Normally, whenever we
 * want to implement a servlet using Servlet interface, we have to implement the
 * servlet interface and we need to define all the methods of the Servlet
 * interface in the implementing class even if we don't want to use those
 * methods. So, Servlet specification has provided one adapter class which is an
 * adapter to the implementing class and the Servlet class, which provides the
 * facility to not to implement all the methods of the Servlet interface except
 * service() method. This allows the developer to concentrate on writing the
 * core logic for the service() method and dont need to worry about writing the
 * other methods of the Servlet interface.
 * 
 * @author kumarp9
 *
 */
@SuppressWarnings("serial")
public class GenericServletExample extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

		String name = req.getParameter("generic_input_name");
		String password = req.getParameter("generic_input_password");
		System.out.println("The input name is : " + name);
		System.out.println("The password is : " + password);

		System.out.println("The protocol used is : " + req.getProtocol());

		Enumeration<String> initNames = getInitParameterNames();
		ServletContext context = getServletContext();
		Enumeration<String> contextNames = context.getInitParameterNames();

		System.out.println("The initialization parameters of the servlet are : ");
		while (initNames.hasMoreElements()) {
			System.out.println(initNames.nextElement());
		}

		System.out.println("The context parameters of the servlet are : ");
		while (contextNames.hasMoreElements()) {
			System.out.println(contextNames.nextElement());
		}

		res.setContentType("text/html");
		PrintWriter writer = res.getWriter();
		writer.write("<h1><center>This is the generic servlet example</center></h1>");
		writer.write("<h3>The context parameters from servlet request are : </h3>");

		Enumeration<String> reqContextNames = req.getServletContext().getInitParameterNames();
		while (reqContextNames.hasMoreElements()) {
			writer.write("<b>" + reqContextNames.nextElement() + "</b><br/>");
		}

	}

}
