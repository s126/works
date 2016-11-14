package s126.hello.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.demo.util.HibernateUtil;

import s126.hello.bean.Emp;

public class EmpDao extends BaseDao {
	
	public List getJobs(String sql,String[] param) {
		List list = new  ArrayList();
		Session session = HibernateUtil.getSession();
		
		Transaction tx= session.beginTransaction();
		Query query = session.createQuery(sql);
		try {
			if(param!=null){
	            for(int i=0;i<param.length;i++){
	                query.setString(i,param[i]);    
	            }
			}
			list = query.list();
			
		} catch (Exception e) {
			if(tx!=null){
              tx.rollback();
            }
		}finally{
			if(session!=null){
		       tx.commit();
		       session.close();
		    }
		}
		return list;
	}
	
	
	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSession();
		session.save(new Emp("a", 1000, "b"));
		session.beginTransaction().commit();
		EmpDao empdao = new EmpDao();
		List ls = empdao.getJobs("select empno from Emp",null);
		System.out.println(ls);
	}

}
