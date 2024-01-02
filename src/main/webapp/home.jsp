
<%
response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);
%>
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
<title>Home Page</title>
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
	<%-- <c:if test="${empty userObj }">
		<c:redirect url="login.jsp"></c:redirect>
	</c:if> --%>
	<%@include file="all_component/navbar.jsp"%>
	<div class="back-img justify-content-center p-5">

		<form action="Search.jsp" method="post">
			<div class="form-row">
				<div class="form-group col-md-4 offset-md-1">
					<input type="search" class="form-control form-control-lg" name="sk"
						placeholder="search skill , company name">
				</div>
				<div class="form-group col-md-4">
					<select name="loc" class="custom-select form-control-lg"
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
		<h3 class="text-center text-primary">All Jobs</h3>
		<div class="row">
			<%
			int cp = Integer.parseInt(request.getParameter("pgid"));
			JobsDao dao = new JobsDao(DBConnect.getConn());
			List<Job> list = dao.getAllByStatuswithPage((cp - 1) * 4, 4);
			for (Job j : list) {
			%>

			<div class="col-md-10 offset-md-1 mt-3 jobcard p-0 ">
				<a href="one_job.jsp?jid=<%=j.getId()%>">
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
								<%
								int l = j.getDescription().length();
								if (l < 120) {
								%>
								<p>
									<i class="far fa-clipboard text-primary"></i>
									<%=j.getDescription()%>
								</p>
								<%
								} else {
								%>
								<p>
									<i class="far fa-clipboard text-primary"></i>
									<%=j.getDescription().substring(1, 180)%>
									...<span class="text-primary">Read more</span>
								</p>
								<%
								}
								%>


							</div>
						</div>
					</div>
				</a>
			</div>

			<%
			}
			%>

		</div>

		<div class="col-md-6 offset-md-5 mt-3">
			<nav aria-label="Page navigation example">
				<ul class="pagination">
					<%
					int totalJob = dao.count();
					int noOfpages = (int) Math.ceil(totalJob * 1.0 / 4);

					if (cp != 1) {
					%>
					<li class="page-item"><a class="page-link"
						href="home.jsp?pgid=<%=cp - 1%>" aria-label="Previous"> <span
							aria-hidden="true">&laquo;</span> <span class="sr-only">Previous</span>
					</a></li>


					<%
					}
					%>

					<%
					for (int in = 1; in <= noOfpages; in++) {
						if (cp == in) {
					%>
					<li class="page-item "><a
						class="page-link text-white bg-primary "
						href="home.jsp?pgid=<%=in%>"><%=in%></a></li>
					<%
					} else {
					%>
					<li class="page-item"><a class="page-link"
						href="home.jsp?pgid=<%=in%>"><%=in%></a></li>
					<%
					}

					}
					%>


					<%
					if (cp != noOfpages) {
					%>
					<li class="page-item"><a class="page-link"
						href="home.jsp?pgid=<%=cp + 1%>" aria-label="Next"> <span
							aria-hidden="true">&raquo;</span> <span class="sr-only">Next</span>
					</a></li>
					<%
					}
					%>


				</ul>
			</nav>
		</div>



	</div>



</body>
</html>