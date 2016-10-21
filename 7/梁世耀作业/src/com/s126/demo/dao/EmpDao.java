package com.s126.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.s126.demo.bean.Emp;
import com.s126.demo.util.DBUtil;

public class EmpDao {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	String sql;

	public List<Emp> getAll() {
		List<Emp> ls = new ArrayList<Emp>();
		String sql = "select ename, job, sal from Emp";
		try {
			conn = DBUtil.getCon();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Emp emp = new Emp();
				emp.setSal(rs.getInt("sal"));
				emp.setName(rs.getString("ename"));
				emp.setJob(rs.getString("job"));
				ls.add(emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ls;

	}

	public boolean delete(String ename) {
		boolean bl = false;		
		sql = "delete from Emp where ename=?";		
		try {
			// 一定要增加事务处理
			// conn.setAutoCommit(false);
			conn = DBUtil.getCon();
			ps = conn.prepareStatement(sql);
			ps.setString(1, ename);
			bl = ps.executeUpdate() > 0;
			conn.commit();

		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return bl;

	}

}
