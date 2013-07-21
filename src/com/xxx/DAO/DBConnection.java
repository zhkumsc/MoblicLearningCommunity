package com.xxx.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;


/**
 * 数据库公用操作
 * 注意，修改了数据库配置文件之后要重启Tomcat
 * @author fantasy
 *
 */
public class DBConnection {
	private static String url = null;
	private static String username = null;
	private static String password = null;

	
	/**
	 *  读取配置文件给参数赋值
	 */
	static {
		Properties pro = new Properties();
		try {
			pro.load(DBConnection.class.getClassLoader().getResourceAsStream("dbinfo.properties"));
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
	 * 获得数据库实例
	 * @return 获得数据库实例
	 */
	public static Connection getConnection() {
		Connection conn = null; 
		try {
			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection(url, username, password);

		} catch (Exception e) {
			System.out.println("数据库连接失败" + e.getMessage());
		}
		return conn; 
	}

}
