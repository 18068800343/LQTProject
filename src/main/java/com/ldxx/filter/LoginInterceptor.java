package com.ldxx.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ldxx.bean.User;


public class LoginInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		//String requestUrl = request.getRequestURL().toString();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		if(null==user)
		{
			response.sendRedirect("../login.html");
			return false;
		}
		return true;
	}

	
}
