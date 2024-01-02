package com.user.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.JobsDao;
import com.model.Job;
import com.util.DBConnect;

@WebServlet("/searchjob")
public class SearchJob extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String skill = req.getParameter("sk");
		String loc = req.getParameter("loc");

		StringBuilder sb = new StringBuilder("select * from jobs where 1=1 and status='Active' ");
		if (null != skill && !"".equals(skill)) {
			sb.append(" and title like '%"+skill+"%' or description like '%"+skill+"%'");
		}

		if (null != loc && !"".equals(loc)) {
			sb.append(" and location like '%"+loc+"%'");
		}
		
		
		JobsDao dao=new JobsDao(DBConnect.getConn());
		List<Job> list=dao.search(sb.toString());
		
		for(Job j:list)
		{
			System.out.println(j);
		}
		

	}

}
