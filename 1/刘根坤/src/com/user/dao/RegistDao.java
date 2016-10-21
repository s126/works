package com.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.all.util.DBUtil;

public class RegistDao {
	private Connection conn=null;
	private PreparedStatement ps = null;
	
	/**
	 * 
	 * 注册插入数据
	 * @param u_num 编号
	 * @param u_name 名字
	 * @param u_password 密码
	 * @param u_email 邮箱
	 * @param u_phone 电话
	 * @param u_sex 性别
	 * @return 是否注册成功
	 */
	public boolean regist(int u_num,String u_name,String u_password,String u_email,String u_phone,String u_sex){
		String sql="insert into ta_user(u_num,u_name,u_password,u_email,u_phone,u_sex) values(?,?,?,?,?,?)";
		
		conn = DBUtil.getCon();
		try {
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);
			ps.setInt(1, u_num);
			ps.setString(2, u_name);
			ps.setString(3, u_password);
			ps.setString(4, u_email);
			ps.setString(5, u_phone);
			ps.setString(6, u_sex);
			ps.execute();
			
			conn.commit();
			
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			
			return false;
		}
		
	}
}
