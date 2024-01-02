package com.recruiter.servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.JobsDao;
import com.model.Job;
import com.util.DBConnect;
@WebServlet("/recruiter/addJob")
public class AddJobs extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String ti = req.getParameter("ti");
		String de=req.getParameter("de");
		String ca = req.getParameter("ca");
		String lo = req.getParameter("lo");
		String pd = LocalDate.now().toString();
		String st = req.getParameter("st");
		int recid=Integer.parseInt(req.getParameter("rid"));
		
		Job j=new Job(ti, de, ca, lo, pd, st);
		j.setRecruiter_id(recid);
		
		JobsDao dao=new JobsDao(DBConnect.getConn());
		
		
		boolean f=dao.save(j);
		HttpSession session = req.getSession();
		if (f) {
			session.setAttribute("succMsg", "Job Added Sucessfully");
			resp.sendRedirect("add_job.jsp");
		} else {
			session.setAttribute("failedMsg", "Something Wrong on Server");
			resp.sendRedirect("add_job.jsp");
		}
		
		
	}

}
