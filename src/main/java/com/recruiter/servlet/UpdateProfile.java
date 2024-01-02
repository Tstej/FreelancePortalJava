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

@WebServlet("/recruiter/updateprofile")
public class UpdateProfile extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		String cn = req.getParameter("cn");
		String rn = req.getParameter("rn");
		String ad = req.getParameter("ad");
		String mb = req.getParameter("mb");
		String em = req.getParameter("em");

		Recruiter r = new Recruiter(cn, rn, ad, mb, em, "", "Inactive", "No");
		// System.out.println(r);
		r.setId(id);
		RecruiterDao dao = new RecruiterDao(DBConnect.getConn());
		boolean f = dao.update(r);
		HttpSession session = req.getSession();

		if (f) {
			session.setAttribute("succMsg", "Profile Update Sucessfully");
			resp.sendRedirect("view_profile.jsp");
		} else {
			session.setAttribute("failedMsg", "Something Wrong on Server");
			resp.sendRedirect("view_profile.jsp");
		}

	}

}
