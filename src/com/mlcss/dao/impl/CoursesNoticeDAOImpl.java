package com.mlcss.dao.impl;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mlcss.bean.CoursesNotice;
import com.mlcss.dao.CoursesNoticeDAO;
import com.mlcss.util.DBUtil;

public class CoursesNoticeDAOImpl implements CoursesNoticeDAO {
	
	private Connection conn=null;
	private	PreparedStatement ps=null;
	private ResultSet rs=null;

	public boolean add(CoursesNotice cn) {
		boolean b=false;
		Date date = new java.sql.Date(cn.getNoticeTime().getTime());
		try{
			//得到链接
			conn=DBUtil.getConnection();
			String sql="insert into coursesnotice(coursesId,noticeTitle,content,noticeTime,userId) values('"+cn.getCoursesId()+"','"+cn.getNoticeTitle()+"','"+cn.getContent()+"','"+date+"','"+cn.getUserId()+"') ";
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
			String sql="delete from coursesnotice where id='" + id + "'";
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

	public boolean update(CoursesNotice cn) {
		boolean b=false;
		try{
			//得到链接
			conn=DBUtil.getConnection();
			String sql="update coursesnotice set noticeTitle='"+cn.getNoticeTitle()+"',content='"+cn.getContent()+"'";
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

	public CoursesNotice findById(int id) {
		CoursesNotice cn = null;
		conn = DBUtil.getConnection();
		String sql = "select * from coursesnotice where id = '" + id + "'";
		
		try{
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){	
				cn = new CoursesNotice();		
				cn.setId(rs.getInt(1));
				cn.setCoursesId(rs.getInt(2));
				cn.setNoticeTitle(rs.getString(3));
				cn.setContent(rs.getString(4));
				cn.setNoticeTime(rs.getDate(5));
				cn.setUserId(rs.getInt(6));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.close();
		}
		return cn;	
	}

	public CoursesNotice findByTitle(String title) {
		CoursesNotice cn = null;
		conn = DBUtil.getConnection();
		String sql = "select * from coursesnotice where noticeTitle = '" + title + "'";
		
		try{
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){	
				cn = new CoursesNotice();		
				cn.setId(rs.getInt(1));
				cn.setCoursesId(rs.getInt(2));
				cn.setNoticeTitle(rs.getString(3));
				cn.setContent(rs.getString(4));
				cn.setNoticeTime(rs.getDate(5));
				cn.setUserId(rs.getInt(6));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.close();
		}
		return cn;	
	}

	public List<CoursesNotice> listAll() {
		List<CoursesNotice> list = new ArrayList<CoursesNotice>();
		conn = DBUtil.getConnection();
		String sql = "select * from coursesnotice";
		
		try{
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				CoursesNotice cn = new CoursesNotice();
				cn.setId(rs.getInt(1));
				cn.setCoursesId(rs.getInt(2));
				cn.setNoticeTitle(rs.getString(3));
				cn.setContent(rs.getString(4));
				cn.setNoticeTime(rs.getDate(5));
				cn.setUserId(rs.getInt(6));
				
				list.add(cn);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.close();
		}
		return list;	
	}

}
