
<%
response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Profile</title>
<%@include file="all_component/allcss.jsp"%>
</head>
<body style="background-color: #f0f1f2;">
	<c:if test="${empty userObj }">
		<c:redirect url="login.jsp"></c:redirect>
	</c:if>
	<%@include file="all_component/navbar.jsp"%>
	<div class="container p-2">
		<div class="col-md-10 offset-md-1">
			<c:if test="${not empty succMsg }">
				<div class="alert alert-success" role="alert">${ succMsg}</div>
				<c:remove var="succMsg" />
			</c:if>
			<c:if test="${not empty failedMsg }">
				<h5 class="text-center text-danger">${failedMsg}</h5>
				<c:remove var="failedMsg" scope="session" />
			</c:if>
			<div class="card">
				<div class="card-body">
					<div class="text-center text-success">
						<i class="fas fa-user-friends fa-3x"></i>


						<h5>Edit Profile</h5>
					</div>
					<form action="updateprofile" method="post">
						<input type="hidden" name="id" value="${userObj.id }">
						<div class="form-row">
							<div class="form-group col-md-6">
								<label>Full Name</label> <input type="text" name="na" required
									class="form-control" value="${userObj.name }">
							</div>

							<div class="form-group col-md-6">
								<label>Email</label> <input type="text" name="em" required
									class="form-control" value="${userObj.email }">
							</div>
						</div>

						<div class="form-row">
							<div class="form-group col-md-6">
								<label>Mobile Number</label> <input type="text" name="mb"
									required class="form-control" value="${userObj.mobno }">
							</div>

							<div class="form-group col-md-6">
								<label>Primary Skill</label> <input type="text" name="ps"
									required class="form-control" value="${userObj.primarySkill }">
							</div>


						</div>


						<div class="form-group">
							<label>Experience</label> <input type="text" name="ex" required
								class="form-control" value="${userObj.experience }">
						</div>

						<div class="col-md-3 offset-md-5">
							<button class="btn btn-primary">Update Profile</button>
						</div>


					</form>
				</div>
			</div>

		</div>
	</div>
</body>
</html>