package com.my.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import com.my.bean.ClassRoom;
import com.my.bean.Student;
import com.my.dao.BaseDao;
import com.my.util.HibernateUtils;

public class ClassRoomService {
	public List<ClassRoom> getAll(){
		BaseDao bd = new BaseDao();
		return bd.findAll("from ClassRoom");
	} 
	public List<ClassRoom> getSome(int cid){
		BaseDao bd = new BaseDao();
		return bd.findAll("from ClassRoom where cid=?",cid);
	} 
	public boolean addStudent(Student stu,int cid){
		BaseDao bd = new BaseDao();
		ClassRoom c = (ClassRoom) bd.getById(ClassRoom.class, cid);
		stu.setClassRoom(c);
		c.getStudents().add(stu);
		return bd.Save(c);
	}
	public Map<Integer,String> getClassName(){
		Map<Integer,String> classNames = new HashMap<Integer, String>();
		BaseDao bd = new BaseDao();
		List<ClassRoom> classrooms = bd.findAll("from ClassRoom");
		for (ClassRoom c : classrooms) {
			classNames.put(c.getCid(), c.getName());
		}
		return classNames;
	}
}
