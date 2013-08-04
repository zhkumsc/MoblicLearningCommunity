package com.mlcss.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.mlcss.bean.UserChatrecords;
import com.mlcss.bean.UserNotes;
import com.mlcss.dao.UserChatrecordsDAO;
import com.mlcss.util.DBUtil;
import com.mlcss.util.DateTimeUtil;

public class UserChatrecordsDAOImpl implements UserChatrecordsDAO{
	private Connection conn=null;
	private	PreparedStatement ps=null;
	private ResultSet rs=null;

	public boolean add(UserChatrecords chatrecords) {
		boolean b=false;
		try{
			//得到链接
			 
			conn=DBUtil.getConnection();
			String sql="insert into userchatrecords(userId,friendId,content,createTime) values(?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setInt(1,chatrecords.getUserid() );
			ps.setInt(2, chatrecords.getFriendid());
			ps.setString(3, chatrecords.getContent());
			ps.setTimestamp(4,  DateTimeUtil.String2Date(chatrecords.getCreatetime()));
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

	public boolean delete(int userid) {
		boolean b=false;
		try{
			//得到链接
			conn=DBUtil.getConnection();
			String sql="delete from userchatrecords where userId="+userid;
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

	

	public List<UserChatrecords> findById(int userid, int friendid) {
		List<UserChatrecords> list=new ArrayList<UserChatrecords>();
		try{
			//得到链接
			conn=DBUtil.getConnection();
			String sql="select * from userchatrecords where userId="+userid+" and friendId="+friendid;
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				UserChatrecords k=new UserChatrecords();
			k.setContent(rs.getString(4));
			k.setCreatetime(DateTimeUtil.date2String(rs.getTimestamp(5)));
			k.setId(rs.getInt(1));
			k.setIsrceived(rs.getBoolean(6));
			k.setFriendid(rs.getInt(3));
			k.setUserid(rs.getInt(2));
			list.add(k);
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

	public boolean isread(UserChatrecords chatrecords) {
		boolean b=false;
		try{
			boolean c=true;
			//得到链接
			
			conn=DBUtil.getConnection();
			String sql="update userchatrecords set isReceived=? where id="+chatrecords.getId();
			ps=conn.prepareStatement(sql);
			ps.setBoolean(1, c);
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

	/**
	 * 得到某朋友的所有消息
	 * 参数reveived true为取出所有消息，false为取出未读消息
	 */
	public List<UserChatrecords> getAllFriendChatRecordsByUserId(int userId,
			boolean reveived) {
		List<UserChatrecords> list=new ArrayList<UserChatrecords>();
		try{
			//得到链接
			conn=DBUtil.getConnection();
			String sql;
			if(reveived) {
				sql="select * from userchatrecords where userId="+userId;
			} else {
				sql="select * from userchatrecords where userId="+userId+" and isReceived=0";
			}
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				UserChatrecords k=new UserChatrecords();
				k.setContent(rs.getString(4));
				k.setCreatetime(DateTimeUtil.date2String(rs.getTimestamp(5)));
				k.setId(rs.getInt(1));
				k.setIsrceived(rs.getBoolean(6));
				k.setFriendid(rs.getInt(3));
				k.setUserid(rs.getInt(2));
				list.add(k);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.close();
		}
		return list;
	}

	/**
	 * 设置批量已接受
	 */
	public boolean setListReceived(List<UserChatrecords> list) {
		boolean b=false;
		try{
			//得到链接
			
			conn=DBUtil.getConnection();
			conn.setAutoCommit(false);
			String sql="update userchatrecords set isReceived=? where id=?";
			ps=conn.prepareStatement(sql);
			for(UserChatrecords u : list) {
				ps.setBoolean(1, true);
				ps.setInt(2, u.getId());
				ps.addBatch();
				
			}
			int[] num = ps.executeBatch();
			if(num!=null){ 
				//修改成功！
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
			if(conn != null) {
				try {
					conn.setAutoCommit(true);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
			this.close();
		}
		return b;
		
	}

}
