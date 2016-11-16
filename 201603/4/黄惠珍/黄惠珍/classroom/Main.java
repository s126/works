package hibernate.demo.classroom;

import hibernate.BaseTest;

import java.util.List;

import org.junit.Test;

public class Main extends BaseTest {

	
	/**
	 * 制造数据
	 */
	@Test
	public void testSave() {
		Classroom c202 = new Classroom();
		c202.setCname("幺贰陆");
		c202.setCdesc("我们是一群很单纯可爱的孩子。");
		
		Student a = new Student();
		a.setName("黄胖子");
		a.setSex(1);
		a.setClassroom(c202);

		Student b = new Student();
		b.setName("李瘦子");
		b.setSex(2);
		b.setClassroom(c202);
		
		c202.getStudents().add(a);
		c202.getStudents().add(b);
		
		session.save(c202);

		session.save(a);
		session.save(b);
		
	}
	
	
	@Test
	@SuppressWarnings("unchecked")
	public void testList() {
		List<Classroom> crlist = (List<Classroom>) session.createQuery("from Classroom where rownum < 2").list();
		for(Classroom room: crlist) {
			System.out.println(room.getCname());
			System.out.println(room.getCdesc());
			System.out.println(room.getStudents().size());
		}
	}

}
