package com.mlcss.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mlcss.bean.CoursesUserInfo;
import com.mlcss.dao.CoursesUserInfoDAO;
import com.mlcss.util.DBUtil;

/**
 * 课程用户个人信息 数据库操作
 * @author jc
 *
 */
public class CoursesUserInfoDAOImpl implements CoursesUserInfoDAO {

	private Connection conn=null;
	private	PreparedStatement ps=null;
	private ResultSet rs=null;
	
	public boolean add(CoursesUserInfo coursesuserinfo) {
		boolean b=false;
		try{
			//得到链接
			conn=DBUtil.getConnection();
			String sql="insert into coursesuserinfo(userId,coursesId,remark,role) values(?,?,?,?) ";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, coursesuserinfo.getUserId());
			ps.setInt(2, coursesuserinfo.getCoursesId());
			ps.setString(3, coursesuserinfo.getRemark());
			ps.setString(4, coursesuserinfo.getRole());
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
			String sql="delete from coursesuserinfo where id=?";
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

	public boolean update(CoursesUserInfo coursesuserinfo) {
		boolean b=false;
		try{
			//得到链接
			conn=DBUtil.getConnection();
			String sql="update coursesuserinfo set remark=?,role=? where userId=? and coursesId=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, coursesuserinfo.getRemark());
			ps.setString(2, coursesuserinfo.getRole());
			ps.setInt(3, coursesuserinfo.getUserId());
			ps.setInt(4, coursesuserinfo.getCoursesId());
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

	public CoursesUserInfo findById(int id) {
		CoursesUserInfo cuinfo = new CoursesUserInfo();
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from coursesuserinfo where id=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()){
				cuinfo.setId(rs.getInt("id"));
				cuinfo.setUserId(rs.getInt("userId"));
				cuinfo.setCoursesId(rs.getInt("coursesId"));
				cuinfo.setRemark(rs.getString("remark"));
				cuinfo.setRole(rs.getString("role"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.close();
		}
		return cuinfo;
	}

	public CoursesUserInfo findById(int coursesId, int userId) {
		CoursesUserInfo cuinfo = new CoursesUserInfo();
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from coursesuserinfo where coursesId=? and userId=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, coursesId);
			ps.setInt(2, userId);
			rs = ps.executeQuery();
			while(rs.next()){
				cuinfo.setId(rs.getInt("id"));
				cuinfo.setUserId(rs.getInt("userId"));
				cuinfo.setCoursesId(rs.getInt("coursesId"));
				cuinfo.setRemark(rs.getString("remark"));
				cuinfo.setRole(rs.getString("role"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.close();
		}
		return cuinfo;
	}

	public List<CoursesUserInfo> findByUserId(int userId) {
		List list = new ArrayList();
		conn = DBUtil.getConnection();
		String sql = "select * from coursesuserinfo where userId=?";
		
		try{
			ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			rs = ps.executeQuery();
			while(rs.next()){
				CoursesUserInfo cuinfo = new CoursesUserInfo();
				cuinfo.setId(rs.getInt("id"));
				cuinfo.setUserId(rs.getInt("userId"));
				cuinfo.setCoursesId(rs.getInt("coursesId"));
				cuinfo.setRemark(rs.getString("remark"));
				cuinfo.setRole(rs.getString("role"));
				
				list.add(cuinfo);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.close();
		}
		return list;
	}

	public List<CoursesUserInfo> findBycoursesId(int coursesId) {
		List list = new ArrayList();
		conn = DBUtil.getConnection();
		String sql = "select * from coursesuserinfo where coursesId=?";
		
		try{
			ps = conn.prepareStatement(sql);
			ps.setInt(1, coursesId);
			rs = ps.executeQuery();
			while(rs.next()){
				CoursesUserInfo cuinfo = new CoursesUserInfo();
				cuinfo.setId(rs.getInt("id"));
				cuinfo.setUserId(rs.getInt("userId"));
				cuinfo.setCoursesId(rs.getInt("coursesId"));
				cuinfo.setRemark(rs.getString("remark"));
				cuinfo.setRole(rs.getString("role"));
				
				list.add(cuinfo);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.close();
		}
		return list;
	}

	public List<CoursesUserInfo> listAll() {
		List list = new ArrayList();
		conn = DBUtil.getConnection();
		String sql = "select * from coursesuserinfo";
		
		try{
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				CoursesUserInfo cuinfo = new CoursesUserInfo();
				cuinfo.setId(rs.getInt("id"));
				cuinfo.setUserId(rs.getInt("userId"));
				cuinfo.setCoursesId(rs.getInt("coursesId"));
				cuinfo.setRemark(rs.getString("remark"));
				cuinfo.setRole(rs.getString("role"));
				
				list.add(cuinfo);
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
