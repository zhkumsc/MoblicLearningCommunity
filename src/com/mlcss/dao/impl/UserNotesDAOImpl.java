package com.mlcss.dao.impl;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


import com.mlcss.bean.UserNotes;
import com.mlcss.dao.UserNotesDAO;
import com.mlcss.util.DBUtil;

public class UserNotesDAOImpl implements UserNotesDAO{
	private Connection conn=null;
	private	PreparedStatement ps=null;
	private ResultSet rs=null;

	public boolean add(UserNotes notes) {
		boolean b=false;
		try{
			//得到链接
			 
			conn=DBUtil.getConnection();
			String sql="insert into usernotes(userId,title,content,createTime) values(?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, notes.getUserid());
			ps.setString(2, notes.getTitle());
			ps.setString(3, notes.getContent());
			ps.setTimestamp(4,  new Timestamp(System.currentTimeMillis()));
			int num=ps.executeUpdate();
			if(num==1){ 
				System.out.println("添加成功");
				//添加成功！
				b=true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.close();
		}
		return b;
	}

	public boolean delete(int id) {
		boolean b=false;
		try{
			//得到链接
			conn=DBUtil.getConnection();
			String sql="delete from usernotes where id="+id;
			ps=conn.prepareStatement(sql);
			int num=ps.executeUpdate();
			if(num==1){
				//删除成功！
				b=true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.close();
		}
		return b;
	}

	public boolean update(UserNotes notes) {
		boolean b=false;
		try{
			//得到链接
			conn=DBUtil.getConnection();
			String sql="update usernotes set content='"+notes.getContent()+"' where id="+notes.getId();
			ps=conn.prepareStatement(sql);
			int num=ps.executeUpdate();
			if(num==1){ 
				//修改成功！
				b=true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.close();
		}
		return b;
	}

	public UserNotes findById(int id) {
		UserNotes k=new UserNotes();
		try{
			//得到链接
			conn=DBUtil.getConnection();
			String sql="select * from usernotes where id="+id;
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			rs.next();
			k.setContent(rs.getString(4));
			k.setCreattime(rs.getTimestamp(5));
			k.setId(rs.getInt(1));
			k.setIsshared(rs.getBoolean(6));
			k.setTitle(rs.getString(3));
			k.setUserid(rs.getInt(2));
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.close();
		}
		return k;
	}

	public List<UserNotes> findByUserId(int userid) {
		List<UserNotes> list=new ArrayList<UserNotes>();
		try{
			//得到链接
			conn=DBUtil.getConnection();
			String sql="select * from usernotes where userId="+userid;
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				UserNotes k=new UserNotes();
			k.setContent(rs.getString(4));
			k.setCreattime(rs.getTimestamp(5));
			k.setId(rs.getInt(1));
			k.setIsshared(rs.getBoolean(6));
			k.setTitle(rs.getString(3));
			k.setUserid(rs.getInt(2));
			list.add(k);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.close();
		}
		return list;
	}
	private void close() {
		try{
			if(rs!=null){
			   rs.close();
			   rs=null;
			}
			if(ps!=null){
	           ps.close();
	           rs=null;
			}
			if(conn!=null){
	           conn.close();
	           rs=null;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
//设置分享
	public boolean share(UserNotes notes) {
		boolean b=false;
		try{
			
			//得到链接
		
			conn=DBUtil.getConnection();
			String sql="update usernotes set isshared=? where id="+notes.getId();
			ps=conn.prepareStatement(sql);
			ps.setBoolean (1, true);
			int num=ps.executeUpdate();
			if(num==1){ 
				//修改成功！
				b=true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.close();
		}
		return b;	}
//设置不分享
	public boolean unshare(UserNotes notes) {
		boolean b=false;
		try{
			
			//得到链接
			
			conn=DBUtil.getConnection();
			String sql="update usernotes set isshared=? where id="+notes.getId();
			ps=conn.prepareStatement(sql);
			ps.setBoolean(1, false);
			int num=ps.executeUpdate();
			if(num==1){ 
				//修改成功！
				b=true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.close();
		}
		return b;
	}

	
	}


