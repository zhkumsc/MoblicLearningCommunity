package com.mlcss.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;


/**
 * ��ݿ⹫�ò���
 * ע�⣬�޸�����ݿ������ļ�֮��Ҫ����Tomcat
 * @author fantasy
 *
 */
public class DBConnection {
	private static String url = null;
	private static String username = null;
	private static String password = null;

	
	/**
	 *  ��ȡ�����ļ������ֵ
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
	 * �����ݿ�ʵ��
	 * @return �����ݿ�ʵ��
	 */
	public static Connection getConnection() {
		Connection conn = null; 
		try {
			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection(url, username, password);

		} catch (Exception e) {
			System.out.println("��ݿ�����ʧ��" + e.getMessage());
		}
		return conn; 
	}

}
