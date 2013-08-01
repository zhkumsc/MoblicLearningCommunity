package com.mlcss.dao;

import java.sql.SQLException;
import java.util.List;

import com.mlcss.bean.RemindUser;

public interface RemindUserDAO {

	/**
	 * 增加提醒
	 * @param Record
	 * @return
	 * @throws SQLException 
	 */
	public abstract boolean addRemind(RemindUser remind);

	/**
	 * 删除某条提醒
	 * @param id
	 * @return
	 */
	public abstract boolean delRemindById(int id);

	/**
	 * 删除某接受者所有提醒
	 * @param courseId
	 * @return
	 */
	public abstract boolean delAllRemindReceiverId(int receiverId);

	/**
	 * 更新某条提醒
	 * @param Record
	 * @return
	 */
	public abstract boolean updateRemind(RemindUser remind);

	/**
	 * 返回某接受者所有提醒
	 * @param courseId
	 * @return
	 */
	public abstract List<RemindUser> getAllRemindByReceiverId(int receiverId);

	/**
	 * 返回某条提醒
	 * @param id
	 * @return
	 */
	public abstract RemindUser getRemindById(int id);

}