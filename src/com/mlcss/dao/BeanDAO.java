package com.mlcss.dao;

import java.io.Serializable;
import java.util.List;


/**
 * 所有beanDAO接口
 * 所有操作bean的DAO都要实现他
 * @author fantasy
 *
 */
public interface BeanDAO {
	public boolean add(Serializable bean);
	public boolean delete(Serializable bean);
	public boolean update(Serializable bean);
	public Serializable findById(int id);
	public List<Serializable> findByName(String name);
	public List<Serializable> listAll();
}
