package com.mlcss.util;

import org.junit.Test;

import com.mlcss.util.DBUtil;

/**
 * 用于测试DBConnection的单元测试类
 * @author fantasy
 *
 */
public class TestDBUtil {
	
	@Test
	public void testGetConnection() {
		DBUtil.getConnection();
	}
}

