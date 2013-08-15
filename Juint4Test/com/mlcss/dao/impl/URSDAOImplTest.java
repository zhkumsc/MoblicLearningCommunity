package com.mlcss.dao.impl;

import java.sql.Timestamp;
import java.util.List;

import org.junit.Test;

import com.mlcss.bean.UserRelShip;

public class URSDAOImplTest {
	
	UserRelShip urs = new UserRelShip();
	UserRelShipDAOImpl ursdi = new UserRelShipDAOImpl();
	
	@Test
	public void testAdd(){		
		urs.setUserId(10);
		urs.setFriendId(8);
		urs.setGroupId(3);
		urs.setCreateTime(new Timestamp(System.currentTimeMillis()));
		urs.setFriendNote("小王");
		ursdi.add(urs);
	}
	
	@Test
	public void testDelete(){
		ursdi.delete(10,8);
	}
	
	@Test
	public void testUpdate(){
		urs.setId(2);
		urs.setUserId(8);
		urs.setFriendId(10);
		urs.setGroupId(3);
		ursdi.update(urs);
	}
	
	/*@Test
	public void testFriendRename(){
		urs.setId(4);
		urs.setFriendNote("小胖子");
		ursdi.friendRename(urs);
	}*/
	
	@Test
	public void testListAll(){
		List<UserRelShip> list = ursdi.listAll(8);
		for(int i=0;i<list.size();i++){
			urs = list.get(i);
			System.out.println("id="+urs.getId()+" userId="+urs.getUserId()+" friendId="+urs.getFriendId()+" groupId="+urs.getGroupId()+" createTime="+urs.getCreateTime()+" friendNote="+urs.getFriendNote());
		}
	}
}
