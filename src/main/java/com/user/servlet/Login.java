package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.model.User;
import com.util.DBConnect;

@WebServlet("/user_login")
public class Login extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String em = req.getParameter("em");
		String ps = req.getParameter("ps");
		UserDao dao = new UserDao(DBConnect.getConn());
		HttpSession session = req.getSession();

		if ("admin@gmail.com".equals(em) && "admin".equals(ps)) {
			session.setAttribute("adminObj", new User());
			resp.sendRedirect("admin/home.jsp");
		} else {
			
			User u = dao.Login(em, ps);

			if (u != null) {
				boolean f2 = dao.checkStatus(em);
				if (f2) {
					session.setAttribute("userObj", u);
					resp.sendRedirect("home.jsp?pgid="+1);
				} else {
					session.setAttribute("failedMsg", "Your Account is Not active");
					resp.sendRedirect("login.jsp");
				}
			} else {
				session.setAttribute("failedMsg", "invalid email & Password");
				resp.sendRedirect("login.jsp");
			}
			
			
		}

	}

}
