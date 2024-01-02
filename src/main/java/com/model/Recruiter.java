package com.model;

public class Recruiter {
	private int id;
	private String companyName;
	private String recruiterName;
	private String address;
	private String mobno;
	private String email;
	private String password;
	private String status;
	private String payment;

	public Recruiter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Recruiter(int id, String companyName, String recruiterName, String address, String mobno, String email,
			String password, String status, String payment) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.recruiterName = recruiterName;
		this.address = address;
		this.mobno = mobno;
		this.email = email;
		this.password = password;
		this.status = status;
		this.payment = payment;
	}

	public Recruiter(String companyName, String recruiterName, String address, String mobno, String email,
			String password, String status, String payment) {
		super();
		this.companyName = companyName;
		this.recruiterName = recruiterName;
		this.address = address;
		this.mobno = mobno;
		this.email = email;
		this.password = password;
		this.status = status;
		this.payment = payment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getRecruiterName() {
		return recruiterName;
	}

	public void setRecruiterName(String recruiterName) {
		this.recruiterName = recruiterName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobno() {
		return mobno;
	}

	public void setMobno(String mobno) {
		this.mobno = mobno;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	@Override
	public String toString() {
		return "Recruiter [id=" + id + ", companyName=" + companyName + ", recruiterName=" + recruiterName
				+ ", address=" + address + ", mobno=" + mobno + ", email=" + email + ", password=" + password
				+ ", status=" + status + ", payment=" + payment + "]";
	}

}
