package com.mlcss.dao;

import org.junit.Test;

import com.mlcss.dao.DBConnection;

/**
 * 用于测试DBConnection的单元测试类
 * @author fantasy
 *
 */
public class TestDBConnection {
	
	@Test
	public void tetsDBConnection() {
		DBConnection.getConnection();
	}
}

