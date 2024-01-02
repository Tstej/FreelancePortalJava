<%
response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);
%>
<%@page import="com.model.User"%>
<%@page import="com.model.Candidates"%>
<%@page import="com.dao.CandidatesDao"%>
<%@page import="com.model.Job"%>
<%@page import="java.util.List"%>
<%@page import="com.util.DBConnect"%>
<%@page import="com.dao.JobsDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Single Job Page</title>
<%@include file="all_component/allcss.jsp"%>
<style type="text/css">
.back-img {
	width: 100%;
	height: 20vh;
	background: linear-gradient(rgba(0, 0, 0, .4), rgba(0, 0, 0, .4)),
		url("img/job2.jpg");
	background-repeat: no-repeat;
	background-size: cover;
}

.jobcard:hover {
	/*  transform: scale(1.01); */
	/*box-shadow: 0 0 5px rgba(33, 33, 33, .2);
	cursor: pointer; */
	/* box-shadow: 0 5px  5px rgba(0,0,0,0.15);
   */
	position: relative;
	box-shadow: 0 0 8px 0 rgba(0, 0, 0, 0.3);
	transition: box-shadow 0.3s ease-in-out;
}

.jobcard a {
	text-decoration: none;
	color: black;
}

.jobcard a:hover {
	text-decoration: none;
	color: black;
}
</style>
</head>
<body style="background-color: #fffcfa">
	 <c:if test="${empty userObj }">
		<c:redirect url="login.jsp"></c:redirect>
	</c:if> 
	
	<%@include file="all_component/navbar.jsp"%>
	<div class="back-img justify-content-center p-5">

		<form action="Search.jsp" method="post">
			<div class="form-row">
				<div class="form-group col-md-4 offset-md-1">
					<input type="search" class="form-control form-control-lg"
						placeholder="search skill , company name">
				</div>
				<div class="form-group col-md-4">
					<select name="location" class="custom-select form-control-lg"
						id="inlineFormCustomSelectPref">
						<option value="">Location...</option>
						<option value="Banglore">Banglore</option>
						<option value="Chennai">Chennai</option>
						<option value="Hydrabad">Hydrabad</option>
						<option value="Bhubaneswar">Bhubaneswar</option>
						<option value="Delhi">Delhi</option>

					</select>
				</div>
				<div class="form-group col-md-2">
					<button class="btn btn-primary btn-lg">Search</button>
				</div>

			</div>
		</form>

	</div>

	<div class="container">
		<h3 class="text-center text-primary">Jobs</h3>
		<c:if test="${not empty failedMsg }">
			<h5 class="text-center text-danger">${failedMsg}</h5>
			<c:remove var="failedMsg" scope="session" />
		</c:if>

		<c:if test="${not empty succMsg }">
			<h5 class="text-center text-success">${succMsg}</h5>
			<c:remove var="succMsg" scope="session" />
		</c:if>
		<div class="row">
			<%
			int id = Integer.parseInt(request.getParameter("jid"));
			JobsDao dao = new JobsDao(DBConnect.getConn());
			Job j = dao.getById(id);
			%>

			<div class="col-md-10 offset-md-1 mt-3 jobcard p-0 ">

				<div class="card">
					<div class="card-body">

						<h5 class="ml-2"><%=j.getTitle()%></h5>
						<div class="row p-2">
							<div class="col-md-3">
								<i class="fas fa-shopping-bag text-primary"></i> Category :
								<%=j.getCategory()%>
							</div>
							<div class="col-md-3">
								<i class="fas fa-map-marker-alt text-warning"></i>
								<%=j.getLocation()%>
							</div>
							<div class="col-md-4">
								<i class="fas fa-calendar-alt text-primary"></i> Publish Date :
								<%=j.getPublishedDate()%>
							</div>
						</div>

						<div class="p-2">
							<p>
								<i class="far fa-clipboard text-primary"></i>
								<%=j.getDescription()%>
								.
							</p>

						</div>

						<div class="text-center col-md-3 offset-md-4">
							<%
							User u = (User) session.getAttribute("userObj");

							CandidatesDao dao2 = new CandidatesDao(DBConnect.getConn());
							boolean f = dao2.checkJobApplied(id, u.getId());
							if (f) {
							%>
							<button class="btn btn-success btn-block badge-pill ">Job
								Applied</button>
							<%
							} else {
							%>
							<button data-toggle="modal" data-target="#exampleModalLong"
								class="btn btn-outline-primary btn-block badge-pill ">Apply
								Now</button>
							<%
							}
							%>
						</div>

					</div>
				</div>

			</div>
		</div>
	</div>



	<!-- Modal -->
	<div class="modal fade" id="exampleModalLong" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalLongTitle"
		aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header text-center">

					<h5 class="modal-title" style="margin-left: 170px;"
						id="exampleModalLongTitle">Apply Job</h5>

					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body" style="background-color: #f0f1f2;">

					<form action="apply_job" method="post"
						enctype="multipart/form-data">
						<input type="hidden" name="jid" value="<%=id%>"> <input
							type="hidden" name="uid" value="${userObj.id }">
						<div class="form-group">
							<label>Enter Name</label> <input type="text" name="na" required
								class="form-control" value="${userObj.name }">
						</div>
						<div class="form-group">
							<label>Enter Email</label> <input type="email" name="em" required
								class="form-control" value="${userObj.email }">
						</div>
						<div class="form-group">
							<label>Enter Mobile Number</label> <input type="number" name="mb"
								required class="form-control" value="${userObj.mobno }">
						</div>
						<div class="form-group">
							<label>Upload Resume</label> <input type="file" name="re"
								required class="form-control">
						</div>
						<div class="col-md-3 offset-md-4">
							<button class="btn btn-primary">Apply Now</button>
						</div>
					</form>


				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>