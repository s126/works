package s126.hello.dao;

import java.util.List;

import org.hibernate.Session;

import s126.hello.bean.Item;
import s126.hello.util.HibernateUtil;


/**
 * Dao 是进行数据库连接的类
 */
public class ItemsDao extends BaseDao {

	/*public List<Item> getByStatus(int status) {
		String sql = "select id, name, price, ctime, status from items_info "
				+ "where status = ?";

		return query(Item.class, sql, status);
	}*/

	@SuppressWarnings("unchecked")
	public List<Item> getByStatus(int status) {
		Session session = HibernateUtil.getSession();
		List<Item> itemlist = session.createQuery("select id, name, price, ctime, status from "
				+ "items_info where status = ?").list();
		session.close();
		
		return itemlist;
		
		
		
	}
}
