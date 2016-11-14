package com.entity;

import java.util.HashSet;
import java.util.Set;

public class Student_entity { //学生
		private int Sid; //学生编号
		private String sname; //姓名
		private String sex; //性别
		private int  score; //成绩
		private String remove; //班级
		
		
		private Set<Teacher_entity> entities = new HashSet<Teacher_entity>();
		
		
		
		
		public String getSname() {
			return sname;
		}

		public void setSname(String sname) {
			this.sname = sname;
		}

		public Set<Teacher_entity> getEntities() {
			return entities;
		}

		public void setEntities(Set<Teacher_entity> entities) {
			this.entities = entities;
		}

		public Student_entity(String string, String string2, int i, String string3) {
			super();
		}

		public int getSid() {
			return Sid;
		}

		public void setSid(int sid) {
			Sid = sid;
		}

		public String getSex() {
			return sex;
		}

		public void setSex(String sex) {
			this.sex = sex;
		}

		public int getScore() {
			return score;
		}

		public void setScore(int score) {
			this.score = score;
		}

		public String getRemove() {
			return remove;
		}

		public void setRemove(String remove) {
			this.remove = remove;
		}

		

		
		
		
		
}
