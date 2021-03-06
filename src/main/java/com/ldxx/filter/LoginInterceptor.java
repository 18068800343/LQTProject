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

		String requestUrl = request.getRequestURL().toString();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (null == user && (request.getRequestURI().equals("/view/WEB/index") || (request.getRequestURI().equals("/view/WEB/index.html"))) && !requestUrl.endsWith("userlogin")) {
			response.sendRedirect("/view/WEB/login.html");
			return false;
		}
		if (null == user && !requestUrl.endsWith("userlogin")) {

			response.setHeader("loginStatus", "false");
			response.sendRedirect("/view/WEB/login.html");
			return false;
		}
		return true;
	}

	
}
