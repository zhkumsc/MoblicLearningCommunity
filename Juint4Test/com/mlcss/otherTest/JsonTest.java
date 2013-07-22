package com.mlcss.otherTest;

import net.sf.json.JSONObject;

import org.junit.Test;

import com.mlcss.bean.User;

public class JsonTest {

	@Test
	public void testBean2Json() {
		User u = new User();
		u.setEmail("abc@abc.com");
		u.setName("张三");
		u.setPassword("123");
		JSONObject jsonUser = JSONObject.fromObject(u);
		System.out.println(jsonUser.toString());
	}
	
	@Test
	public void testJson2Bean() {
		String JsonString = "{\"email\":\"abc@abc.com\",\"id\":0,\"name\":\"张三\"}";
		JSONObject o = JSONObject.fromObject(JsonString);
		User u = (User)JSONObject.toBean(o, User.class);
		System.out.println(u.toString());
	}
	
}
