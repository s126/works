package s126.hello.service.copy;

import java.util.List;

import s126.hello.bean.copy.Teacher;
import s126.hello.dao.copy.TeaHibernateDao;

public class TeaService {
	private TeaHibernateDao teaDao = new TeaHibernateDao();
	
	public List<Teacher> getTeas() {
		String hql = "from Teacher";
		return teaDao.getAllTea(hql);
	}
	
	public boolean addTea(Teacher tea) {
		return teaDao.addTea(tea);
	}
}
