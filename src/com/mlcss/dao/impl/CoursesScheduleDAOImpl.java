package com.mlcss.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import com.mlcss.bean.CoursesSchedule;
import com.mlcss.bean.CoursesUserInfo;
import com.mlcss.dao.CoursesScheduleDAO;
import com.mlcss.util.DBUtil;

/**
 * 课程课表 数据库操作
 * @author jc
 *
 */
public class CoursesScheduleDAOImpl implements CoursesScheduleDAO {

	private Connection conn=null;
	private	PreparedStatement ps=null;
	private ResultSet rs=null;
	
	public boolean add(CoursesSchedule coursesschedule) {
		boolean b=false;
		try{
			//得到链接
			conn=DBUtil.getConnection();
			String sql="insert into coursesschedule(userId,coursesId,coursesTime,coursesPlace,isUsed,teatherId) " +
					"values(?,?,?,?,?,?) ";
			ps=conn.prepareStatement(sql);
			ps.setInt(1,coursesschedule.getUserId());
			ps.setInt(2, coursesschedule.getCoursesId());
			ps.setString(3, coursesschedule.getCoursesTime());
			ps.setString(4, coursesschedule.getCoursesPlace());
			ps.setByte(5, coursesschedule.getIsUsed());
			ps.setInt(6, coursesschedule.getTeatherId());
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
			String sql="delete from coursesschedule where id=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
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

	public boolean update(CoursesSchedule coursesschedule) {
		boolean b=false;
		try{
			//得到链接
			conn=DBUtil.getConnection();
			String sql="update coursesschedule set coursesTime=?," +
					"coursesPlace=?,isUsed=?,teatherId=? where userId=? and coursesId=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, coursesschedule.getCoursesTime());
			ps.setString(2, coursesschedule.getCoursesPlace());
			ps.setByte(3, coursesschedule.getIsUsed());
			ps.setInt(4, coursesschedule.getTeatherId());
			ps.setInt(5, coursesschedule.getUserId());
			ps.setInt(6, coursesschedule.getCoursesId());
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

	public CoursesSchedule findById(int id) {
		CoursesSchedule cs = new CoursesSchedule();
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from coursesschedule where id=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()){
				cs.setId(rs.getInt("id"));
				cs.setUserId(rs.getInt("userId"));
				cs.setCoursesId(rs.getInt("coursesId"));
				cs.setCoursesTime(rs.getString("coursesTime"));
				cs.setCoursesPlace(rs.getString("coursesPlace"));
				cs.setIsUsed(rs.getByte("isUsed"));
				cs.setTeatherId(rs.getInt("teatherId"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.close();
		}
		return cs;
	}

	public CoursesSchedule findById(int coursesId, int userId) {
		CoursesSchedule cs = new CoursesSchedule();
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from coursesschedule where coursesId=? and userId=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, coursesId);
			ps.setInt(2, userId);
			rs = ps.executeQuery();
			while(rs.next()){
				cs.setId(rs.getInt("id"));
				cs.setUserId(rs.getInt("userId"));
				cs.setCoursesId(rs.getInt("coursesId"));
				cs.setCoursesTime(rs.getString("coursesTime"));
				cs.setCoursesPlace(rs.getString("coursesPlace"));
				cs.setIsUsed(rs.getByte("isUsed"));
				cs.setTeatherId(rs.getInt("teatherId"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.close();
		}
		return cs;
	}

	public List<CoursesSchedule> findByUserId(int userId) {
		List list = new ArrayList();
		conn = DBUtil.getConnection();
		String sql = "select * from coursesschedule where userId=?";
		
		try{
			ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			rs = ps.executeQuery();
			while(rs.next()){
				CoursesSchedule cs = new CoursesSchedule();
				cs.setId(rs.getInt("id"));
				cs.setUserId(rs.getInt("userId"));
				cs.setCoursesId(rs.getInt("coursesId"));
				cs.setCoursesTime(rs.getString("coursesTime"));
				cs.setCoursesPlace(rs.getString("coursesPlace"));
				cs.setIsUsed(rs.getByte("isUsed"));
				cs.setTeatherId(rs.getInt("teatherId"));
				
				list.add(cs);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.close();
		}
		return list;
	}

	public List<CoursesSchedule> listAll() {
		List list = new ArrayList();
		conn = DBUtil.getConnection();
		String sql = "select * from coursesschedule";
		
		try{
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				CoursesSchedule cs = new CoursesSchedule();
				cs.setId(rs.getInt("id"));
				cs.setUserId(rs.getInt("userId"));
				cs.setCoursesId(rs.getInt("coursesId"));
				cs.setCoursesTime(rs.getString("coursesTime"));
				cs.setCoursesPlace(rs.getString("coursesPlace"));
				cs.setIsUsed(rs.getByte("isUsed"));
				cs.setTeatherId(rs.getInt("teatherId"));
				
				list.add(cs);
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
