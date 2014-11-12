package com.stu.ser;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stu.*;

import com.stu.impl.*;
import com.stu.bean.*;

public class StudentSer extends HttpServlet {
	Main impl=new Main();

	public StudentSer() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String status=request.getParameter("status");
		if(status.equals("createStudent")){
			Student bean=new Student();
			bean.setId(Integer.parseInt(request.getParameter("id")));//change to Integer
			bean=impl.createStudent(bean);
			RequestDispatcher dispatcher=null;
			if(bean.getId()==0){	
				request.setAttribute("isexisted", bean);
				dispatcher=request.getRequestDispatcher("/jspfile/index.jsp");
				dispatcher.forward(request, response);

			}else{
				request.setAttribute("bean", bean);
				dispatcher=request.getRequestDispatcher("/jspfile/retrieve.jsp");
				dispatcher.forward(request, response);				
			}


		}else if(status.equals("retrieveStudent")){	
			int id=Integer.parseInt(request.getParameter("id"));
			Student bean;
			bean = impl.retrieveStudent(id);
			RequestDispatcher dispatcher=null;
			if(bean.getId()==0){
				request.setAttribute("notfound", bean);
				dispatcher=request.getRequestDispatcher("/jspfile/index.jsp");
				dispatcher.forward(request, response);
				//response.sendRedirect("/HW3_Student/jspfile/notfound.html");         //redirect method!!!!
			}else{
				request.setAttribute("bean", bean);
				dispatcher=request.getRequestDispatcher("/jspfile/retrieve.jsp");
				dispatcher.forward(request, response);
			}
		}else if(status.equals("updateStudent")){
			Student bean=new Student();
			bean.setId(Integer.parseInt(request.getParameter("id")));
			bean.setFirstname(request.getParameter("firstname"));
			bean.setLastname(request.getParameter("lastname"));
			bean.setDateob(request.getParameter("dateob"));
			bean.setMajor(request.getParameter("major"));
			bean.setDescription(request.getParameter("description"));
			bean.setCourse1name(request.getParameter("course1name"));
			bean.setCourse1grade(Integer.parseInt(request.getParameter("course1grade")));
			bean.setCourse2name(request.getParameter("course2name"));
			bean.setCourse2grade(Integer.parseInt(request.getParameter("course2grade")));
			bean.setCourse3name(request.getParameter("course3name"));
			bean.setCourse3grade(Integer.parseInt(request.getParameter("course3grade")));
			bean.setCourse4name(request.getParameter("course4name"));
			bean.setCourse4grade(Integer.parseInt(request.getParameter("course4grade")));
			bean.setCourse5name(request.getParameter("course5name"));
			bean.setCourse5grade(Integer.parseInt(request.getParameter("course5grade")));			
			impl.updateStudent(bean);
		}else if(status.equals("deleteStudent")){
			int id=Integer.parseInt(request.getParameter("id"));
			impl.deleteStudent(id);			
		}else if(status.equals("logout")){
			HttpSession session=request.getSession();
			session.invalidate();
		}
	}

	public void init() throws ServletException {
	}
}
