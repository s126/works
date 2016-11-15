package s126.hello.service;

import java.util.List;

import s126.hello.bean.Students;
import s126.hello.bean.Teacher;
import s126.hello.dao.STDao;

public class STService {
	
	STDao stdao = new STDao();
	/***
	 * 查询老师
	 */
	
	public List<Teacher> getAll(){
		return stdao.getAll();
	}
	
	/***
	 * 插入老师
	 */
	public boolean add(Students stus,Teacher teachers){
		return stdao.add(stus, teachers);
	}
}
