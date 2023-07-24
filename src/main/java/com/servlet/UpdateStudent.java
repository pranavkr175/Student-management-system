package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.conn.DbConncet;
import com.dao.StudentDao;
import com.entity.Student;
@WebServlet("/update")

public class UpdateStudent extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String name=req.getParameter("name");
		String dob=req.getParameter("dob");
		String add=req.getParameter("add");
		String qualification=req.getParameter("qualification");
		String email=req.getParameter("email");
		int id = Integer.parseInt(req.getParameter("id"));
		
		
		Student st =new Student(id, name, dob, add, qualification, email);
		System.out.println(st);
		StudentDao dao=new StudentDao(DbConncet.getCon());
		boolean f=dao.updateStudent(st);
		
		HttpSession session =req.getSession();
		
		if(f) {
			System.out.println("Student Updated");
			session.setAttribute("succMsg", "Student Updated ");
			resp.sendRedirect("index.jsp");
		}else {
			System.out.println("Student not register");
			session.setAttribute("errorMsg", "Something Wrong on server");
			resp.sendRedirect("index.jsp");
		}
		
	}

	
	
}
