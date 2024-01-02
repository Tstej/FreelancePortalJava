<%
response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);
%>
<%@page import="com.model.User"%>
<%@page import="com.util.DBConnect"%>
<%@page import="com.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit User</title>
<%@include file="allcss.jsp"%>
</head>
<body style="background-color: #f0f1f2;">
	<c:if test="${empty adminObj }">
		<c:redirect url="../login.jsp"></c:redirect>
	</c:if>
	<%@include file="navbar.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-md-8 offset-md-2">
				<div class="card">
					<div class="card-body">
						<%
						int id = Integer.parseInt(request.getParameter("uid"));
						UserDao dao = new UserDao(DBConnect.getConn());
						User u = dao.get(id);
						%>

						<h3 class="text-center">Edit Recruiter Details</h3>
						<form action="updateuser" method="post">
							<div class="form-row">

								<div class="form-group col-md-6">
									<label for="first name" class="form-label">Full Name </label> <input
										type="text" class="form-control form-control-sm" id="txtfname"
										name="na" required readonly value="<%=u.getName()%>">
								</div>
								<div class="form-group col-md-6">
									<label for="last name" class="form-label">Email ID </label> <input
										type="email" class="form-control form-control-sm" id="emailid"
										name="em" required readonly value="<%=u.getEmail()%>">
								</div>
							</div>
							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="last name" class="form-label">Mobile No </label> <input
										type="text" class="form-control form-control-sm" id="pwd"
										name="pwd" required readonly value="<%=u.getMobno()%>">
								</div>


								<div class="form-group col-md-6">
									<label for="last name" class="form-label">Primary Skill
									</label> <input type="text" class="form-control form-control-sm"
										id="cpwd" name="cpwd" required readonly
										value="<%=u.getPrimarySkill()%>">
								</div>

							</div>
							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="last name" class="form-label">Experience</label> <input
										type="text" class="form-control" id="txtmno" name="phno"
										required readonly value="<%=u.getExperience()%>">
								</div>

								<div class="form-group col-md-6">
									<label for="last name" class="form-label">Status</label> <select
										name="st" class="form-control">
										<option value="<%=u.getStatus()%>"><%=u.getStatus()%></option>
										<option value="Active">Active</option>
										<option value="Inactive">Inactive</option>
									</select> <small id="errPs" class="form-text text-muted"></small>
								</div>
								<input type="hidden" value="<%=u.getId()%>" name="id">
							</div>
							<button type="submit" class="btn btn-primary">Update</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>