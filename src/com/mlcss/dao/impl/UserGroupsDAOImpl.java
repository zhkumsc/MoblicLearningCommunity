package com.mlcss.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mlcss.bean.UserGroups;
import com.mlcss.dao.UserGroupsDAO;
import com.mlcss.util.DBUtil;

public class UserGroupsDAOImpl implements UserGroupsDAO{
	private Connection conn=null;
	private	PreparedStatement ps=null;
	private ResultSet rs=null;

	public boolean add(UserGroups user) {
		boolean b=false;
		try{
			//得到链接
			conn=DBUtil.getConnection();
			String sql="insert into usergroups(userId,groupName) values("+user.getUserid()+",'"+user.getGroupname()+"') ";
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
			String sql="delete from usergroups where id="+id;
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

	public boolean update(UserGroups user) {
		boolean b=false;
		try{
			//得到链接
			conn=DBUtil.getConnection();
			String sql="update usergroups set groupName='"+user.getGroupname()+"' where id="+user.getId();
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
	
	public List<UserGroups> listAll(int userId) {
		List<UserGroups> list = new ArrayList<UserGroups>();
		conn = DBUtil.getConnection();
        String sql = "select * from usergroups where userId='" + userId + "'";
		
		try{
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				UserGroups ur = new UserGroups();
				ur.setId(rs.getInt(1));
				ur.setUserid(rs.getInt(2));
				ur.setGroupname(rs.getString(3));
				
				list.add(ur);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.close();
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

	public UserGroups findById(int id) {
		UserGroups ug = null;
		conn = DBUtil.getConnection();
		String sql = "select * from usergroups where id = '" + id + "'";
		
		try{
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){	
				ug = new UserGroups();		
				ug.setId(rs.getInt(1));
				ug.setUserid(rs.getInt(2));
				ug.setGroupname(rs.getString(3));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.close();
		}
		return ug;	
	}

	public UserGroups findFriendGroups(int userId, String groupName) {

		UserGroups ug = null;
		conn = DBUtil.getConnection();
		String sql = "select * from usergroups where userId = '" + userId + "' and groupName = '" + groupName + "'";
		
		try{
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){	
				ug = new UserGroups();		
				ug.setId(rs.getInt(1));
				ug.setUserid(rs.getInt(2));
				ug.setGroupname(rs.getString(3));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.close();
		}
		return ug;	
	}

}
