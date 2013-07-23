package com.mlcss.dao.impl;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mlcss.bean.User;
import com.mlcss.dao.UserDAO;
import com.mlcss.dao.DBConnection;

/**
 * ����User bean ��DAO
 *
 * @author fantasy
 *
 */
public class UserDAOImpl implements UserDAO {
	
	private Connection conn=null;
	private	PreparedStatement ps=null;
	private ResultSet rs=null;

	public boolean add(User user) {
		boolean b=false;
		try{
			//得到链接
			conn=DBConnection.getConnection();
			String sql="insert into users(name,password,email) values('"+user.getName()+"','"+user.getPassword()+"','"+user.getEmail()+"') ";
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

	public boolean delete(Serializable bean) {
		boolean b=false;
		try{
			//得到链接
			conn=DBConnection.getConnection();
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
			this.close();
		}
		return b;
	}

	public boolean update(User user) {
		boolean b=false;
		try{
			//得到链接
			conn=DBConnection.getConnection();
			String sql="update users set name='"+user.getName()+"',password='"+user.getPassword()+"',email='"+user.getEmail()+"' where id='"+user.getId()+"'";
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

	public Serializable findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Serializable> listAll() {
		
		@SuppressWarnings("rawtypes")
		List list = new ArrayList();
		conn = DBConnection.getConnection();
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
				
				list.add(u);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.close();
		}
		return list;	
	}

	public List<Serializable> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public User findByEmail(String email){
		
		User u = new User();
		conn = DBConnection.getConnection();
		String sql = "select * from users where email = '" + email + "'";
		
		try{
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){				
				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setEmail(rs.getString(4));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.close();
		}
		return u;	
	}


}
