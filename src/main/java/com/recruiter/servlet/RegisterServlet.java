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

@WebServlet("/rec_register")
public class RegisterServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String cn = req.getParameter("cn");
		String rn = req.getParameter("rna");
		String ad = req.getParameter("ad");
		String mb = req.getParameter("mb");
		String em = req.getParameter("em");
		String ps = req.getParameter("ps");

		Recruiter r = new Recruiter(cn, rn, ad, mb, em, ps, "Inactive", "No");
		// System.out.println(r);

		RecruiterDao dao = new RecruiterDao(DBConnect.getConn());

		HttpSession session = req.getSession();

		if (dao.checkEmail(em)) {
			boolean f = dao.save(r);
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
