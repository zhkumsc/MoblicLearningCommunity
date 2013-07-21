package com.xxx.DAO;

import java.io.Serializable;
import java.util.List;


/**
 * 所有bean的DAO都要实现这个接口
 * 增删改查基本功能。
 * @author fantasy
 *
 */
public interface BeanDAO {
	public boolean add(Serializable bean);
	public boolean delete(Serializable bean);
	public boolean update(Serializable bean);
	public Serializable findById(int id);
	public List<Serializable> listAll();
}
