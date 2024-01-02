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

@WebServlet("/rec_login")
public class Login extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String em = req.getParameter("em");
		String ps = req.getParameter("ps");
		RecruiterDao dao = new RecruiterDao(DBConnect.getConn());
		HttpSession session = req.getSession();

		Recruiter r = dao.Login(em, ps);
		if (r != null) {
			boolean f2 = dao.checkStatus(em);
			if (f2) {
				session.setAttribute("recObj", r);
				resp.sendRedirect("recruiter/home.jsp");
			} else {
				session.setAttribute("failedMsg", "Your Account is Not active");
				resp.sendRedirect("login.jsp");
			}

		} else {
			session.setAttribute("failedMsg", "Invalid email & Password");
			resp.sendRedirect("login.jsp");
		}

	}

}
