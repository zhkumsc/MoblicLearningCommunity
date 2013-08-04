package com.mlcss.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mlcss.bean.CoursesChatRecords;
import com.mlcss.bean.SystemMessages;
import com.mlcss.dao.SystemMessagesDAO;
import com.mlcss.util.DBUtil;
import com.mlcss.util.DateTimeUtil;

public class SystemMessagesDAOImpl implements SystemMessagesDAO {
	
	/**
	 * 增加消息
	 * @param Record
	 * @return
	 * @throws SQLException 
	 */
	public boolean addMessage(SystemMessages msg) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "insert into systemmessages(receiverId, content, createTime, isReceived) values(?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, msg.getReceiverId());
			ps.setString(2, msg.getContent());
			ps.setTimestamp(3, DateTimeUtil.String2Date(msg.getCreateTime()));
			ps.setBoolean(4, msg.isReceived());
			
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
	 * 删除某条消息
	 * @param id
	 * @return
	 */
	public boolean delMessageById(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "delete from systemmessages where id=?";
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
	 * 删除某接受者所有消息
	 * @param courseId
	 * @return
	 */
	public boolean delAllMessageByReceiverId(int receiverId) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "delete from systemmessages where receiverId=?";
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
	 * 更新某条消息
	 * @param Record
	 * @return
	 */
	public boolean updateMessage(SystemMessages msg) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "update systemmessages set receiverId = ?, content = ?, createTime = ?, isReceived = ? where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, msg.getReceiverId());
			ps.setString(2, msg.getContent());
			ps.setTimestamp(3, DateTimeUtil.String2Date(msg.getCreateTime()));
			ps.setBoolean(4, msg.isReceived());
			ps.setInt(5, msg.getId());
			
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
	 * 返回某接受者所有记录
	 * @param receiverId 	接受者id
	 * @param received 		true为获取所有消息，false为获取未读消息
	 * @return
	 */
	public List<SystemMessages> getAllMessageByReceiverId(int receiverId, boolean received) {
		Connection conn = null;
		PreparedStatement ps = null;
		List<SystemMessages> list = null;
		try {
			conn = DBUtil.getConnection();
			String sql = null;
			if(received) {
				sql = "select * from systemmessages where receiverId=?";
			} else {
				sql = "select * from systemmessages where receiverId=? and isReceived=0";
			}
			ps = conn.prepareStatement(sql);
			ps.setInt(1, receiverId);
			
			ResultSet rs = ps.executeQuery();
			list = new ArrayList<SystemMessages>();
			while(rs.next()) {
				SystemMessages sm = new SystemMessages();
				sm.setId(rs.getInt("id"));
				sm.setReceiverId(rs.getInt("receiverId"));
				sm.setContent(rs.getString("content"));
				sm.setCreateTime(DateTimeUtil.date2String(rs.getTimestamp("createTime")));
				sm.setReceived(rs.getBoolean("isReceived"));
				list.add(sm);
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
	 * 返回某条记录
	 * @param id
	 * @return
	 */
	public SystemMessages getMessageById(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from systemmessages where id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			SystemMessages sm = null;
			while(rs.next()) {
				sm = new SystemMessages();
				sm.setId(rs.getInt("id"));
				sm.setReceiverId(rs.getInt("receiverId"));
				sm.setContent(rs.getString("content"));
				sm.setCreateTime(DateTimeUtil.date2String(rs.getTimestamp("createTime")));
				sm.setReceived(rs.getBoolean("isReceived"));
			}
			
			return sm;

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


	public boolean setListReceived(List<SystemMessages> list) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBUtil.getConnection();
			conn.setAutoCommit(false);
			String sql = "update SystemMessages set isReceived = 1 where id = ?";
			ps = conn.prepareStatement(sql);
			for(SystemMessages sm : list) {
				ps.setInt(1, sm.getId());
				ps.addBatch();
				
			}

			if (ps.executeBatch() == null) {
				return false;
			}
			return true;
		} catch (SQLException e) {	
			if(conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
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
					conn.setAutoCommit(true);
					conn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}		
		}
		
	}

}
