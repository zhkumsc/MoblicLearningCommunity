package com.mlcss.servlet.filter;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter {
	
	private String encoding = "utf-8";

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
System.out.println("EncodingFilter");

		// Post 乱码与 Response 乱码 
		request.setCharacterEncoding(encoding);
		response.setCharacterEncoding(encoding);
		response.setContentType("text/html;charset=" + encoding);	
		chain.doFilter(request, response);
	}

	public void init(FilterConfig arg0) throws ServletException {
		String encoding = arg0.getInitParameter("encoding");
		if(encoding != null) {
			this.encoding = encoding;
		}
	}

}
