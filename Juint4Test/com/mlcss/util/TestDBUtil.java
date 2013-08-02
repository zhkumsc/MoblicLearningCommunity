package com.mlcss.util;

import java.sql.Connection;
import java.sql.ResultSet;

import org.junit.Test;

import com.mlcss.util.DBUtil;

/**
 * 用于测试DBConnection的单元测试类
 * @author fantasy
 *
 */
public class TestDBUtil {
	
	@Test
	public void tetsDBConnection() throws Exception {
		Connection conn = DBUtil.getConnection();		
		ResultSet rs = conn.createStatement().executeQuery("select * from users");
		if(rs.next()){
			System.out.println(rs.getInt(1));
		}
		System.out.println("两边同时修改了，整合是应该会冲突！");
	}
	
	System.out.println("用来展示冲突");
}
