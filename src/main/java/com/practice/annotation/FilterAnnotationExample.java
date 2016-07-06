package com.practice.annotation;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(filterName = "AnnotatedFilterExample", value = { "/servlet/annotation/*" }, initParams = { @WebInitParam(
		name = "application_name",
		value = "ServletPractice") })
public class FilterAnnotationExample implements Filter {
	private FilterConfig config;

	public void init(FilterConfig filterConfig) throws ServletException {
		config = filterConfig;

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Inside filter ...");
		System.out.println("Preprocessing...");
		String applicationName = config.getInitParameter("application_name");
		System.out.println("The application name is  : " + applicationName);
		chain.doFilter(request, response);
		System.out.println("Post processing...");
	}

	public void destroy() {
		// TODO Auto-generated method stub

	}

}
