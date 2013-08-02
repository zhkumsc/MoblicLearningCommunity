package com.mlcss.dao.impl;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mlcss.bean.UserRemarks;
import com.mlcss.dao.UserRemarksDAO;
import com.mlcss.util.DBUtil;

public class UserRemarksDAOImpl implements UserRemarksDAO {
	
	private Connection conn=null;
	private	PreparedStatement ps=null;
	private ResultSet rs=null;

	public boolean add(UserRemarks ur) {
		boolean b=false;
		Date date1 = new java.sql.Date(ur.getCreateTime().getTime());
		Date date2 = new java.sql.Date(ur.getRemindTime().getTime());
		try{
			//得到链接
			conn=DBUtil.getConnection();
			String sql="insert into userremarks(userId,title,content,createTime,remindTime) values('"+ur.getUserId()+"','"+ur.getTitle()+"','"+ur.getContent()+"','"+date1+"','"+date2+"') ";
			ps=conn.prepareStatement(sql);
			int num=ps.executeUpdate();
			if(num==1){ 
				System.out.println("添加成功");
				//添加成功！
				b=true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.close();
		}
		return b;
	}

	public boolean delete(Serializable id) {
		boolean b=false;
		try{
			//得到链接
			conn=DBUtil.getConnection();
			String sql="delete from userremarks where id='" + id + "'";
			ps=conn.prepareStatement(sql);
			int num=ps.executeUpdate();
			if(num==1){
				//删除成功！
				b=true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.close();
		}
		return b;
	}

	public boolean update(UserRemarks ur) {
		boolean b=false;
		Date date = new java.sql.Date(ur.getRemindTime().getTime());
		try{
			//得到链接
			conn=DBUtil.getConnection();
			String sql="update userremarks set title='"+ur.getTitle()+"',content='"+ur.getContent()+"',remindTime='"+date+"' where id='"+ur.getId()+"'";
			ps=conn.prepareStatement(sql);
			int num=ps.executeUpdate();
			if(num==1){ 
				//修改成功！
				b=true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.close();
		}
		return b;
	}

	public UserRemarks findById(int id) {
		UserRemarks ur = null;
		conn = DBUtil.getConnection();
		String sql = "select * from userremarks where id = '" + id + "'";
		
		try{
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){	
				ur = new UserRemarks();		
				ur.setId(rs.getInt(1));
				ur.setUserId(rs.getInt(2));
				ur.setTitle(rs.getString(3));
				ur.setContent(rs.getString(4));				
				ur.setCreateTime(rs.getDate(5));
				ur.setRemindTime(rs.getDate(6));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.close();
		}
		return ur;	
	}

	public UserRemarks findByTitle(String title) {
		UserRemarks ur = null;
		conn = DBUtil.getConnection();
		String sql = "select * from userremarks where title = '" + title + "'";
		
		try{
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){	
				ur = new UserRemarks();		
				ur.setId(rs.getInt(1));
				ur.setUserId(rs.getInt(2));
				ur.setTitle(rs.getString(3));
				ur.setContent(rs.getString(4));
				ur.setCreateTime(rs.getDate(5));
				ur.setRemindTime(rs.getDate(6));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.close();
		}
		return ur;	
	}

	public List<UserRemarks> listAll() {
		List<UserRemarks> list = new ArrayList<UserRemarks>();
		conn = DBUtil.getConnection();
		String sql = "select * from userremarks";
		
		try{
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				UserRemarks ur = new UserRemarks();
				ur.setId(rs.getInt(1));
				ur.setUserId(rs.getInt(2));
				ur.setTitle(rs.getString(3));
				ur.setContent(rs.getString(4));
				ur.setCreateTime(rs.getDate(5));
				ur.setRemindTime(rs.getDate(6));
				
				list.add(ur);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.close();
		}
		return list;	
	}

}
