package com.Interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class AuthenticationInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("Pre Processing is happening");
		HttpSession hs = request.getSession();
		if (hs.getAttribute("login_status") != null && (Boolean) hs.getAttribute("login_status") == true) {
			return true;
		}
		System.out.println("Redirecting user");
		response.sendRedirect(request.getContextPath() + "/");
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("Post Processing is happening");
		return;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("View is rendered, now available to process to the client");
		return;
	}

}
