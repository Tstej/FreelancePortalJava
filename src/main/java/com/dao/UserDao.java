package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.model.User;


public class UserDao {
	private Connection conn;

	public UserDao(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean updateAdmin(int id, String st) {
		boolean f = false;
		try {
			String sql = "update user set status=? where id=?";
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
	
	public boolean save(User u) {
		boolean f = false;
		try {
			String sql = "insert into user(name,email,password,mob_no,primary_skill,experience,status) values(?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, u.getName());
			ps.setString(2, u.getEmail());
			ps.setString(3, u.getPassword());
			ps.setString(4, u.getMobno());
			ps.setString(5, u.getPrimarySkill());
			ps.setString(6, u.getExperience());
			ps.setString(7, u.getStatus());

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
			String sql = "select * from user where email=?";
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

	public User Login(String em, String psw) {
		User u = null;
		try {
			String sql = "select * from user where email=? and password=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, em);
			ps.setString(2, psw);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				u = new User();
				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setEmail(rs.getString(3));
				u.setPassword(rs.getString(4));
				u.setMobno(rs.getString(5));
				u.setPrimarySkill(rs.getString(6));
				u.setExperience(rs.getString(7));
				u.setStatus(rs.getString(8));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return u;
	}

	public User get(int id) {
		User u = null;
		try {
			String sql = "select * from user where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				u = new User();
				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setEmail(rs.getString(3));
				u.setPassword(rs.getString(4));
				u.setMobno(rs.getString(5));
				u.setPrimarySkill(rs.getString(6));
				u.setExperience(rs.getString(7));
				u.setStatus(rs.getString(8));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return u;
	}

	public List<User> getAll() {
		List<User> list = new ArrayList<User>();
		User u = null;
		try {
			String sql = "select * from user order by id desc";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				u = new User();
				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setEmail(rs.getString(3));
				u.setPassword(rs.getString(4));
				u.setMobno(rs.getString(5));
				u.setPrimarySkill(rs.getString(6));
				u.setExperience(rs.getString(7));
				u.setStatus(rs.getString(8));
				list.add(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public boolean update(User u) {
		boolean f = false;
		try {
			String sql = "update user set name=?,email=?,mob_no=?,primary_skill=?,experience=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, u.getName());
			ps.setString(2, u.getEmail());
			ps.setString(3, u.getMobno());
			ps.setString(4, u.getPrimarySkill());
			ps.setString(5, u.getExperience());
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

	public boolean delete(int id) {
		boolean f = false;
		try {
			String sql = "delete from user where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,id);

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
			String sql = "update user set password=? where id=?";
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
	
	public boolean checkPassword(String ops,int id) {
		boolean f = false;
		try {
			String sql = "select * from user where password=? and id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, ops);
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
			String sql = "select * from user where email=? and status=?";
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
