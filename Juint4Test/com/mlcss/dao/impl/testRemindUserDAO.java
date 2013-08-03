package com.mlcss.dao.impl;

import java.sql.Timestamp;
import java.util.List;

import org.junit.Test;

import com.mlcss.bean.RemindUser;
import com.mlcss.bean.SystemMessages;
import com.mlcss.dao.RemindUserDAO;
import com.mlcss.dao.impl.SystemMessagesDAOImpl;

public class testRemindUserDAO {

	@Test
	public void testAddRemind() {
		RemindUserDAO rud = new RemindUserDAOImpl();
		RemindUser ru = new RemindUser();
		ru.setReceiverId(1);
		ru.setContent("提醒!");
		ru.setCreateTime(new Timestamp(System.currentTimeMillis()));
		ru.setIdentifying((byte)0);
		ru.setReceived(false);
		rud.addRemind(ru);
	}
	
	@Test
	public void testDelRemindById() {
		RemindUserDAO rud = new RemindUserDAOImpl();
		rud.delRemindById(1);
	}
	
	@Test
	public void testdelAllRemindByReceiverId() {
		RemindUserDAO rud = new RemindUserDAOImpl();
		rud.delAllRemindReceiverId(1);
	}
	
	@Test
	public void testUpdateRemind() {
		RemindUserDAO rud = new RemindUserDAOImpl();
		RemindUser ru = new RemindUser();
		ru.setId(10);
		ru.setReceiverId(2);
		ru.setContent("提醒2!");
		ru.setCreateTime(new Timestamp(System.currentTimeMillis()));
		ru.setIdentifying((byte)1);
		ru.setReceived(true);
		rud.updateRemind(ru);
		
	}
	
	@Test
	public void testGetAllRemindByReceiverId() {
		RemindUserDAO rud = new RemindUserDAOImpl();
		List<RemindUser> list = rud.getAllRemindByReceiverId(1);
		for(RemindUser ru : list) {
			System.out.println(ru.toString());
		}
	}
	
	@Test
	public void testGetRemindById() {
		RemindUserDAO rud = new RemindUserDAOImpl();
		System.out.println(rud.getRemindById(6));
	}
}
