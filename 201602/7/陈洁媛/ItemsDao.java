package s126.hello.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import oracle.net.aso.i;
import s126.hello.bean.Item;
import s126.hello.util.HibernateUtil;


/**
 * Dao 是进行数据库连接的类
 */
public class ItemsDao extends BaseDao {

/*	public List<Item> getByStatus(int status) {
		String sql = "select id, name, price, ctime, status from items_info "
				+ "where status = ?";

		return query(Item.class, sql, status);
	}*/
	
	public List<Item> getByStatus(int status) {
		
		Session session = HibernateUtil.getSession();
		String sql = "from Item where status = ?";
		List<Item> itemList = session.createQuery(sql).setInteger(0, status).list();
		session.close();
		return itemList;
		
		
	}
	
	
	public static void main(String[] args) {
		ItemsDao p = new ItemsDao();
		List<Item> list = p.getByStatus(-1);
		for (Item item : list) {
			System.out.println(item);
		}
	}
	

}
