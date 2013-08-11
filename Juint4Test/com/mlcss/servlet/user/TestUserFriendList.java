package com.mlcss.servlet.user;

import static org.easymock.EasyMock.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestUserFriendList {
	
	private UserFriendList servlet;
	private HttpServletRequest mockRequest;
	private HttpServletResponse mockResponse;

	@Before
	public void setUp() throws Exception {
		
		servlet = new UserFriendList();
		
		mockRequest = createMock(HttpServletRequest.class);
		mockResponse = createMock(HttpServletResponse.class);
	}

	@After
	public void tearDown() throws Exception {
		
		verify(mockRequest);
		verify(mockResponse);
	}

	@Test
	public void testDopost() throws ServletException, IOException {
		String JsonString = "{\"userId\":11}";
		
		//录制request和response的动作
		mockRequest.getParameter("json");
		expectLastCall().andReturn(JsonString);   //设置前一方法被调用时的返回值
		
		//mockResponse.sendRedirect("wel.jsp");
		StringWriter output = new StringWriter();   
        PrintWriter contentWriter = new PrintWriter(output);   
        EasyMock.expect(mockResponse.getWriter()).andReturn(contentWriter);   


		replay(mockRequest);
		replay(mockResponse);
		
		//开始测试servlet的doPost方法
		servlet.doPost(mockRequest, mockResponse);
	}

}
