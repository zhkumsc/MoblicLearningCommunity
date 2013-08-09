package com.mlcss.dao.impl;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mlcss.bean.UserRelShip;
import com.mlcss.dao.UserRelShipDAO;
import com.mlcss.util.DBUtil;

public class UserRelShipDAOImpl implements UserRelShipDAO {

	private Connection conn=null;
	private	PreparedStatement ps=null;
	private ResultSet rs=null;
	
	public boolean add(UserRelShip urs) {
		boolean b=false;
		try{
			//得到链接
			conn=DBUtil.getConnection();
			String sql="insert into userrelationship(userId,friendId,groupId,createTime,friendNote) values('"+urs.getUserId()+"','"+urs.getFriendId()+"','"+urs.getGroupId()+"','"+urs.getCreateTime()+"','"+urs.getFriendNote()+"') ";
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
			String sql="delete from userrelationship where id='" + id + "'";
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

	public boolean update(UserRelShip urs) {
		boolean b=false;
		try{
			//得到链接
			conn=DBUtil.getConnection();
			String sql="update userrelationship set userId='"+urs.getUserId()+"',friendId='"+urs.getFriendId()+"',groupId='"+urs.getGroupId()+"' where id='"+urs.getId()+"'";
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
	
	public boolean friendRename(UserRelShip urs) {
		boolean b=false;
		try{
			//得到链接
			conn=DBUtil.getConnection();
			String sql="update userrelationship set friendNote='"+urs.getFriendNote()+"' where id='"+urs.getId()+"'";
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

	public UserRelShip findById(int id) {
		UserRelShip urs = null;
		conn = DBUtil.getConnection();
		String sql = "select * from userrelationship where id = '" + id + "'";
		
		try{
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){	
				urs = new UserRelShip();		
				urs.setId(rs.getInt(1));
				urs.setId(rs.getInt(2));
				urs.setId(rs.getInt(3));
				urs.setId(rs.getInt(4));
				urs.setCreateTime(rs.getTimestamp(5));
				urs.setFriendNote(rs.getString(6));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.close();
		}
		return urs;	
	}

	public List<UserRelShip> listAll() {
		List<UserRelShip> list = new ArrayList<UserRelShip>();
		conn = DBUtil.getConnection();
		String sql = "select * from userrelationship";
		
		try{
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				UserRelShip urs = new UserRelShip();
				urs.setId(rs.getInt(1));
				urs.setId(rs.getInt(2));
				urs.setId(rs.getInt(3));
				urs.setId(rs.getInt(4));
				urs.setCreateTime(rs.getTimestamp(5));
				urs.setFriendNote(rs.getString(6));
				
				list.add(urs);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.close();
		}
		return list;	
	}

}
