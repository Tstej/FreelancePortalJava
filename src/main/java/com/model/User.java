package com.model;

public class User {

	private int id;
	private String name;
	private String email;
	private String password;
	private String mobno;
	private String primarySkill;
	private String experience;
	private String status;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int id, String name, String email, String password, String mobno, String primarySkill,
			String experience, String status) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.mobno = mobno;
		this.primarySkill = primarySkill;
		this.experience = experience;
		this.status = status;
	}

	public User(String name, String email, String password, String mobno, String primarySkill, String experience,
			String status) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.mobno = mobno;
		this.primarySkill = primarySkill;
		this.experience = experience;
		this.status = status;
	}

	public User(int id, String name, String email, String mobno, String primarySkill, String experience,
			String status) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.mobno = mobno;
		this.primarySkill = primarySkill;
		this.experience = experience;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobno() {
		return mobno;
	}

	public void setMobno(String mobno) {
		this.mobno = mobno;
	}

	public String getPrimarySkill() {
		return primarySkill;
	}

	public void setPrimarySkill(String primarySkill) {
		this.primarySkill = primarySkill;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ",name=" + name + ", email=" + email + ", password=" + password + ", mobno=" + mobno
				+ ", primarySkill=" + primarySkill + ", experience=" + experience + ", status=" + status + "]";
	}

}
