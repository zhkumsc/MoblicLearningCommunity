package com.mlcss.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.mlcss.bean.QuestionAsk;
import com.mlcss.dao.QuestionaskDAO;
import com.mlcss.util.DBUtil;

public class QuestionAskDAOImpl implements QuestionaskDAO {
	
	/**
	 * 增加答疑记录
	 * @param question
	 * @return
	 * @throws SQLException 
	 */
	public boolean add(QuestionAsk question) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "insert into questionask(coursesid,title,content,createby,createtime) values(?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, question.getCoursesid());
			ps.setString(2, question.getTitle());
			ps.setString(3, question.getContent());
			ps.setInt(4, question.getCreateby());
			ps.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
			
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
	 * 删除某条答疑
	 * @param id
	 * @return
	 */
	public boolean delById(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "delete from questionask where id=?";
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
	public boolean delAllQuesttions(int coursesid) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "delete from questionask where coursesid=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, coursesid);
			
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
	 * @param questions
	 * @return
	 */
	public boolean update(QuestionAsk questions) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "update questionask set coursesId = ?, title = ?, content = ?, createby = ?, createtime = ? where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1,questions.getCoursesid());
			ps.setString(2, questions.getTitle());
			ps.setString(3, questions.getContent());
			ps.setInt(4, questions.getCreateby());
			ps.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
		    ps.setInt(6, questions.getId());
			
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
	 * 返回某课程所有答疑
	 * @param courseId
	 * @return
	 */
	public List<QuestionAsk> findall(int coursesId) {
		Connection conn = null;
		PreparedStatement ps = null;
		List<QuestionAsk> list = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from questionask where coursesId=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, coursesId);
			
			ResultSet rs = ps.executeQuery();
			list = new ArrayList<QuestionAsk>();
			while(rs.next()) {
				QuestionAsk q = new QuestionAsk();
				q.setId(rs.getInt("id"));
				q.setCoursesid(rs.getInt("coursesId"));
				q.setContent(rs.getString("content"));
				q.setCreateby(rs.getInt("createby"));
				q.setCreatetime(rs.getTimestamp("createTime"));
				q.setTitle(rs.getString("title"));
				list.add(q);
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
	public QuestionAsk findById(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from questionask where id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			QuestionAsk q = null;
			while(rs.next()) {
				q = new QuestionAsk();
				q.setId(rs.getInt("id"));
				q.setCoursesid(rs.getInt("coursesId"));
				q.setContent(rs.getString("content"));
				q.setTitle("title");
				q.setCreateby(rs.getInt("createby"));
				q.setCreatetime(rs.getTimestamp("createTime"));
				
			}
			
			return q;

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
