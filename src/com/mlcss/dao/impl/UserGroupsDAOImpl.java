package com.mlcss.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
			String sql="update usergroups set userId="+user.getUserid()+" ,groupName='"+user.getGroupname()+"' where id="+user.getId();
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
	

	public UserGroups findById(int id) {
		UserGroups k=new UserGroups();
		try{
			//得到链接
			conn=DBUtil.getConnection();
			String sql="select * from usergroups where id="+id;
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			rs.next();
			k.setGroupname(rs.getString(3));
			k.setId(rs.getInt(1));
			k.setUserid(rs.getInt(2));
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.close();
		}
		return k;
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
