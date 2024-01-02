package com.user.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.dao.CandidatesDao;
import com.dao.JobsDao;
import com.model.Candidates;
import com.util.DBConnect;

@WebServlet("/apply_job")
@MultipartConfig
public class ApplyJob extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int jid = Integer.parseInt(req.getParameter("jid"));
		int uid = Integer.parseInt(req.getParameter("uid"));
		String nm = req.getParameter("na");
		String em = req.getParameter("em");
		String mb = req.getParameter("mb");
		Part p = req.getPart("re");
		String re = p.getSubmittedFileName();

		Candidates ca = new Candidates(jid, uid, nm, em, mb, re);
		// System.out.println(ca);

		CandidatesDao dao = new CandidatesDao(DBConnect.getConn());
		boolean f = dao.save(ca);

		HttpSession session = req.getSession();
		if (f) {
			String resumePath = req.getServletContext().getRealPath("") + "resume" + File.separator + re;
			 System.out.println(resumePath);
			File file = new File(resumePath);
			p.write(resumePath);

			session.setAttribute("succMsg", "Job Applied Sucessfully");
			resp.sendRedirect("one_job.jsp?jid=" + jid);
		} else {
			session.setAttribute("failedMsg", "Something Wrong on Server");
			resp.sendRedirect("one_job.jsp?jid=" + jid);
		}

	}

}
