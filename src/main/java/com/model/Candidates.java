package com.model;

public class Candidates {

	private int id;
	private int jobId;
	private int userId;
	private String fullName;
	private String email;
	private String mobno;
	private String resume;

	public Candidates() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Candidates(int jobId, int userId, String fullName, String email, String mobno, String resume) {
		super();
		this.jobId = jobId;
		this.userId = userId;
		this.fullName = fullName;
		this.email = email;
		this.mobno = mobno;
		this.resume = resume;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobno() {
		return mobno;
	}

	public void setMobno(String mobno) {
		this.mobno = mobno;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	@Override
	public String toString() {
		return "Candidates [id=" + id + ", jobId=" + jobId + ", userId=" + userId + ", fullName=" + fullName
				+ ", email=" + email + ", mobno=" + mobno + ", resume=" + resume + "]";
	}

}
