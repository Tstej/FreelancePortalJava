package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.model.Candidates;

public class CandidatesDao {
	private Connection conn;

	public CandidatesDao(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean save(Candidates u) {
		boolean f = false;
		try {
			String sql = "insert into candidates(job_id,user_id,name,email,mob_no,resume) values(?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, u.getJobId());
			ps.setInt(2, u.getUserId());
			ps.setString(3, u.getFullName());
			ps.setString(4, u.getEmail());
			ps.setString(5, u.getMobno());
			ps.setString(6, u.getResume());

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public List<Candidates> getByJobId(int jid) {
		List<Candidates> list=new ArrayList<Candidates>();
		Candidates u = null;
		try {
			String sql = "select * from candidates where job_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, jid);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				u = new Candidates();
				u.setId(rs.getInt(1));
				u.setJobId(rs.getInt(2));
				u.setUserId(rs.getInt(3));
				u.setFullName(rs.getString(4));
				u.setEmail(rs.getString(5));
				u.setMobno(rs.getString(6));
				u.setResume(rs.getString(7));
				list.add(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public int count(int jid) {
		int row=0;
		try {
			String sql = "select * from candidates where job_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, jid);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				row++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return row;
	}
	
	

	public List<Candidates> getByUserId(int uid) {
		List<Candidates> list=new ArrayList<Candidates>();
		Candidates u = null;
		try {
			String sql = "select * from candidates where user_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, uid);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				u = new Candidates();
				u.setId(rs.getInt(1));
				u.setJobId(rs.getInt(2));
				u.setUserId(rs.getInt(3));
				u.setFullName(rs.getString(4));
				u.setEmail(rs.getString(5));
				u.setMobno(rs.getString(6));
				u.setResume(rs.getString(7));
				list.add(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean checkJobApplied(int jid, int uid) {
		boolean f = false;
		try {
			String sql = "select * from candidates where job_id=? and user_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, jid);
			ps.setInt(2, uid);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				f=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

}
