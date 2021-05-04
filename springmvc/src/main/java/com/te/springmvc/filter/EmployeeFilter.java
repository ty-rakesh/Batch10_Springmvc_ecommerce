package com.te.springmvc.filter;

import java.io.IOException;


import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class EmployeeFilter implements Filter {

	@Override
	public void destroy() {		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest) request;
		
		System.out.println("The url is : "+req.getRequestURL());
		System.out.println("The url is : "+req.getRequestURI());
		System.out.println("Method is : "+req.getMethod());
		
		chain.doFilter(request, response);		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
