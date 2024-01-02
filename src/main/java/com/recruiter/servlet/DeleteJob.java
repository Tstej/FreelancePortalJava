package com.recruiter.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.JobsDao;
import com.util.DBConnect;

@WebServlet("/recruiter/deletejob")
public class DeleteJob extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("jid"));

		JobsDao dao = new JobsDao(DBConnect.getConn());
		boolean f = dao.delete(id);
		HttpSession session = req.getSession();
		if (f) {
			dao.deleteCandidates(id);
			session.setAttribute("succMsg", "Job Delete Sucessfully");
			resp.sendRedirect("view_job.jsp");
		} else {
			session.setAttribute("failedMsg", "Something Wrong on Server");
			resp.sendRedirect("view_job.jsp");
		}

	}

}
