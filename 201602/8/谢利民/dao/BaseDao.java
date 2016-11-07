package s126.hello.dao;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import s126.hello.util.DBUtil;

public class BaseDao {

	private static Logger log = Logger.getLogger(BaseDao.class);

	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	/**
	 * 通用的查询方法
	 * 
	 * @param clazz
	 * @param sql
	 * @param params
	 */
	public <T> List<T> query(Class<T> clazz, String sql, Object... params) {
		// 这个方法，用了泛型的知识。
		// 在方法前面加的 <T> 标志位，表明这个类中所有的 T 都是占位符。它的具体值需要在在被调用的时候会被填充上，才能具体确定。
		// 从 java 1.x 版本开始，支持可变长度的参数，用法为 "Type... typeName"，在调用的时候，那么可以代表输入的 0
		// 到多个参数。
		// 可变长度的参数，必须要放在参数列表的最后一位

		// 定义一个列表，存储后面封装出来的每一个查询结果
		List<T> list = new ArrayList<T>();

		try {
			// 打开数据库连接
			conn = DBUtil.getConn();
			// 取得数据库游标
			ps = conn.prepareStatement(sql);

			// 用 objs 参数，把 sql 里的 ? 给替换，即为游标赋值
			// 一定要判断 objs 是不是空，如果为空不加判断，会抛空指针异常 NullPointException
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i + 1, params[i]);
			}

			// 查询游标，取得结果集
			rs = ps.executeQuery();

			// MetaData，元数据，即通过这个方法得到 ResultSet 的结构，包括每个字段的类型、名称等。
			ResultSetMetaData metaData = rs.getMetaData();

			// 得到我们查询了多少个列
			int columnCount = metaData.getColumnCount();

			// 循环结果集，将结果封装到对象列表中
			while (rs.next()) {
				// 类的实例化，即创建对象有两种方法：
				// 1. Hello hello = new Hello();
				// 2. Hello hello = Hello.class.newInstance();
				T newInstance = clazz.newInstance();

				// 循环每一列，把值赋予我们上面创建的对象
				for (int i = 0; i < columnCount; i++) {
					String columnName = metaData.getColumnName(i + 1);

					// 通过反射机制，获取类中的方法
					// clazz.getFields() 获取的是所有的 public 字段，包括自己的，还有父类、父父类的。
					// clazz.getDeclaredFields() 获取的是所有的字段，包括 private 和
					// protected，但只获取在当前类中定义的。
					// java 是大小写敏感的，所以 clazz.getDeclaredField(name)，name
					// 的大小写要跟字段的大小写对应
					// 但是 Oracle 中，字段会自动转换为大写。所以需要在程序中加上相关判断。
					Field[] fields = clazz.getDeclaredFields();

					for (Field field : fields) {
						if (field.getName().equalsIgnoreCase(columnName)) {

							// 设置赋值权限，即使 field 是私有的，我们也能为之赋值
							field.setAccessible(true);

							// 如果是 int 类型的话，那么用 getInt 方法
							if (field.getType().equals(int.class)
									|| field.getType().equals(Integer.class)) {
								// 为对象的字段赋值，这是反射机制
								// 一般情况下，如果我们需要根据字符串去操纵对象，那么，就需要用到反射了。
								field.set(newInstance, rs.getInt(columnName));
							} else if (field.getType().equals(float.class)) {
								field.set(newInstance, rs.getFloat(columnName));
							} else {
								field.set(newInstance, rs.getObject(columnName));
							}
						}
					}

				}
				list.add(newInstance);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeAll(rs, ps, conn);
		}

		return list;
	}

	/**
	 * 执行 更新表操作（增，删，改）
	 * @param sql 非查询语句
	 * @param params 参数
	 * @return 是否修改成功
	 * @throws Exception
	 */
	public boolean execute(String sql, Object... params) {

		try {
			// 打开数据库连接
			conn = DBUtil.getConn();

			// 获取数据库游标
			ps = conn.prepareStatement(sql);

			// 用 objs 参数，把 sql 里的 ? 给替换，即为游标赋值
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i + 1, params[i]);
			}
			// 执行 SQL 语句，返回受影响的行
			return ps.executeUpdate() > 0;

		} catch (Exception e) {
			log.error(e);
		} finally {
			DBUtil.closeAll(null, ps, conn);
		}

		return false;
	}

}
