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
<%@include file="allcss.jsp"%>
<title>Register Page</title>
</head>
<body style="background-color: #f0f1f2;">
	<c:if test="${empty recObj }">
		<c:redirect url="../login.jsp"></c:redirect>
	</c:if>
	<%@include file="navbar.jsp"%>
	<div class="container p-1">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">
						<h3 class="text-center text-success">Edit Profile</h3>
						<form action="updateprofile" method="post">
							<input type="hidden" value="${recObj.id}" name="id">
							<div class="form-row">
								<div class="form-group  col-md-6">
									<label for="first name" class="form-label">Company Name</label>
									<input type="text" class="form-control" id="txtfname" name="cn"
										value="${recObj.companyName }" required>
								</div>

								<div class="form-group col-md-6">
									<label for="first name" class="form-label">Recruiter
										Name</label> <input type="text" class="form-control" id="txtfname"
										name="rn" required value="${recObj.recruiterName }">
								</div>

							</div>
							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="last name" class="form-label">Address</label> <input
										type="text" class="form-control" id="txtlname" name="ad"
										required value="${recObj.address }">
								</div>

								<div class="form-group col-md-6">
									<label for="last name" class="form-label">Mobile No.:</label> <input
										type="number" class="form-control" id="txtmno" name="mb"
										value="${recObj.mobno }" required>
								</div>
							</div>

							<div class="form-group">
								<label for="last name" class="form-label">Email ID</label> <input
									value="${recObj.email }" type="email" class="form-control"
									id="emailid" name="em" required>
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