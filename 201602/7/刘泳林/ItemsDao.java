package s126.hello.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import s126.hello.bean.Item;
import s126.hello.util.HibernateUtil;


/**
 * Dao 是进行数据库连接的类
 */
public class ItemsDao extends BaseDao {

	public List<Item> getByStatus(int status) {
		
		Session session = null;
		Transaction transaction = null;
		
		try{
			session = HibernateUtil.getSession();
			session.beginTransaction();
			String sql  = "select id, name, price, ctime, status from items_info "
				+ "where status ="+status+" ";
			
			Query query = session.createSQLQuery(sql).addEntity(Item.class);
			
			List<Item> list = query.list();
			
			System.out.println(list);
			
			transaction.commit();
			
			return list;
		}catch(Exception e){
			transaction.rollback();
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}
	}
}
