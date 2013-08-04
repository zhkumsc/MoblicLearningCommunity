package com.mlcss.dao.impl;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mlcss.bean.CoursesChatRecords;
import com.mlcss.bean.CoursesNotice;
import com.mlcss.dao.CoursesNoticeDAO;
import com.mlcss.util.DBUtil;
import com.mlcss.util.DateTimeUtil;

public class CoursesNoticeDAOImpl implements CoursesNoticeDAO {
	
	private Connection conn=null;
	private	PreparedStatement ps=null;
	private ResultSet rs=null;

	public boolean add(CoursesNotice cn) {
		boolean b=false;
		try{
			//得到链接
			conn=DBUtil.getConnection();
			String sql="insert into coursesnotice(coursesId,noticeTitle,content,noticeTime,userId, isReceived) values('"+cn.getCoursesId()+"','"+cn.getNoticeTitle()+"','"+cn.getContent()+"','"+cn.getNoticeTime()+"','"+cn.getUserId()+"','"+cn.isReceived()+"') ";
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
				cn.setNoticeTime(DateTimeUtil.date2String(rs.getTimestamp(5)));
				cn.setUserId(rs.getInt(6));
				cn.setReceived(rs.getBoolean(7));
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
				cn.setNoticeTime(DateTimeUtil.date2String(rs.getTimestamp(5)));
				cn.setUserId(rs.getInt(6));
				cn.setReceived(rs.getBoolean(7));
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
				cn.setNoticeTime(DateTimeUtil.date2String(rs.getTimestamp(5)));
				cn.setUserId(rs.getInt(6));
				cn.setReceived(rs.getBoolean(7));
				
				list.add(cn);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.close();
		}
		return list;	
	}

	/**
	 * 给关注课程的所有人发一条消息
	 */
	public boolean addTOAll(CoursesNotice cn) {
		boolean b=false;
		PreparedStatement ps2 = null;
		try{
			//得到链接
			conn=DBUtil.getConnection();
			conn.setAutoCommit(false);
			String sql = "select userId from coursesfollow where coursesId=" + cn.getCoursesId();
			String sql2="insert into coursesnotice(coursesId,noticeTitle,content,noticeTime,userId, isReceived) values(?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps2 = conn.prepareStatement(sql2);
			rs = ps.executeQuery();
			while(rs.next()) {
				cn.setUserId(rs.getInt(1));
				
				ps2.setObject(1, cn.getCoursesId());
				ps2.setObject(2, cn.getNoticeTitle());
				ps2.setObject(3, cn.getContent());
				ps2.setObject(4, cn.getNoticeTime());
				ps2.setObject(5, cn.getUserId());
				ps2.setObject(6, cn.isReceived());
				
				ps2.addBatch();
				
			}

			int[] num = ps2.executeBatch();
			if(num!=null){ 
				System.out.println("添加成功");
				//添加成功！
				b=true;
			}
		}catch(Exception e){
			if(conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		}finally{
			DBUtil.close();
			if(conn != null) {
				try {
					conn.setAutoCommit(true);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(ps2 != null) {
				try {
					ps2.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return b;
	}

	/**
	 * 从userId取出课程信息
	 * 参数 state true 取出所有消息，false 取出未读消息 
	 */
	public List<CoursesNotice> getAllCoursesNoticeByUserId(int userId,
			boolean reveived) {
		List<CoursesNotice> list = new ArrayList<CoursesNotice>();
		conn = DBUtil.getConnection();
		String sql = null ;
		if(reveived) {
			sql = "select * from coursesnotice where userId = "+ userId;
		} else {
			sql = "select * from coursesnotice where userId = "+ userId +" And isReceived=0" ;
		}
		
		try{
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				CoursesNotice cn = new CoursesNotice();
				cn.setId(rs.getInt(1));
				cn.setCoursesId(rs.getInt(2));
				cn.setNoticeTitle(rs.getString(3));
				cn.setContent(rs.getString(4));
				cn.setNoticeTime(DateTimeUtil.date2String(rs.getTimestamp(5)));
				cn.setUserId(rs.getInt(6));
				cn.setReceived(rs.getBoolean(7));
				
				list.add(cn);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.close();
		}
		return list;
	}

	public boolean setListReceived(List<CoursesNotice> list) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBUtil.getConnection();
			conn.setAutoCommit(false);
			String sql = "update coursesnotice set isReceived = 1 where id = ?";
			ps = conn.prepareStatement(sql);
			for(CoursesNotice cn : list) {
				ps.setInt(1, cn.getId());
				ps.addBatch();
				
			}

			if (ps.executeBatch() == null) {
				return false;
			}
			return true;
		} catch (SQLException e) {	
			if(conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
			return false;
		} finally {
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}		
			if(conn != null) {
				try {
					conn.setAutoCommit(true);
					conn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}		
		}
		
	}

}
