package com.s126.demo.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


/**
 * ��ȡ���ر���ݿ�����
 * @author Administrator
 *
 */
public class DBUtil {
	
	
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	
	static {
		try {
			
			// �� classpath �м��� db.properties �ļ������������Ӷ��ȡ��ص���ݿ�������Ϣ��
			Properties prop = new Properties();
			InputStream in = DBUtil.class.getClassLoader().getResourceAsStream("db.properties");
			prop.load(in);
			driver = prop.getProperty("driver");
			url = prop.getProperty("url");
			user = prop.getProperty("user");
			password = prop.getProperty("password");
			
			Class.forName(driver);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		
		
	}

	public static Connection getCon() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}

	public static void closeAll(ResultSet rs, Statement ps, Connection conn) {

		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
