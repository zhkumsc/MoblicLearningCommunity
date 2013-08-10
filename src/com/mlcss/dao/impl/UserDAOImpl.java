package com.mlcss.dao.impl;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mlcss.bean.User;
import com.mlcss.dao.UserDAO;
import com.mlcss.util.DBUtil;

/**
 * User 数据访问
 * @author fantasy
 *
 */
public class UserDAOImpl implements UserDAO {
	
	private Connection conn=null;
	private	PreparedStatement ps=null;
	private ResultSet rs=null;

	public boolean add(User user) {
		boolean b=false;
		Date date = new java.sql.Date(user.getCreateTime().getTime());
		try{
			//得到链接
			conn=DBUtil.getConnection();


			String sql="insert into users(name,password,email,userIcon,createTime) values('"+user.getName()+"','"+user.getPassword()+"','"+user.getEmail()+"','"+user.getUserIcon()+"','"+date+"') ";

			
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

	public boolean delete(Serializable bean) {
		boolean b=false;
		try{
			//得到链接
			conn=DBUtil.getConnection();
			String sql="delete from users where id='"+bean+"'";
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

	public boolean update(User user) {
		boolean b=false;
		try{
			//得到链接
			conn=DBUtil.getConnection();

			String sql="update users set name='"+user.getName()+"',password='"+user.getPassword()+"',email='"+user.getEmail()+"',userIcon='"+user.getUserIcon()+"' where id='"+user.getId()+"'";

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

	public User findById(int id) {
		User u = null;
		conn = DBUtil.getConnection();
		String sql = "select * from users where id = '" + id + "'";
		
		try{
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){	
				u = new User();		
				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setEmail(rs.getString(4));
				u.setUserIcon(rs.getString(5));
				u.setCreateTime(rs.getDate(6));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.close();
		}
		return u;	
	}

	public List<User> listAll() {

		
		List<User> list = new ArrayList<User>();

		conn = DBUtil.getConnection();
		String sql = "select * from users";
		
		try{
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				User u = new User();
				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setEmail(rs.getString(4));
				u.setCreateTime(rs.getDate(6));
				
				list.add(u);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.close();
		}
		return list;	
	}
	
	public User findByEmail(String email) {
		
		User u = null;
		conn = DBUtil.getConnection();
		String sql = "select * from users where email = '" + email + "'";
		
		try{
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){	
				u = new User();		// 修改了在这里初始化 （黄）
				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setEmail(rs.getString(4));
				u.setCreateTime(rs.getDate(6));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.close();
		}
		return u;	
	}

	public List<User> findByName(String name) {
		List<User> list = new ArrayList<User>();

		conn = DBUtil.getConnection();
		String sql = "select * from users where name = '" + name + "'";
		
		try{
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				User u = new User();
				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setEmail(rs.getString(4));
				u.setCreateTime(new java.util.Date(rs.getDate(6).getTime()));
				
				list.add(u);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.close();
		}
		return list;	
	}


}
