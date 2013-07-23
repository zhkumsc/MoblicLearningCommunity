package com.mlcss.dao.impl;

import java.util.List;

import org.junit.Test;

import com.mlcss.bean.User;
import com.mlcss.dao.UserDAO;

public class TestUserDAOImpl {
	
	@Test
	public void testAdd(){
		UserDAO userDAO = new UserDAOImpl();
		User u = new User();
		u.setName("ming");
		u.setPassword("111111");
		u.setEmail("12323@qq.com");
		userDAO.add(u);
	}
	
	@Test
	public void testUpdate(){
		UserDAO userDAO = new UserDAOImpl();
		User u = new User();
		u.setId(2);
		u.setName("ming");
		u.setPassword("111111");
		u.setEmail("34353@qq.com");
		userDAO.update(u);
	}
	
	@Test
	public void testDelete(){
		UserDAO userDAO = new UserDAOImpl();
		userDAO.delete(3);
	}
	
	@Test
	public void testListAll(){
		
		UserDAO userDAO = new UserDAOImpl();
		@SuppressWarnings("rawtypes")
		List list = userDAO.listAll();
		for(int i=0;i<list.size();i++){
			User u=(User)list.get(i);
			System.out.println("id=" + u.getId() + " name=" + u.getName() + " password=" + u.getPassword() + " enmail=" + u.getEmail());
		}
	}
	
	@Test
	public void testFindByEmail(){
		
		UserDAOImpl udi = new UserDAOImpl();
		User u = udi.findByEmail("12323@qq.com");
		System.out.println("id=" + u.getId() + " name=" + u.getName() + " password=" + u.getPassword() + " enmail=" + u.getEmail());
	}
}
