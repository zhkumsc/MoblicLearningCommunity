package com.mlcss.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.mlcss.bean.User;
import com.mlcss.bean.UserNotes;
import com.mlcss.dao.UserDAO;
import com.mlcss.dao.UserNotesDAO;
import com.mlcss.util.DBUtil;

public class testUserNotesDAOImpl {
	
	@Test
	public void testAdd(){
		UserNotesDAO notes=new UserNotesDAOImpl();
		UserNotes u=new UserNotes();
		u.setContent("adfjal");
		u.setTitle("sss");
		u.setUserid(8);
		notes.add(u);
		List<UserNotes> k=new ArrayList<UserNotes>();
		
		u=notes.findById(2);
		u.getContent();
	}
	@Test
	public void testFindbyid(){
		UserNotesDAO notes=new UserNotesDAOImpl();
		UserNotes u=new UserNotes();
		u=notes.findById(2);
		if(u.isIsshared()){
		System.out.println("fuck");
		}
	}
	@Test
	public void testFindbyUserid(){
		UserNotesDAO notes=new UserNotesDAOImpl();
		UserNotes u=new UserNotes();
		List<UserNotes> k=new ArrayList<UserNotes>();
		k=notes.findByUserId(8);
		System.out.println(k.get(0).getContent());
	}
	@Test
	public void testUpdate(){
		UserNotesDAO notes=new UserNotesDAOImpl();
		UserNotes u=new UserNotes();
		u.setContent("a");
		u.setId(2);
		notes.update(u);
	}
	@Test
	public void testshare(){
		UserNotesDAO notes=new UserNotesDAOImpl();
		UserNotes u=new UserNotes();
		u.setId(3);
		notes.share(u);

	}
	@Test
	public void testdel(){
		UserNotesDAO notes=new UserNotesDAOImpl();
		notes.delete(2);
		
		
	}
	
	}




