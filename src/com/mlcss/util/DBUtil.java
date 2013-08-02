package com.mlcss.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;


/**
 * 数据库连接
 * 
 * @author fantasy
 *
 */
public class DBUtil {
	private static String url = null;
	private static String username = null;
	private static String password = null;

	private static Connection conn=null;
	private static	PreparedStatement ps=null;
	private static ResultSet rs=null;
	/**
	 *  通过配置文件初始化
	 */
	static {
		Properties pro = new Properties();
		try {
			pro.load(DBUtil.class.getClassLoader().getResourceAsStream("dbinfo.properties"));
			url = pro.getProperty("url");
			username = pro.getProperty("username");
			password = pro.getProperty("password");
			
//System.out.println(url);
//System.out.println(username);
//System.out.println(password);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 返回数据库Connction实例
	 * @return Connection实例
	 */
	public static Connection getConnection() {
		Connection conn = null; 
		try {
			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection(url, username, password);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return conn; 
	}

	public static void close() {
		try{
			if(rs!=null){
			   rs.close();
			   rs=null;
			}
			if(ps!=null){
	           ps.close();
	           rs=null;
			}
			if(conn!=null){
	           conn.close();
	           rs=null;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
