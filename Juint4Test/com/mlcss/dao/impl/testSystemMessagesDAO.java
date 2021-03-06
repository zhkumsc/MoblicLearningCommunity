package com.mlcss.dao.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.mlcss.bean.SystemMessages;
import com.mlcss.dao.SystemMessagesDAO;
import com.mlcss.util.DateTimeUtil;

public class testSystemMessagesDAO {

	@Test
	public void testAddMessage() {
		SystemMessagesDAO smd = new SystemMessagesDAOImpl();
		SystemMessages sm = new SystemMessages();
		sm.setReceiverId(1);
		sm.setContent("hello");
		sm.setCreateTime(DateTimeUtil.date2String(new Date()));
		sm.setReceived(true);
		smd.addMessage(sm);
	}
	
	@Test
	public void testDelMessagebyId() {
		SystemMessagesDAO smd = new SystemMessagesDAOImpl();
		smd.delMessageById(1);
	}
	
	@Test
	public void testdelAllMessageByReceiverId() {
		SystemMessagesDAO smd = new SystemMessagesDAOImpl();
		smd.delAllMessageByReceiverId(1);
	}
	
	@Test
	public void testUpdateMessage() {
		SystemMessagesDAO smd = new SystemMessagesDAOImpl();
		SystemMessages sm = new SystemMessages();
		sm.setReceiverId(1);
		sm.setContent("hello world");
		sm.setCreateTime(DateTimeUtil.date2String(new Date()));
		sm.setReceived(false);
		sm.setId(1);
		smd.updateMessage(sm);
		
	}
	
	@Test
	public void testGetAllsystemmessages() {
		SystemMessagesDAO smd = new SystemMessagesDAOImpl();
		List<SystemMessages> list = smd.getAllMessageByReceiverId(1, false);
		for(SystemMessages sm : list) {
			System.out.println(sm.toString());
		}
	}
	
	@Test
	public void testGetMessageById() {
		SystemMessagesDAO smd = new SystemMessagesDAOImpl();
		System.out.println(smd.getMessageById(1));
	}
}
