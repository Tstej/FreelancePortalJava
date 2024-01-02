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
<title>Password change Page</title>
<%@include file="all_component/allcss.jsp"%>
</head>
<body style="background-color: #f7f7f7;">
	<c:if test="${empty userObj }">
		<c:redirect url="login.jsp"></c:redirect>
	</c:if>
	<%@include file="all_component/navbar.jsp"%>

	<div class="container p-3">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">
						<form action="chng_pass" method="post">
							<h3 class="text-center">Password Change</h3>
							<c:if test="${not empty succMsg }">
								<h5 class="text-center text-success">${succMsg }</h5>
								<c:remove var="succMsg" scope="session" />
							</c:if>

							<c:if test="${not empty failedMsg }">
								<h5 class="text-center text-danger">${failedMsg }</h5>
								<c:remove var="failedMsg" scope="session" />
							</c:if>
							<input type="hidden" value="${userObj.id }" name="id">
							<div class="form-group">
								<label for="exampleInputEmail1">Enter Old Password</label> <input
									type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" required="required" name="op">

							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Enter New Password</label> <input
									type="password" class="form-control" id="exampleInputPassword1"
									required="required" name="np">
							</div>
							<div class="text-center">
								<button type="submit" class="btn btn-primary">Change
									Password</button>

							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>


	<div style="margin-top: 70px;">
		<%@include file="all_component/footer.jsp"%>
	</div>
</body>
</html>