package com.mlcss.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.mlcss.bean.QuestionAsk;
import com.mlcss.bean.QuestionReply;
import com.mlcss.dao.QuestionReplyDAO;
import com.mlcss.dao.QuestionaskDAO;
import com.mlcss.util.DBUtil;

public class QuestionReplyDAOImpl implements QuestionReplyDAO {
	
	/**
	 * 增加评论
	 * @param question
	 * @return
	 * @throws SQLException 
	 */
	public boolean add(QuestionReply question) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "insert into questionreply(questionId,userId,content,createTime) values(?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, question.getQuestionid());
			ps.setInt(2, question.getUserid());
			ps.setString(3, question.getContent());
			ps.setTimestamp(4,new Timestamp(System.currentTimeMillis()));			
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
	 * 删除某条评论
	 * @param id
	 * @return
	 */
	public boolean delById(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "delete from questionreply where id=?";
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
	 * 删除某个答疑的所有的评论
	 * @param questionid
	 * @return
	 */
	public boolean delAllQuesttions(int questionid) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "delete from questionrelpy where  questionId=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1,questionid);
			
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
	public boolean update(QuestionReply questions) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "update questionreply set questionId = ?, userId = ?, content = ? where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1,questions.getQuestionid());
			ps.setInt(2, questions.getUserid());
			ps.setString(3, questions.getContent());
	        ps.setInt(4,questions.getId());
			
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
	 * 返回某答疑所有评论
	 * @param questionid
	 * @return
	 */
	public List<QuestionReply> findAll(int questionid) {
		Connection conn = null;
		PreparedStatement ps = null;
		List<QuestionReply> list = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from questionreply where questionId=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, questionid);
			
			ResultSet rs = ps.executeQuery();
			list = new ArrayList<QuestionReply>();
			while(rs.next()) {
				QuestionReply q = new QuestionReply();
				q.setId(rs.getInt("id"));
				q.setQuestionid(rs.getInt("questionId"));
				q.setUserid(rs.getInt("userId"));
				q.setContent(rs.getString("content"));
				q.setCreatetime(rs.getTimestamp("createTime"));
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
	public QuestionReply findById(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from questionreply where id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			QuestionReply q = null;
			while(rs.next()) {
				q = new QuestionReply();
				q.setId(rs.getInt("id"));
				q.setQuestionid(rs.getInt("questionId"));
				q.setContent(rs.getString("content"));
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
