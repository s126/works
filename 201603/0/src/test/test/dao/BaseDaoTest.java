package test.dao;

import java.util.List;

import org.junit.Test;

import s126.hello.bean.Emp;
import s126.hello.dao.BaseDao;

public class BaseDaoTest {

	@Test
	public void testInsert() throws Exception {
		String sql = "insert into Emp(ename) values('saf')";
		boolean updates = new BaseDao().execute(sql);
		System.out.println(updates);

	}

	@Test
	public void testUpdate() throws Exception {
		String sql = "update emp set ename='zzz' where ename=?";
		boolean updates = new BaseDao().execute(sql, "asd");
		System.out.println(updates);

	}

	@Test
	public void testQuery() throws Exception {
		String sql = "select ename from emp";
		List<Emp> elst = new BaseDao().query(Emp.class, sql);
		System.out.println(elst);
	}

}
