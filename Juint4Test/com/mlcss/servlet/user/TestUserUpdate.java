package com.mlcss.servlet.user;

import static org.easymock.EasyMock.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mlcss.servlet.user.UserUpdate;

public class TestUserUpdate {

	private UserUpdate servlet;
	private HttpServletRequest mockRequest;
	private HttpServletResponse mockResponse;
	
	@Before
	public void setUp(){
		
		servlet = new UserUpdate();
		
		//创建request和response的Mock
		mockRequest = createMock(HttpServletRequest.class);
		mockResponse = createMock(HttpServletResponse.class);
	}
	
	@After
	public void tearDown(){
		
		//为了验证指定的调用行为确实发生了，要调用verify(mock)进行验证
		verify(mockRequest);
		verify(mockResponse);
	}
	
	/**
	 * 测试doPost()方法
	 * @throws IOException
	 * @throws ServletException
	 */
	@Test
	public void doPost() throws IOException, ServletException{
		
		String JsonString = "{\"userIcon\":\"dsflhhklh\",\"id\":19,\"name\":\"张三\"}";
		
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
