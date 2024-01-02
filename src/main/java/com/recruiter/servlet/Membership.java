package com.recruiter.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.RecruiterDao;
import com.model.Recruiter;
import com.util.DBConnect;


@WebServlet("/recruiter/member")
public class Membership extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		
		RecruiterDao dao = new RecruiterDao(DBConnect.getConn());
		boolean f=dao.membership(id);
		
		Recruiter rec=dao.get(id);
		
		HttpSession session = req.getSession();
		
		if (f) {
			session.setAttribute("recObj", rec);
			session.setAttribute("succMsg", "Payment Sucessfully");
			resp.sendRedirect("membership.jsp");
		} else {
			session.setAttribute("failedMsg", "Something Wrong on Server");
			resp.sendRedirect("membership.jsp");
		}
		
		
		
	}
	
	

}
