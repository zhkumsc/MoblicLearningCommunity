package com.xxx.DAO;

import org.junit.Test;

import com.xxx.DAO.DBConnection;

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
