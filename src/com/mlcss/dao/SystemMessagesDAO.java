package com.mlcss.dao;

import java.sql.SQLException;
import java.util.List;

import com.mlcss.bean.SystemMessages;

public interface SystemMessagesDAO {

	/**
	 * 增加消息
	 * @param Record
	 * @return
	 * @throws SQLException 
	 */
	public abstract boolean addMessage(SystemMessages msg);

	/**
	 * 删除某条消息
	 * @param id
	 * @return
	 */
	public abstract boolean delMessageById(int id);

	/**
	 * 删除某接受者所有消息
	 * @param courseId
	 * @return
	 */
	public abstract boolean delAllMessageByReceiverId(int receiverId);

	/**
	 * 更新某条消息
	 * @param Record
	 * @return
	 */
	public abstract boolean updateMessage(SystemMessages msg);

	/**
	 * 返回某接受者所有记录
	 * @param courseId
	 * @return
	 */
	public abstract List<SystemMessages> getAllMessageByReceiverId(int receiverId, boolean received);

	/**
	 * 返回某条记录
	 * @param id
	 * @return
	 */
	public abstract SystemMessages getMessageById(int id);

	public abstract boolean setListReceived(List<SystemMessages> list);



}