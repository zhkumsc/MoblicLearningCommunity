package com.mlcss.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mlcss.bean.CoursesChatRecords;
import com.mlcss.dao.CoursesChatRecordsDAO;
import com.mlcss.util.DBUtil;
import com.mlcss.util.DateTimeUtil;

public class CoursesChatRecordsDAOImpl implements CoursesChatRecordsDAO {
	
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	/**
	 * 增加记录
	 * @param Record
	 * @return
	 * @throws SQLException 
	 */
	public boolean addChatRecord(CoursesChatRecords record) {
		try {
			conn = DBUtil.getConnection();
			String sql = "insert into coursesChatRecords(coursesId, userId, content, createTime, isReceived, sendId) values(?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, record.getCoursesId());
			ps.setInt(2, record.getUserId());
			ps.setString(3, record.getContent());
			ps.setTimestamp(4, DateTimeUtil.String2Date(record.getCreateTime()));
			ps.setBoolean(5, record.isReceived());
			ps.setInt(6, record.getSendId());
			
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {			
			e.printStackTrace();
			return false;
		} finally {
			close();	
		}
			
	}
	
	/**
	 * 删除某条记录
	 * @param id
	 * @return
	 */
	public boolean delChatRecordById(int id) {

		try {
			conn = DBUtil.getConnection();
			String sql = "delete from coursesChatRecords where id=?";
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
			close();	
		}
		
	}
	
	/**
	 * 删除某课程所有记录
	 * @param courseId
	 * @return
	 */
	public boolean delAllChatRecordByCourseId(int coursesId) {

		try {
			conn = DBUtil.getConnection();
			String sql = "delete from coursesChatRecords where coursesId=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, coursesId);
			
			int i = ps.executeUpdate();
			if(i <= 0) {
				return false;
			}
			return true;
		} catch (SQLException e) {			
			e.printStackTrace();
			return false;
		} finally {
			close();		
		}
		
	}
	
	
	/**
	 * 更新某条记录
	 * @param Record
	 * @return
	 */
	public boolean updateChatRecord(CoursesChatRecords record) {

		try {
			conn = DBUtil.getConnection();
			String sql = "update coursesChatRecords set coursesId = ?, userId = ?, content = ?, createTime = ?, isReceived = ?, sendId = ? where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, record.getCoursesId());
			ps.setInt(2, record.getUserId());
			ps.setString(3, record.getContent());
			ps.setTimestamp(4, DateTimeUtil.String2Date(record.getCreateTime()));
			ps.setBoolean(5, record.isReceived());
			ps.setInt(6, record.getSendId());
			ps.setInt(7, record.getId());
			
			if (ps.executeUpdate() <= 0) {
				return false;
			}
			return true;
		} catch (SQLException e) {			
			e.printStackTrace();
			return false;
		} finally {
			close();	
		}
		
	}
	
	/**
	 * 返回某课程所有记录
	 * @param courseId
	 * @return
	 */
	public List<CoursesChatRecords> getAllCoursesChatRecords(int coursesId) {

		List<CoursesChatRecords> list = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from coursesChatRecords where coursesId=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, coursesId);
			
			rs = ps.executeQuery();
			list = new ArrayList<CoursesChatRecords>();
			while(rs.next()) {
				CoursesChatRecords ccr = new CoursesChatRecords();
				ccr.setId(rs.getInt("id"));
				ccr.setCoursesId(rs.getInt("coursesId"));
				ccr.setUserId(rs.getInt("userId"));
				ccr.setSendId(rs.getInt("sendId"));
				ccr.setContent(rs.getString("content"));
				ccr.setCreateTime(DateTimeUtil.date2String(rs.getTimestamp("createTime")));
				ccr.setReceived(rs.getBoolean("isReceived"));
				list.add(ccr);
			}
			
			return list;

		} catch (SQLException e) {			
			e.printStackTrace();
			return list;
		} finally {
			close();	
		}
		
	}
	
	
	/**
	 * 返回某条记录
	 * @param id
	 * @return
	 */
	public CoursesChatRecords getCoursesChatRecordsById(int id) {
		
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from coursesChatRecords where id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			CoursesChatRecords ccr = null;
			while(rs.next()) {
				ccr = new CoursesChatRecords();
				ccr.setId(rs.getInt("id"));
				ccr.setCoursesId(rs.getInt("coursesId"));
				ccr.setUserId(rs.getInt("userId"));
				ccr.setSendId(rs.getInt("sendId"));
				ccr.setContent(rs.getString("content"));
				ccr.setCreateTime(DateTimeUtil.date2String(rs.getTimestamp("createTime")));
				ccr.setReceived(rs.getBoolean("isReceived"));
			}
			
			return ccr;

		} catch (SQLException e) {			
			e.printStackTrace();
			return null;
		} finally {
			close();
		}
		
	}


	/**
	 * 返回某User所有的记录
	 * @param userId 	用户id
	 * @param received	false为取出未读消息，true为取出所有id
	 * @return
	 */
	public List<CoursesChatRecords> getAllCoursesChatRecordsByUserId(
			int userId, boolean received) {

		List<CoursesChatRecords> list = null;
		try {
			conn = DBUtil.getConnection();
			String sql = null;
			if(received) {
				sql = "select * from coursesChatRecords where userID=?";
			} else {
				sql = "select * from coursesChatRecords where userID=? And isReceived=0";
			}
			ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			
			rs = ps.executeQuery();
			list = new ArrayList<CoursesChatRecords>();
			while(rs.next()) {
				CoursesChatRecords ccr = new CoursesChatRecords();
				ccr.setId(rs.getInt("id"));
				ccr.setCoursesId(rs.getInt("coursesId"));
				ccr.setUserId(rs.getInt("userId"));
				ccr.setSendId(rs.getInt("sendId"));
				ccr.setContent(rs.getString("content"));
				ccr.setCreateTime(DateTimeUtil.date2String(rs.getTimestamp("createTime")));
				ccr.setReceived(rs.getBoolean("isReceived"));
				list.add(ccr);
			}
			
			return list;

		} catch (SQLException e) {			
			e.printStackTrace();
			return null;
		} finally {
			close();
		}
	}


	public boolean setReceivedById(int id) {

		try {
			conn = DBUtil.getConnection();
			String sql = "update coursesChatRecords set isReceived = 1 where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			if (ps.executeUpdate() <= 0) {
				return false;
			}
			return true;
		} catch (SQLException e) {			
			e.printStackTrace();
			return false;
		} finally {
			close();		
		}
	}

	public boolean setListReceived(List<CoursesChatRecords> list) {

		try {
			conn = DBUtil.getConnection();
			conn.setAutoCommit(false);
			String sql = "update coursesChatRecords set isReceived = 1 where id = ?";
			ps = conn.prepareStatement(sql);
			for(CoursesChatRecords ccr : list) {
				ps.setInt(1, ccr.getId());
				ps.addBatch();
				
			}
			int[] line = ps.executeBatch();
			conn.commit();
			if (line == null) {
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
			close();	
		}
		
	}

	public boolean addChatRecordToAll(CoursesChatRecords record) {
		PreparedStatement ps2 = null;
		
		try {
			conn = DBUtil.getConnection();
			conn.setAutoCommit(false);
			String sql = "insert into coursesChatRecords(coursesId, userId, content, createTime, isReceived, sendId) values(?,?,?,?,?,?)";
			String sql2 = "select userId from coursesfollow where coursesId=" + record.getCoursesId();
			
			ps = conn.prepareStatement(sql);
			ps2 = conn.prepareStatement(sql2);
			rs = ps2.executeQuery();
			while(rs.next()) {
				
				record.setUserId(rs.getInt(1));
				
				ps.setInt(1, record.getCoursesId());
				ps.setInt(2, record.getUserId());
				ps.setString(3, record.getContent());
				ps.setTimestamp(4, DateTimeUtil.String2Date(record.getCreateTime()));
				ps.setBoolean(5, record.isReceived());
				ps.setInt(6, record.getSendId());
				
				ps.addBatch();
			}
			
			ps.executeBatch();
			conn.commit();
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
			close();
			if(ps2!= null) {
				try {
					ps2.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private void close() {
		if(ps != null) {
			try {
				ps.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}		
		if(conn != null) {
			try {
				conn.setAutoCommit(false);
				conn.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}	
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
