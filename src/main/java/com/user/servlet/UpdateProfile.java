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

@WebServlet("/updateprofile")
public class UpdateProfile extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String na = req.getParameter("na");
		String em = req.getParameter("em");
		String mb = req.getParameter("mb");
		String ps = req.getParameter("ps");
		String ex = req.getParameter("ex");
		String st = "Active";

		User u = new User(id, na, em, mb, ps, ex, st);

		UserDao dao = new UserDao(DBConnect.getConn());
		HttpSession session = req.getSession();
		boolean f = dao.update(u);
		if (f) {
			session.setAttribute("succMsg", "Profile Update Sucessfully");
			resp.sendRedirect("view_profile.jsp");
		} else {
			session.setAttribute("failedMsg", "Something Wrong on Server");
			resp.sendRedirect("view_profile.jsp");
		}

	}

}
