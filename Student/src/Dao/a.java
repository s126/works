package Dao;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import entity.Student;

public class a {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	String sql;
	public int insert(Student sent){
		sql ="insert into student(STUID, STUNAME, STUSEX, DORMITORYINDATE, DORMITORYOUTDATE, DORMITORYID) values(?,?,?,?,?,?)";
		SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd");
		int count =0;
		try{
			conn = BaseDao.getCon();
			ps = conn.prepareStatement(sql);
			ps.setString(1, sent.getStuid());
			ps.setString(2, sent.getStuname());
			ps.setString(3, sent.getStusex());
			try {
				ps.setDate(4, new java.sql.Date(sdf.parse(sent.getDORMITORYINDATE()).getTime()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				ps.setDate(5, new java.sql.Date(sdf.parse(sent.getDORMITORYOUTDATE()).getTime()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ps.setInt(6, sent.getDORMITORYID());
			count = ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			BaseDao.closeAll(conn, ps, rs);
		}
		return count;
		
	} 
	public void jg(){
		sql ="commit";
		try{
			conn = BaseDao.getCon();
			ps = conn.prepareStatement(sql);
			ps.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			BaseDao.closeAll(conn, ps, rs);
		}
	}

	
	
	public static void main(String[] args) {
		a c = new a();
		
	}
}
