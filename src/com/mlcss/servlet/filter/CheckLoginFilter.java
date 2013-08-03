package com.mlcss.servlet.filter;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 验证登陆过滤器
 * @author fantasy
 *
 */

public class CheckLoginFilter implements Filter {


	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

System.out.println("CheckLoginFilter");

		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpServletResponse httpResponse = (HttpServletResponse)response;
		//httpSession获取session
		HttpSession session = httpRequest.getSession(false);
		if(session == null) {
			session = httpRequest.getSession();
		}
		
		String state = (String) session.getAttribute("logState");
		if(state != null && state.equals("1")) {
			chain.doFilter(request, response);
			return;
		}
		
		httpResponse.setStatus(401);
		httpResponse.getWriter().print("未登录");
		
		
	}
	


	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
