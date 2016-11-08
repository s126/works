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
		
		try{		//得到会话
			session = HibernateUtil.getSession();
			session.beginTransaction();//开启事务
			String sql  = "select id, name, price, ctime, status from items_info "
				+ "where status ="+status+" ";		
			List<Item> list = session.createSQLQuery(sql).addEntity(Item.class).list();
			//创建查询语句    //返回list集合。  addEntity()方法。
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
