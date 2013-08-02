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

public class CoursesChatRecordsDAOImpl implements CoursesChatRecordsDAO {
	
	/**
	 * 增加记录
	 * @param Record
	 * @return
	 * @throws SQLException 
	 */
	public boolean addChatRecord(CoursesChatRecords record) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "insert into coursesChatRecords(coursesId, userId, content, createTime, isReceived) values(?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, record.getCoursesId());
			ps.setInt(2, record.getUserId());
			ps.setString(3, record.getContent());
			ps.setTimestamp(4, record.getCreateTime());
			ps.setByte(5, record.getIsReceived());
			
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
	 * 删除某条记录
	 * @param id
	 * @return
	 */
	public boolean delChatRecordById(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
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
	 * 删除某课程所有记录
	 * @param courseId
	 * @return
	 */
	public boolean delAllChatRecordByCourseId(int coursesId) {
		Connection conn = null;
		PreparedStatement ps = null;
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
	 * 更新某条记录
	 * @param Record
	 * @return
	 */
	public boolean updateChatRecord(CoursesChatRecords record) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "update coursesChatRecords set coursesId = ?, userId = ?, content = ?, createTime = ?, isReceived = ? where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, record.getCoursesId());
			ps.setInt(2, record.getUserId());
			ps.setString(3, record.getContent());
			ps.setTimestamp(4, record.getCreateTime());
			ps.setByte(5, record.getIsReceived());
			ps.setInt(6, record.getId());
			
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
	 * 返回某课程所有记录
	 * @param courseId
	 * @return
	 */
	public List<CoursesChatRecords> getAllCoursesChatRecords(int coursesId) {
		Connection conn = null;
		PreparedStatement ps = null;
		List<CoursesChatRecords> list = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from coursesChatRecords where coursesId=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, coursesId);
			
			ResultSet rs = ps.executeQuery();
			list = new ArrayList<CoursesChatRecords>();
			while(rs.next()) {
				CoursesChatRecords ccr = new CoursesChatRecords();
				ccr.setId(rs.getInt("id"));
				ccr.setCoursesId(rs.getInt("coursesId"));
				ccr.setUserId(rs.getInt("userId"));
				ccr.setContent(rs.getString("content"));
				ccr.setCreateTime(rs.getTimestamp("createTime"));
				ccr.setIsReceived(rs.getByte("isReceived"));
				list.add(ccr);
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
	public CoursesChatRecords getCoursesChatRecordsById(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from coursesChatRecords where id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			CoursesChatRecords ccr = null;
			while(rs.next()) {
				ccr = new CoursesChatRecords();
				ccr.setId(rs.getInt("id"));
				ccr.setCoursesId(rs.getInt("coursesId"));
				ccr.setUserId(rs.getInt("userId"));
				ccr.setContent(rs.getString("content"));
				ccr.setCreateTime(rs.getTimestamp("createTime"));
				ccr.setIsReceived(rs.getByte("isReceived"));
			}
			
			return ccr;

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
