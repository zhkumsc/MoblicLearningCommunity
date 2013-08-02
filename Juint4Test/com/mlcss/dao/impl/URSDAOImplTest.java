package com.mlcss.dao.impl;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.mlcss.bean.UserRelShip;

public class URSDAOImplTest {
	
	UserRelShip urs = new UserRelShip();
	UserRelShipDAOImpl ursdi = new UserRelShipDAOImpl();
	
	@Test
	public void testAdd(){		
		urs.setUserId(10);
		urs.setFriendId(13);
		urs.setGroupId(1);
		urs.setCreateTime(new Date());
		ursdi.add(urs);
	}
	
	@Test
	public void testDelete(){
		ursdi.delete(2);
	}
	
	@Test
	public void testUpdate(){
		urs.setId(3);
		urs.setUserId(8);
		urs.setFriendId(11);
		urs.setGroupId(2);
		ursdi.update(urs);
	}
	
	@Test
	public void testListAll(){
		List<UserRelShip> list = ursdi.listAll();
		for(int i=0;i<list.size();i++){
			urs = list.get(i);
			System.out.println("id="+urs.getId()+" userId="+urs.getUserId()+" friendId="+urs.getFriendId()+" groupId="+urs.getGroupId()+" createTime="+urs.getCreateTime());
		}
	}
}
