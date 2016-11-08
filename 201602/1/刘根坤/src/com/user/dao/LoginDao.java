package com.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.all.util.DBUtil;
import com.user.bean.UserBean;


public class LoginDao {
	private Connection conn=null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	/**
	 * µÇÂ¼ÑéÖ¤
	 * ·µ»ØUserBean
	 */
	public UserBean login(int u_num,String u_password){
		
		
		String sql = "select u_num,u_name,u_password,u_email,u_phone,u_sex,u_identity from ta_user where u_num = ? and u_password = ?";
		conn = DBUtil.getCon();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, u_num);
			ps.setString(2, u_password);
			rs = ps.executeQuery();
			if(rs.next()){
				UserBean user = new UserBean();
				user.setU_num(rs.getInt(1));
				user.setU_name(rs.getString(2));
				user.setU_password(rs.getString(3));
				user.setU_email(rs.getString(4));
				user.setU_phone(rs.getString(5));
				user.setU_sex(rs.getString(6));
				user.setU_identity(rs.getInt(7));
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
