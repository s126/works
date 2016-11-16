package s126.hello.service;

import java.util.List;

import s126.hello.bean.Classroom;
import s126.hello.dao.ClassroomDao;

public class ClassroomService {
	
	private ClassroomDao classroomDao = new ClassroomDao();

	public boolean addClassroom(Classroom classroom) {
		
		return classroomDao.addClassroom(classroom);
	}

	public List<Classroom> getClassrooms() {
		return classroomDao.getClassrooms();
	}

	public Classroom getClassroom(int cid) {
		return classroomDao.getClassroom(cid);
	}
	
}
