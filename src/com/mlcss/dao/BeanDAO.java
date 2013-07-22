package com.mlcss.dao;

import java.io.Serializable;
import java.util.List;


/**
 * ����bean��DAO��Ҫʵ������ӿ�
 * ��ɾ�Ĳ���ܡ�
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
