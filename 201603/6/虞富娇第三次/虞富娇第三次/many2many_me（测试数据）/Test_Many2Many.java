package hibernate.assoc.many2many_me;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

public class Test_Many2Many extends BaseTest {
	public static void main(String[] args) {
		printddl();
	}
	
	@Test
	public void saveData() {
		Teacher t1 = new Teacher();
		
		t1.setName("牛牛");
		t1.setTel(110);
		t1.setTid(3);
		
		Teacher  t2= new Teacher();
		
		t2.setName("老马");
		t2.setTel(120);
		t2.setTid(2);	
		
		
		Student s1 = new Student();
		
		s1.setName("珍");
		s1.setSid(1);
		s1.setTel(119);
		

		Student s2 = new Student();
		
		s2.setName("英");
		s2.setSid(2);
		s2.setTel(135);

		Student s3 = new Student();
		
		s3.setName("媛");
		s3.setSid(3);
		s3.setTel(150);

		Student s4 = new Student();
	
		s4.setName("凤");
		s4.setSid(4);
		s4.setTel(147);

		Student s5 = new Student();
		
		s5.setName("梦");
		s5.setSid(5);
		s5.setTel(182);
		Student s6 = new Student();
		
		s6.setName("娇 ");
		s6.setSid(6);
		s6.setTel(131);
		
		
		t1.getStudents().add(s1);
		t1.getStudents().add(s2);
		t1.getStudents().add(s3);
		t1.getStudents().add(s4);
		
		t2.getStudents().add(s1);
		t2.getStudents().add(s4);
		t2.getStudents().add(s5);
		t2.getStudents().add(s6);
		
		
		s1.getTeachers().add(t1);
		s1.getTeachers().add(t2);
		s2.getTeachers().add(t1);
		s3.getTeachers().add(t1);
		
		s4.getTeachers().add(t1);
		s4.getTeachers().add(t2);
		s5.getTeachers().add(t2);
		s6.getTeachers().add(t2);
		
		session.save(t1);
		session.save(t2);
		session.save(s1);
		session.save(s2);
		session.save(s3);
		session.save(s4);
		session.save(s5);
		session.save(s6);
		
		
		
	}
	
	@Test
	public void queryData() {
		List<Teacher> teachers = session.createQuery("from Teacher t where t.name=?").setString(0, "牛牛").list();
		for (int i = 0; i < teachers.size(); i++) {
			System.out.println(teachers.get(i).getStudents());
		}
		
		/*List<Teacher> teacher2 = session.createCriteria(Teacher.class).add(Restrictions.eq("tid", 1)).list();
		for (int i = 0; i < teacher2.size(); i++) {
			System.out.println(teacher2.get(i).getStudents());
		}
		
		Criteria criteria = session.createCriteria(Teacher.class);
		List teacher1 = criteria.list();
		for(Iterator it = teacher1.iterator(); it.hasNext(); ) {
			Teacher t = (Teacher) it.next();
			System.out.println(t.getTid()+" \t " +t.getTel() +"/" + t.getName());
		}*/
		
		List<Student> students= session.createQuery("from Student s where s.name=:name").setString("name", "凤").list();
		for (int i = 0; i < students.size(); i++) {
			System.out.println(students.get(i).getTeachers());
		}
		
		
		
	}
	
}
