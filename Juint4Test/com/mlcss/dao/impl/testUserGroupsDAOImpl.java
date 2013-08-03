package com.mlcss.dao.impl;

import org.junit.Test;

import com.mlcss.bean.UserGroups;
import com.mlcss.dao.UserGroupsDAO;

public class testUserGroupsDAOImpl {
	@Test
	public void testadd(){
		UserGroupsDAO group=new UserGroupsDAOImpl();
		UserGroups u=new UserGroups();
		u.setGroupname("wife");
		
		u.setUserid(9);
		group.add(u);
		
	}
	@Test
	public void testdel(){
		UserGroupsDAO group=new UserGroupsDAOImpl();
		UserGroups u=new UserGroups();
		group.delete(1);
	}
	@Test
	public void testupdate(){
		UserGroupsDAO group=new UserGroupsDAOImpl();
		UserGroups u=new UserGroups();
		u.setGroupname("bitch");
		u.setId(2);
		u.setUserid(10);
		group.update(u);
	}
	@Test
	public void testfindbyid(){
		UserGroupsDAO group=new UserGroupsDAOImpl();
		UserGroups u=new UserGroups();
		u=group.findById(3);
		System.out.println(u.getGroupname());
		
	}

}
