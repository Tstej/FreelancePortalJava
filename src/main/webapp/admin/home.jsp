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
<title>Admin Home</title>

<%@include file="allcss.jsp"%>
<style type="text/css">
a {
	text-decoration: none;
	color: black;
}

a:hover {
	text-decoration: none;
	color: black;
}
</style>
</head>
<body style="background-color: #f0f1f2;">
	<c:if test="${empty adminObj }">
		<c:redirect url="../login.jsp"></c:redirect>
	</c:if>
	<%@include file="navbar.jsp"%>

	<div class="text-center">
		<img alt="" src="../img/admin.jpeg" style="width: 100%; height: 50vh">
	</div>

	<div class="container">
		<div class="row p-5">
			<div class="col-md-6">
				<a href="recruiter.jsp">
					<div class="card">
						<div class="card-body text-center ">
							<i class="fas fa-user-circle fa-3x text-success"></i><br>
							<h4>Recruiter</h4>
							-----------
						</div>
					</div>
				</a>
			</div>


			<div class="col-md-6">
				<a href="user.jsp">
					<div class="card">
						<div class="card-body text-center">
							<i class="fas fa-user-circle fa-3x text-success"></i><br>
							<h4>User</h4>
							-----------
						</div>
					</div>
				</a>
			</div>
		</div>

	</div>



</body>
</html>