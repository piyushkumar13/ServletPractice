package com.practice.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class FilterExample implements Filter {

	private FilterConfig config;

	public void init(FilterConfig filterConfig) throws ServletException {
		this.config = filterConfig;

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		if (request instanceof HttpServletRequest && response instanceof HttpServletRequest) {
			System.out.println("Request and response is of http type.");
		}

		String filterToken = config.getInitParameter("filter-token");

		if (filterToken.equals("YES")) {
			System.out.println("Filtering the http request and response.");
		}
		System.out.println("Making the chaining calls.");

		chain.doFilter(request, response);

		System.out.println("Post processing....");

	}

	public void destroy() {

	}

}
