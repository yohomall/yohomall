package com.yohomall.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yohomall.pojo.User;

public class AuthorityFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request =(HttpServletRequest) req; 
		HttpServletResponse response =(HttpServletResponse) resp;
		
		User user = (User) request.getSession().getAttribute("user");
		if (user==null) {
			request.setAttribute("msg", "���ȵ�½!");
			request.getRequestDispatcher("/jsp/msg.jsp").forward(request, response);
		}
		//����
		chain.doFilter(request, response);
		
	}

	@Override
	public void destroy() {
		
	}

}
