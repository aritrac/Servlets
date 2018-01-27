package com.fog.computing.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SessionFilter implements Filter{

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		
		//Print out all session data
//		System.out.println("************************************************");
//		System.out.println("*************Session Data Start*****************");
//		Enumeration keys = request.getSession().getAttributeNames();
//		while(keys.hasMoreElements()){
//			String key = (String)keys.nextElement();
//			System.out.println(key + " : " + request.getSession().getAttribute(key));
//		}
//		System.out.println("*************Session Data End*******************");
//		System.out.println("************************************************");
		if(request.getSession().getAttribute("username") == null){
			System.out.println("TimedOut " + request.getContextPath());
			response.sendRedirect(request.getContextPath());
		}
		chain.doFilter(arg0, arg1);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
}
