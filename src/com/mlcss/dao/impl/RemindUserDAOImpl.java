package com.mlcss.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mlcss.bean.RemindUser;
import com.mlcss.bean.SystemMessages;
import com.mlcss.dao.RemindUserDAO;
import com.mlcss.util.DBUtil;

public class RemindUserDAOImpl implements RemindUserDAO {
	
	/**
	 * 增加提醒
	 * @param Record
	 * @return
	 * @throws SQLException 
	 */
	public boolean addRemind(RemindUser remind) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "insert into reminduser (receiverId, content, createTime, identifying, isReceived) values(?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, remind.getReceiverId());
			ps.setString(2, remind.getContent());
			ps.setTimestamp(3, remind.getCreateTime());
			ps.setByte(4, remind.getIdentifying());
			ps.setByte(5, remind.getIsReceived());
			
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {			
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
					conn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}		
		}
			
	}
	
	/**
	 * 删除某条提醒
	 * @param id
	 * @return
	 */
	public boolean delRemindById(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "delete from reminduser where id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			int i = ps.executeUpdate();
			if(i <= 0) {
				return false;
			}
			return true;
		} catch (SQLException e) {			
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
					conn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}		
		}
		
	}
	
	/**
	 * 删除某接受者所有提醒
	 * @param courseId
	 * @return
	 */
	public boolean delAllRemindReceiverId(int receiverId) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "delete from reminduser where receiverId=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, receiverId);
			
			int i = ps.executeUpdate();
			if(i <= 0) {
				return false;
			}
			return true;
		} catch (SQLException e) {			
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
					conn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}		
		}
		
	}
	
	/**
	 * 更新某条提醒
	 * @param Record
	 * @return
	 */
	public boolean updateRemind(RemindUser remind) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "update reminduser set receiverId = ?, content = ?, createTime = ?, identifying = ?, isReceived = ? where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, remind.getReceiverId());
			ps.setString(2, remind.getContent());
			ps.setTimestamp(3, remind.getCreateTime());
			ps.setByte(4, remind.getIdentifying());
			ps.setByte(5, remind.getIsReceived());
			ps.setInt(6, remind.getId());
			
			if (ps.executeUpdate() <= 0) {
				return false;
			}
			return true;
		} catch (SQLException e) {			
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
					conn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}		
		}
		
	}
	
	/**
	 * 返回某接受者所有提醒
	 * @param courseId
	 * @return
	 */
	public List<RemindUser> getAllRemindByReceiverId(int receiverId) {
		Connection conn = null;
		PreparedStatement ps = null;
		List<RemindUser> list = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from RemindUser where receiverId=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, receiverId);
			
			ResultSet rs = ps.executeQuery();
			list = new ArrayList<RemindUser>();
			while(rs.next()) {
				RemindUser remind = new RemindUser();
				remind.setId(rs.getInt("id"));
				remind.setReceiverId(rs.getInt("receiverId"));
				remind.setContent(rs.getString("content"));
				remind.setIdentifying(rs.getByte("identifying"));
				remind.setCreateTime(rs.getTimestamp("createTime"));
				remind.setIsReceived(rs.getByte("isReceived"));
				list.add(remind);
			}
			
			return list;

		} catch (SQLException e) {			
			e.printStackTrace();
			return list;
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
					conn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}		
		}
		
	}
	
	
	/**
	 * 返回某条提醒
	 * @param id
	 * @return
	 */
	public RemindUser getRemindById(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from RemindUser where id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			RemindUser remind = null;
			while(rs.next()) {
				remind = new RemindUser();
				remind.setId(rs.getInt("id"));
				remind.setReceiverId(rs.getInt("receiverId"));
				remind.setContent(rs.getString("content"));
				remind.setCreateTime(rs.getTimestamp("createTime"));
				remind.setIdentifying(rs.getByte("identifying"));
				remind.setIsReceived(rs.getByte("isReceived"));
			}
			
			return remind;

		} catch (SQLException e) {			
			e.printStackTrace();
			return null;
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
					conn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}		
		}
		
	}

}
