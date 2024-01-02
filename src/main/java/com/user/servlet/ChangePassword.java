package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.util.DBConnect;

@WebServlet("/chng_pass")
public class ChangePassword extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String op = req.getParameter("op");
		String np = req.getParameter("np");

		UserDao dao = new UserDao(DBConnect.getConn());
		boolean f = dao.checkPassword(op, id);
		HttpSession session = req.getSession();
		
		if (f) {
			boolean f2 = dao.changePassword(id, np);
			if (f2) {
				session.setAttribute("succMsg", "Password Change Sucessfully");
				resp.sendRedirect("password.jsp");
			} else {
				session.setAttribute("failedMsg", "Something Wrong on Server");
				resp.sendRedirect("password.jsp");
			}

		} else {
			session.setAttribute("failedMsg", "old Password is wrong");
			resp.sendRedirect("password.jsp");
		}

	}

}
