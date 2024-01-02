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
<%@page import="com.model.Recruiter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Jobs</title>
<%@include file="allcss.jsp"%>
<style type="text/css">
a:hover {
	text-decoration: none;
}
</style>
</head>
<body style="background-color: #f0f1f2;">
	<c:if test="${empty adminObj }">
		<c:redirect url="../login.jsp"></c:redirect>
	</c:if>
	<%@include file="navbar.jsp"%>
	<div class="container p-3">
		<h2 class="text-center">All Jobs</h2>
		<c:if test="${not empty succMsg }">
			<div class="alert alert-success" role="alert">${ succMsg}</div>
			<c:remove var="succMsg" />
		</c:if>
		<c:if test="${not empty failedMsg }">
			<h5 class="text-center text-danger">${failedMsg}</h5>
			<c:remove var="failedMsg" scope="session" />
		</c:if>
		<table class="table" border="1px solid green">
			<thead class="bg-success text-white text-center">
				<tr>
					<th scope="col">Title</th>
					<th scope="col">Category</th>
					<th scope="col">Location</th>
					<th scope="col">Status</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody class="bg-white">
				<%
				JobsDao dao = new JobsDao(DBConnect.getConn());
				List<Job> list = dao.getAllByStatus();
				for (Job j : list) {
				%>
				<tr>
					<td><a href="one_job.jsp?jid=<%=j.getId()%>"><%=j.getTitle()%></a></td>
					<td><%=j.getCategory()%></td>
					<td><%=j.getLocation()%></td>
					<td><%=j.getStatus()%></td>
					<td><a href="one_job.jsp?jid=<%=j.getId()%>"
						class="btn btn-sm btn-outline-success"> View</a></td>

				</tr>
				<%
				}
				%>

			</tbody>
		</table>
	</div>

</body>
</html>