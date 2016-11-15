package hibernate.assoc.many2many;

import hibernate.BaseTest;

import java.util.List;

import org.hibernate.Query;
import org.junit.Test;

public class A extends BaseTest {
	public static void main(String[] args) {
		printddl();
	}
	
	
	
	@Test
	public void saveTest(){
		Teacher teacher = new Teacher();
		teacher.setName("张三");
		
		Student student = new Student();
		student.setName("ls");
		student.getTeachers().add(teacher);
		
		session.save(teacher);
		session.save(student);
	}
	
	
	//查询张三老师的所有学生
	@Test
	public void selStuForTea(){
		List<Teacher> list = session.createQuery("from Teacher").list();
		
	for (Teacher tea : list) {
			System.out.println(tea.getStudents());
		}
	}
	
	
	//查询Ls学生的所有老师
}
