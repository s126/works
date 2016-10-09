package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.a;
import entity.*;


@WebServlet("/add.do")
public class add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public add() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Student stu=new Student();
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String sex=request.getParameter("sex");
		String date1=request.getParameter("date1");
		String date2=request.getParameter("date2");
		System.out.println(Integer.parseInt(request.getParameter("s2")));
		int s2  =Integer.parseInt(request.getParameter("s2"));
		System.out.println(s2);
		stu.setStuid(id);
		stu.setStuname(name);
		stu.setStusex(sex);
		stu.setDORMITORYINDATE(date1);
		//stu.setDormitoryindate(s2);
		stu.setDORMITORYID(s2);
		stu.setDORMITORYOUTDATE(date2);
		a ab =new a();
		int count = ab.insert(stu);
		ab.jg();
		response.sendRedirect("/Student/ShowAllServlet");
		
		

		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
