package s126.hello.dao;

import java.util.List;

import s126.hello.bean.Item;


/**
 * Dao 是进行数据库连接的类
 */
public class ItemsDao extends BaseDao {

	public List<Item> getByStatus(int status) {
		String sql = "select id, name, price, ctime, status from items_info "
				+ "where status = ?";

		return query(Item.class, sql, status);
	}

}
