package com.model;

public class Job {

	private int id;
	private String title;
	private String description;
	private String category;
	private String location;
	private String publishedDate;
	private String status;
	private int recruiter_id;

	public Job() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Job(int id, String title, String description, String category, String location, String publishedDate,
			String status) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.category = category;
		this.location = location;
		this.publishedDate = publishedDate;
		this.status = status;
	}

	public Job(String title, String description, String category, String location, String publishedDate,
			String status) {
		super();
		this.title = title;
		this.description = description;
		this.category = category;
		this.location = location;
		this.publishedDate = publishedDate;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public int getRecruiter_id() {
		return recruiter_id;
	}

	public void setRecruiter_id(int recruiter_id) {
		this.recruiter_id = recruiter_id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(String publishedDate) {
		this.publishedDate = publishedDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Job [id=" + id + ", title=" + title + ", description=" + description + ", category=" + category
				+ ", location=" + location + ", publishedDate=" + publishedDate + ", status=" + status + "]";
	}

}
