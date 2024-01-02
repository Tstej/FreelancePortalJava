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
<title>Add Jobs</title>
<%@include file="allcss.jsp"%>
</head>
<body style="background-color: #f0f1f2;">
	<c:if test="${empty recObj }">
		<c:redirect url="../login.jsp"></c:redirect>
	</c:if>

	<c:if test="${recObj.payment eq 'No' }">
		<script>
			alert("You Are Not Gold Membership");
			window.location.href = "membership.jsp";
		</script>
	</c:if>

	<%@include file="navbar.jsp"%>
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


						<h5>Add Jobs</h5>
					</div>
					<form action="addJob" method="post">
						<input type="hidden" value="${recObj.id }" name="rid">

						<div class="form-group">
							<label>Enter Title</label> <input type="text" name="ti" required
								class="form-control">
						</div>
						<div class="form-row">
							<div class="form-group col-md-4">
								<label>Location</label> <select name="lo" class="custom-select " required
									id="inlineFormCustomSelectPref">
									<option value="">choose...</option>
									<option value="Banglore">Pune</option>
									<option value="Chennai">Chennai</option>
									<option value="Hydrabad">Hydrabad</option>
									<option value="Bhubaneswar">Mumbai</option>
									<option value="Delhi">Delhi</option>

								</select>
							</div>
							<div class="form-group col-md-4">
								<label>Category</label> <select class="custom-select "
									id="inlineFormCustomSelectPref" name="ca">
									<option value="">Choose...</option>
									<option value="IT">IT</option>
									<option value="Devloper">Devloper</option>
									<option value="Banking">Banking</option>
									<option value="Engineer">Engineer</option>
									<option value="Teacher">Teacher</option>
									<option value="Teacher">Artist</option>
									<option value="Teacher">Event Planner</option>
									<option value="Teacher">Fashion</option>
									<option value="Teacher">Music</option>
								</select>
							</div>

							<div class="form-group col-md-4">
								<label>Status</label> <select class="form-control" name="st">
									<option class="Active" value="Active">Active</option>
									<option class="Inactive" value="Inactive">Inactive</option>
								</select>
							</div>
						</div>

						<div class="form-group">
							<label>Enter Description</label>
							<textarea required rows="6" cols="" name="de"
								class="form-control"></textarea>
						</div>
						<button class="btn btn-success">Publish Job</button>
					</form>
				</div>
			</div>

		</div>
	</div>
</body>
</html>