package s126.hello.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import s126.hello.bean.Item;
import s126.hello.util.HibernateUtil;


public class ItemsDao extends HibernateUtil {
	Session session = null;
	Transaction transaction = null;
	
	public List<Item> getByStatus(int status) {
		session = HibernateUtil.getSession();
		transaction = session.beginTransaction();
		String hql = "from Item where status = ?";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Item> list = query.setInteger(0, status).list();
		transaction.commit();
		session.close();
		return list;
	}
	
}
