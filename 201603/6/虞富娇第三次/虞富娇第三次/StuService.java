package s126.hello.service.copy;

import java.util.List;

import s126.hello.bean.copy.Student;
import s126.hello.dao.copy.StuHibernateDao;
import s126.hello.dao.copy.TeaHibernateDao;

public class StuService {
	private StuHibernateDao stuDao = new StuHibernateDao();
	public List<Student> getStus() {
		String hql = "from Student";
		return stuDao.getAllStu(hql);
	}
	
	public boolean  addStu(Student stu) {
		return stuDao.addStu(stu);
	}
}
