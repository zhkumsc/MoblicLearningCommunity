package com.mlcss.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.mlcss.bean.UserChatrecords;
import com.mlcss.dao.UserChatrecordsDAO;

public class testUserChatrecordsDAOImpl {
	@Test
	public void testadd(){
		UserChatrecordsDAO chat=new UserChatrecordsDAOImpl();
		UserChatrecords u=new UserChatrecords();
		u.setContent("weqrefagag");
		u.setFriendid(8);
		u.setUserid(9);
		chat.add(u);
	}
	@Test
	public void testdel(){
		UserChatrecordsDAO chat=new UserChatrecordsDAOImpl();
		UserChatrecords u=new UserChatrecords();
		chat.delete(9);
	}
	@Test
	public void testFindById(){
		UserChatrecordsDAO chat=new UserChatrecordsDAOImpl();
		UserChatrecords u=new UserChatrecords();
		List<UserChatrecords> list=new ArrayList<UserChatrecords>();
		list=chat.findById(9, 8);
		System.out.println(list.get(0).getContent());
	}
	@Test
	public void testisread(){
		UserChatrecordsDAO chat=new UserChatrecordsDAOImpl();
		UserChatrecords u=new UserChatrecords();
		u.setId(2);
		chat.isread(u);
		
		
	}

}
