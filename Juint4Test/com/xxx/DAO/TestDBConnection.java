package com.xxx.DAO;

import org.junit.Test;

import com.mlcss.dao.DBConnection;

/**
 * ���ڲ���DBConnection�ĵ�Ԫ������
 * @author fantasy
 *
 */
public class TestDBConnection {
	
	@Test
	public void tetsDBConnection() {
		DBConnection.getConnection();
	}
}
