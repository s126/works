package hibernate.student;

import org.hibernate.Query;
import org.junit.Test;

import hibernate.BaseTest;

public class StudentTest extends BaseTest {
	public static void main(String[] args) {
		printddl();
	}
	
	
	@Test
	public void testSave() {
		Student s1 = new Student();
		s1.setStname("zhangsan");
		s1.setStno("8888888");
		s1.setClassno("S3SJ126");
		
		Student s2 = new Student();      
		s2.setStname("lishi");        
		s2.setStno("6666666");           
		s2.setClassno("S3SJ126");  
		
		
		Student s3 = new Student();      ;
		s3.setStname("wangwu");        
		s3.setStno("9999999");           
		s3.setClassno("S3SJ127");        
		
		Teacher t1 = new Teacher();
		t1.setName("new");
		t1.setTel("110");
		
		Teacher t2 = new Teacher();
		t2.setName("old");
		t2.setTel("119");
		
		t1.getStudents().add(s1);
		t1.getStudents().add(s2);

		t2.getStudents().add(s2);
		t2.getStudents().add(s3);
		
		s1.getTeachers().add(t1);
		s2.getTeachers().add(t1);
		s2.getTeachers().add(t2);
		s3.getTeachers().add(t2);
		
		session.save(s1);
		session.save(s2);
		session.save(s3);
		
		session.save(t1);
		session.save(t2);
		
	}
	
	@Test
	public void testQuery () {
		
        




		// 1. 创建一个 query 对象。注意， query 是面向对象的写法，所以，参数里是类里的属性
		Query query = session.createQuery("from Teacher r where r.name = :name");
		
		// 2. 绑定参数。注意，参数绑定有两种形式。第一种，序号绑定（?）；第二种，名字绑定(:名字)。
		query.setString("name", "old");
		
		// 3. 获取结果。用 list() 方法，返回所有结果。
		// List<Teacher> teachers = query.list();
		// teachers.get(0);



		Teacher teacher = (Teacher) query.uniqueResult();
		
		System.out.println(teacher.getStudents());

	}
	
}
