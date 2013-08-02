package com.mlcss.dao.impl;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.mlcss.bean.User;

public class UserDAOImplTest {

	@Test
	public void testAdd(){
		User u = new User();
		u.setName("tom");
		u.setPassword("123");
		u.setEmail("jkr343j@qq.com");
		u.setUserIcon("qewrddijkj");
		u.setCreateTime(new Date());
		UserDAOImpl udi = new UserDAOImpl();
		udi.add(u);
	}
	
	@Test
	public void testDelete(){
		UserDAOImpl udi = new UserDAOImpl();
		udi.delete(12);
	}
	
	@Test
	public void testUpdate(){
		User u = new User();
		u.setId(11);
		u.setName("jhon");
		u.setPassword("111");
		u.setEmail("jdjf@qq.com");
		u.setUserIcon("djfjdsjfjd");
		UserDAOImpl udi = new UserDAOImpl();
		udi.update(u);
	}
	
	@Test
	public void testFindById(){
		UserDAOImpl udi = new UserDAOImpl();
		User u = udi.findById(10);
		System.out.println(u.getId()+u.getName()+u.getPassword()+u.getEmail()+u.getCreateTime());
	}
	
	@Test
	public void testListAll(){
		UserDAOImpl udi = new UserDAOImpl();
		List<User> list = udi.listAll();
		for(int i=0;i<list.size();i++){
			User u = list.get(i);
			System.out.println(u.getId()+u.getName()+u.getPassword()+u.getEmail()+u.getCreateTime());
		}
	}
	
	@Test
	public void testFindByEmail(){
		UserDAOImpl udi = new UserDAOImpl();
		User u = udi.findByEmail("12323@qq.com");
		System.out.println(u.getId()+u.getName()+u.getPassword()+u.getEmail()+u.getCreateTime());
	}
}
