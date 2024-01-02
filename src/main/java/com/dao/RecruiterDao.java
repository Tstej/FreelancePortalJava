package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.model.Recruiter;

public class RecruiterDao {
	private Connection conn;

	public RecruiterDao(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean save(Recruiter u) {
		boolean f = false;
		try {
			String sql = "insert into recruiter(company_name,recruiter_name,address,mob_no,email,password,status,payment) values(?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, u.getCompanyName());
			ps.setString(2, u.getRecruiterName());
			ps.setString(3, u.getAddress());
			ps.setString(4, u.getMobno());
			ps.setString(5, u.getEmail());
			ps.setString(6, u.getPassword());
			ps.setString(7, u.getStatus());
			ps.setString(8, u.getPayment());

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public boolean checkEmail(String em) {
		boolean f = true;
		try {
			String sql = "select * from recruiter where email=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, em);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				f = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public Recruiter Login(String em, String psw) {
		Recruiter u = null;
		try {
			String sql = "select * from recruiter where email=? and password=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, em);
			ps.setString(2, psw);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				u = new Recruiter();
				u.setId(rs.getInt(1));
				u.setCompanyName(rs.getString(2));
				u.setRecruiterName(rs.getString(3));
				u.setAddress(rs.getString(4));
				u.setMobno(rs.getString(5));
				u.setEmail(rs.getString(6));
				u.setPassword(rs.getString(7));
				u.setStatus(rs.getString(8));
				u.setPayment(rs.getString(9));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return u;
	}

	public Recruiter get(int id) {
		Recruiter u = null;
		try {
			String sql = "select * from recruiter where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				u = new Recruiter();
				u.setId(rs.getInt(1));
				u.setCompanyName(rs.getString(2));
				u.setRecruiterName(rs.getString(3));
				u.setAddress(rs.getString(4));
				u.setMobno(rs.getString(5));
				u.setEmail(rs.getString(6));
				u.setPassword(rs.getString(7));
				u.setStatus(rs.getString(8));
				u.setPayment(rs.getString(9));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return u;
	}

	public List<Recruiter> getAll() {
		List<Recruiter> list = new ArrayList<Recruiter>();
		Recruiter u = null;
		try {
			String sql = "select * from recruiter order by id desc";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				u = new Recruiter();
				u.setId(rs.getInt(1));
				u.setCompanyName(rs.getString(2));
				u.setRecruiterName(rs.getString(3));
				u.setAddress(rs.getString(4));
				u.setMobno(rs.getString(5));
				u.setEmail(rs.getString(6));
				u.setPassword(rs.getString(7));
				u.setStatus(rs.getString(8));
				u.setPayment(rs.getString(9));
				list.add(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public boolean updateAdmin(int id, String st) {
		boolean f = false;
		try {
			String sql = "update recruiter set status=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, st);
			ps.setInt(2, id);

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public boolean update(Recruiter u) {
		boolean f = false;
		try {
			String sql = "update recruiter set company_name=?,recruiter_name=?,address=?,mob_no=?,email=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, u.getCompanyName());
			ps.setString(2, u.getRecruiterName());
			ps.setString(3, u.getAddress());
			ps.setString(4, u.getMobno());
			ps.setString(5, u.getEmail());
			ps.setInt(6, u.getId());

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public boolean membership(int id) {
		boolean f = false;
		try {
			String sql = "update recruiter set payment=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "Yes");
			ps.setInt(2, id);

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
			String sql = "delete from recruiter where id=?";
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

	public boolean changePassword(int id, String newpass) {
		boolean f = false;
		try {
			String sql = "update recruiter set password=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, newpass);
			ps.setInt(2, id);

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public boolean checkPassword(String psw, int id) {
		boolean f = false;
		try {
			String sql = "select * from recruiter where password=? and id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, psw);
			ps.setInt(2, id);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public boolean checkStatus(String em) {
		boolean f = false;
		try {
			String sql = "select * from recruiter where email=? and status=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, em);
			ps.setString(2, "Active");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

}
