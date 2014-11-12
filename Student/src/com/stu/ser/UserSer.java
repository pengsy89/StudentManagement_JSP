package com.stu.ser;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stu.bean.User;
import com.stu.impl.Main;

public class UserSer extends HttpServlet {
	Main impl=new Main();
	public UserSer() {
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
		if(status.equals("login")){
			User bean=new User();
			bean.setUname(request.getParameter("uname"));
			bean.setUpass(request.getParameter("upass"));
			boolean compare=impl.compareUser(bean);		
			if(compare==true){
				HttpSession session=request.getSession();
				session.setAttribute("uname", bean.getUname());//not request.set ,so when getting it, don't use requestScope
				request.getRequestDispatcher("/jspfile/index.jsp").forward(request, response);
			}else{
				System.out.println("not connected!");
				request.setAttribute("error", "WRONG password!");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
		}else if(status.equals("signup")){
			User bean=new User();
			bean.setUname(request.getParameter("uname"));
			bean.setUpass(request.getParameter("upass"));
			boolean userexsited=impl.signup(bean);
			if(userexsited==true){
				HttpSession session=request.getSession();
				session.setAttribute("uname", bean.getUname());//not request.set ,so when getting it, don't use requestScope
				request.getRequestDispatcher("/jspfile/index.jsp").forward(request, response);
			}else{
				System.out.println("not connected!");
				request.setAttribute("error", "The user name is existed!");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
		}
	}
	public void init() throws ServletException {
	}
}
