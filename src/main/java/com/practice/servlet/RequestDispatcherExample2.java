package com.practice.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/**
 * This is the 2nd dispatcher class which will be executed from the dispatcher 1.
 * We can pass the information from one servlet to another resource by using the 
 * req.setAttribute() and we can fetch this information in the targated resource 
 * by using the req.getAttribute().
 * @author kumarp9
 *
 */
@SuppressWarnings("serial")
public class RequestDispatcherExample2 extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {

		res.setContentType("text/html");
		PrintWriter writer = res.getWriter();
		
		boolean flag = false;
		
		if (req.getAttribute("servlet-name").equals("dispatcher1")) {
			
			System.out.println("Doing the authentication of the request coming from the dispatcher1");
			
			if (req.getParameter("dispatcher1_input_name").equals("piyush") && req.getParameter("dispatcher1_input_password").equals("piyush123")){
				writer.write("<b>Authentication passed in the dispatcher 2</b>");
				req.setAttribute("authentication", "passed");
			}	
			else{
				writer.write("<b>Authentication failed in the dispatcher 2 </b>");
				req.setAttribute("authentication", "failed");
			}
		}

		writer.write("This is in the dispatcher 2");
	}
}
