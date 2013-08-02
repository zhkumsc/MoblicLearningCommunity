package com.mlcss.dao;

import org.junit.Test;

import com.mlcss.util.DBUtil;

/**
 * 用于测试DBConnection的单元测试类
 * @author fantasy
 *
 */
public class TestDBConnection {
	
	@Test
	public void tetsDBConnection() {
		DBUtil.getConnection();
	}
}

