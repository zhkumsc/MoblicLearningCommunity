package com.mlcss.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.mlcss.bean.Courses;
import com.mlcss.bean.QuestionAsk;
import com.mlcss.dao.CoursesDAO;
import com.mlcss.dao.QuestionaskDAO;
import com.mlcss.util.DBUtil;

public class CoursesDAOImpl implements CoursesDAO {
	
	/**
	 * 增加课程
	 * @param course
	 * @return
	 * @throws SQLException 
	 */
	public  boolean add(Courses course) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "insert into courses(name,createTime,createby,classhours,description) values(?,NOW(),?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, course.getName());
			ps.setInt(2, course.getCreateby());
			ps.setInt(3, course.getClassshuours());
			ps.setString(4, course.getDescription());
			
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
	 * 删除某课程
	 * @param id
	 * @return
	 */
	public boolean delById(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "delete from courses where id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1,id);
			
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
	 * 删除某课程的所有记录
	 * @param coursesid
	 * @return
	 */
//	public boolean delAllQuesttions(int coursesid) {
//		Connection conn = null;
//		PreparedStatement ps = null;
//		try {
//			conn = DBUtil.getConnection();
//			String sql = "delete from questionask where coursesid=?";
//			ps = conn.prepareStatement(sql);
//			ps.setInt(1, coursesid);
//			
//			int i = ps.executeUpdate();
//			if(i <= 0) {
//				return false;
//			}
//			return true;
//		} catch (SQLException e) {			
//			e.printStackTrace();
//			return false;
//		} finally {
//			if(ps != null) {
//				try {
//					ps.close();
//				} catch (SQLException e1) {
//					e1.printStackTrace();
//				}
//			}		
//			if(conn != null) {
//				try {
//					conn.close();
//				} catch (SQLException e1) {
//					e1.printStackTrace();
//				}
//			}		
//		}
//		
//	}
//	
	/**
	 * 更新课程
	 * @param questions
	 * @return
	 */
	public boolean update( Courses course) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "update courses set name = ?, createTime = ?, createby = ?, classhours=?,description=? where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, course.getName());
			ps.setString(2, course.getCreateTime());
			ps.setInt(3, course.getCreateby());
			ps.setInt(4, course.getClassshuours());
			ps.setString(5, course.getDescription());
			ps.setInt(6,course.getId());
			ps.executeUpdate();
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
	 * 返回全部课程
	 * @param 
	 * @return
	 */
	public List<Courses> findAll(){
		Connection conn = null ;
		PreparedStatement ps = null;
		List<Courses> list = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from  courses";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			list = new ArrayList<Courses>();
			while(rs.next()) {
				Courses c = new Courses();
				c.setName(rs.getString("name"));
				c.setCreateTime(rs.getString("createTime"));
				c.setCreateby(rs.getInt("createby"));
				c.setClassshuours(rs.getInt("classhours"));
				c.setDescription(rs.getString("description"));
				list.add(c);
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
	public Courses findById(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from courses where id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			Courses c = null;
			while(rs.next()) {
				c = new Courses();
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				c.setCreateTime(rs.getString("createtime"));
				c.setCreateby(rs.getInt("createby"));
				c.setClassshuours(rs.getInt("classhours"));
				c.setDescription(rs.getString("description"));
				
			}
			
			return c;

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
