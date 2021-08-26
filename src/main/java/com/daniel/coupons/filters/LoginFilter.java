package com.daniel.coupons.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.daniel.coupons.beans.PostLoginData;
import com.daniel.coupons.logic.CacheController;


@Component
public class LoginFilter implements Filter {

	@Autowired
	private CacheController cacheController;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		String url = httpRequest.getRequestURL().toString();

		if (url.endsWith("/register")) {
			chain.doFilter(httpRequest, response);
			return;
		}
		
		if (url.endsWith("/coupon") && httpRequest.getMethod().equals("GET")) {
			chain.doFilter(httpRequest, response);
			return;
		}

		if (url.endsWith("/login")) {
			chain.doFilter(httpRequest, response);
			return;
		}

		String token = httpRequest.getHeader("Authorization");

		PostLoginData postLoginData = (PostLoginData) cacheController.get(token);
		if (postLoginData != null) {
			request.setAttribute("userData", postLoginData);
			chain.doFilter(request, response);
		}
		else {
			httpResponse.setStatus(401); //Unauthorized
		}
	}
}