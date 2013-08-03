package com.mlcss.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.mlcss.bean.CoursesFollow;
import com.mlcss.dao.CoursesFollowDAO;
import com.mlcss.util.DBUtil;

/**
 * 课程关注 数据库操作
 * @author jc
 *
 */
public class CoursesFollowDAOImpl implements CoursesFollowDAO {

	private Connection conn=null;
	private	PreparedStatement ps=null;
	private ResultSet rs=null;
	
	
	public boolean add(CoursesFollow coursesfollow) {
		boolean b=false;
		try{
			//得到链接
			conn=DBUtil.getConnection();
			String sql="insert into coursesfollow(coursesId,userId,createTime) " +
					"values('"+coursesfollow.getCoursesId()+"'," +
							"'"+coursesfollow.getUserId()+"',NOW()) ";
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
			this.close();
		}
		return b;
	}

	public boolean delete(int id) {
		boolean b=false;
		try{
			//得到链接
			conn=DBUtil.getConnection();
			String sql="delete from coursesfollow where id='"+id+"'";
			ps=conn.prepareStatement(sql);
			int num=ps.executeUpdate();
			if(num==1){
				System.out.println("删除成功");
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

	public boolean update(CoursesFollow coursesfollow) {
		boolean b=false;
		try{
			//得到链接
			conn=DBUtil.getConnection();
			String sql="update coursesfollow set coursesId='"+coursesfollow.getCoursesId()+"'," +
					"userId='"+coursesfollow.getUserId()+"',createTime=NOW()";
			ps=conn.prepareStatement(sql);
			int num=ps.executeUpdate();
			if(num==1){ 
				System.out.println("修改成功！");
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

	public CoursesFollow findById(int id) {
		CoursesFollow cf = new CoursesFollow();
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from coursesfollow where id="+id;
			ps=conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				cf.setId(rs.getInt("id"));
				cf.setCoursesId(rs.getInt("coursesId"));
				cf.setUserId(rs.getInt("userId"));
				cf.setCreateTime(rs.getString("createTime"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.close();
		}
		return cf;
	}

	
	public CoursesFollow findById(int coursesId, int userId) {
		CoursesFollow cf = new CoursesFollow();
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from coursesfollow where coursesId="+coursesId+" " +
					"and userId="+userId;
			ps=conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				cf.setId(rs.getInt("id"));
				cf.setCoursesId(rs.getInt("coursesId"));
				cf.setUserId(rs.getInt("userId"));
				cf.setCreateTime(rs.getString("createTime"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.close();
		}
		return cf;
	}
	
	public List<CoursesFollow> findByUserId(int userId) {
		List list = new ArrayList();
		conn = DBUtil.getConnection();
		String sql = "select * from coursesfollow where userId="+userId;
		
		try{
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				CoursesFollow cf = new CoursesFollow();
				cf.setId(rs.getInt("id"));
				cf.setCoursesId(rs.getInt("coursesId"));
				cf.setUserId(rs.getInt("userId"));
				cf.setCreateTime(rs.getString("createTime"));
				
				list.add(cf);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.close();
		}
		return list;
	}

	public List<CoursesFollow> findBycoursesId(int coursesId) {
		List list = new ArrayList();
		conn = DBUtil.getConnection();
		String sql = "select * from coursesfollow where coursesId="+coursesId;
		
		try{
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				CoursesFollow cf = new CoursesFollow();
				cf.setId(rs.getInt("id"));
				cf.setCoursesId(rs.getInt("coursesId"));
				cf.setUserId(rs.getInt("userId"));
				cf.setCreateTime(rs.getString("createTime"));
				
				list.add(cf);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.close();
		}
		return list;
	}

	public List<CoursesFollow> listAll() {
		List list = new ArrayList();
		conn = DBUtil.getConnection();
		String sql = "select * from coursesfollow";
		
		try{
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				CoursesFollow cf = new CoursesFollow();
				cf.setId(rs.getInt("id"));
				cf.setCoursesId(rs.getInt("coursesId"));
				cf.setUserId(rs.getInt("userId"));
				cf.setCreateTime(rs.getString("createTime"));
				
				list.add(cf);
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


}
