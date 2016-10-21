package com.s126.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.s126.bean.Account;
import com.s126.demo.util.DBUtil;

public class TypesDao {
	
	public Map<String,String> allTypes() {
		Map<String,String> map=new HashMap<String,String>();
		String sql = "select tid, tname from types where 1=1";
		Connection conn = DBUtil.getCon();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				map.put(rs.getInt(1)+"", rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(rs, ps, conn);
		}
		
		return map;
		
		
	}
	
}
