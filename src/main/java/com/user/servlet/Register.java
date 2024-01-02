package com.user.servlet;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.dao.UserDao;
import com.model.User;
import com.util.DBConnect;

@WebServlet("/user_reg")
public class Register extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String fn = req.getParameter("fn");
		String em = req.getParameter("em");
		String ps = req.getParameter("ps");
		String mb = req.getParameter("mb");
		String pk = req.getParameter("pk");
		String ex = req.getParameter("ex");

		User u = new User(fn, em, ps, mb, pk, ex, "Active");
		UserDao dao = new UserDao(DBConnect.getConn());
		
		HttpSession session = req.getSession();

		if (dao.checkEmail(em)) {
			boolean f = dao.save(u);
			if (f) {
				session.setAttribute("succMsg", "Register Sucessfully");
				resp.sendRedirect("register.jsp");
			} else {
				session.setAttribute("failedMsg", "Something Wrong on Server");
				resp.sendRedirect("register.jsp");
			}
		} else {
			session.setAttribute("failedMsg", "Email Id Already Exist");
			resp.sendRedirect("register.jsp");
		}

	}

}
