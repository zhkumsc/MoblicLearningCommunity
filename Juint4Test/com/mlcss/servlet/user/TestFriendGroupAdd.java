package com.mlcss.servlet.user;

import static org.easymock.EasyMock.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestFriendGroupAdd {

	private FriendGroupAdd servlet;
	private HttpServletRequest mockRequest;
	private HttpServletResponse mockResponse;
	
	@Before
	public void setUp() throws Exception {
        servlet = new FriendGroupAdd();
		
		mockRequest = createMock(HttpServletRequest.class);
		mockResponse = createMock(HttpServletResponse.class);
	}

	@After
	public void tearDown() throws Exception {
		verify(mockRequest);
		verify(mockResponse);
	}

	@Test
	public void test() throws ServletException, IOException {
        String JsonString = "{\"userid\":8,\"groupname\":\"同学\"}";
		
		//录制request和response的动作
		mockRequest.getParameter("json");
		expectLastCall().andReturn(JsonString);   //设置前一方法被调用时的返回值
		
		//mockResponse.sendRedirect("wel.jsp");
		
		replay(mockRequest);
		replay(mockResponse);
		
		//开始测试servlet的doPost方法
		servlet.doPost(mockRequest, mockResponse);
	}

}
