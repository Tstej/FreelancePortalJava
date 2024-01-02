package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.model.Job;

public class JobsDao {
	private Connection conn;

	public JobsDao(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean save(Job u) {
		boolean f = false;
		try {
			String sql = "insert into jobs(title,description,category,location,published_date,status,rec_id) values(?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, u.getTitle());
			ps.setString(2, u.getDescription());
			ps.setString(3, u.getCategory());
			ps.setString(4, u.getLocation());
			ps.setString(5, u.getPublishedDate());
			ps.setString(6, u.getStatus());
			ps.setInt(7, u.getRecruiter_id());

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public Job getById(int id) {
		Job u = null;
		try {
			String sql = "select * from jobs where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				u = new Job();
				u.setId(rs.getInt(1));
				u.setTitle(rs.getString(2));
				u.setDescription(rs.getString(3));
				u.setCategory(rs.getString(4));
				u.setLocation(rs.getString(5));
				u.setPublishedDate(rs.getString(6));
				u.setStatus(rs.getString(7));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return u;
	}

	public List<Job> getAllByStatus() {
		List<Job> list = new ArrayList<Job>();
		Job u = null;
		try {
			String sql = "select * from jobs where status=? order by id desc";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "Active");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				u = new Job();
				u.setId(rs.getInt(1));
				u.setTitle(rs.getString(2));
				u.setDescription(rs.getString(3));
				u.setCategory(rs.getString(4));
				u.setLocation(rs.getString(5));
				u.setPublishedDate(rs.getString(6));
				u.setStatus(rs.getString(7));
				u.setRecruiter_id(rs.getInt(8));
				list.add(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	
	public List<Job> getAllByStatuswithPage(int pid,int total) {
		List<Job> list = new ArrayList<Job>();
		Job u = null;
		try {
			String sql = "select * from jobs where status=? order by id desc LIMIT "+pid+","+total;
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "Active");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				u = new Job();
				u.setId(rs.getInt(1));
				u.setTitle(rs.getString(2));
				u.setDescription(rs.getString(3));
				u.setCategory(rs.getString(4));
				u.setLocation(rs.getString(5));
				u.setPublishedDate(rs.getString(6));
				u.setStatus(rs.getString(7));
				u.setRecruiter_id(rs.getInt(8));
				list.add(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<Job> getAllByRecId(int recid) {
		List<Job> list = new ArrayList<Job>();
		Job u = null;
		try {
			String sql = "select * from jobs where rec_id=? order by id desc";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, recid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				u = new Job();
				u.setId(rs.getInt(1));
				u.setTitle(rs.getString(2));
				u.setDescription(rs.getString(3));
				u.setCategory(rs.getString(4));
				u.setLocation(rs.getString(5));
				u.setPublishedDate(rs.getString(6));
				u.setStatus(rs.getString(7));
				u.setRecruiter_id(rs.getInt(8));
				list.add(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public int count() {
		int i=0;
		try {
			String sql = "select * from jobs where status=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "Active");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return i;
	}
	
	
	public boolean update(Job u) {
		boolean f = false;
		try {
			String sql = "update jobs set title=?,description=?,category=?,location=?,published_date=?,status=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, u.getTitle());
			ps.setString(2, u.getDescription());
			ps.setString(3, u.getCategory());
			ps.setString(4, u.getLocation());
			ps.setString(5, u.getPublishedDate());
			ps.setString(6, u.getStatus());
			ps.setInt(7, u.getId());

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public boolean delete(int id) {
		boolean f = false;
		try {
			String sql = "delete from jobs where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public boolean deleteCandidates(int id) {
		boolean f = false;
		try {
			String sql = "delete from candidates where job_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	
	
	
	
	public List<Job> search(String sql) {
		List<Job> list = new ArrayList<Job>();
		Job u = null;
		try {
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				u = new Job();
				u.setId(rs.getInt(1));
				u.setTitle(rs.getString(2));
				u.setDescription(rs.getString(3));
				u.setCategory(rs.getString(4));
				u.setLocation(rs.getString(5));
				u.setPublishedDate(rs.getString(6));
				u.setStatus(rs.getString(7));
				u.setRecruiter_id(rs.getInt(8));
				list.add(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	

}
