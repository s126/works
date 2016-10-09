package Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import entity.StudentInfo;

public class stuDao {
	public List<StudentInfo> getAll(){
		List<StudentInfo> ls=new ArrayList<StudentInfo>();
		String sql="select * from student";
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			conn=BaseDao.getCon();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				StudentInfo stu=new StudentInfo();
				stu.setDormitoryId(rs.getInt("dormitoryId"));
				stu.setDormitoryinDate(rs.getDate("dormitoryinDate"));
				stu.setDormitoryoutDate(rs.getDate("dormitoryoutDate"));
				stu.setStuid(rs.getString("stuid"));
				stu.setStuname(rs.getString("stuname"));
				stu.setStusex(rs.getString("stusex"));
				ls.add(stu);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			BaseDao.closeAll(conn, ps, rs);
		}
		return ls;
	}
}
