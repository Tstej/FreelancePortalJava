<%
response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);
%>
<%@page import="com.model.User"%>
<%@page import="java.util.List"%>
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
<title>User Page</title>
<%@include file="allcss.jsp"%>
</head>
<body style="background-color: #f0f1f2;">
	<c:if test="${empty adminObj }">
		<c:redirect url="../login.jsp"></c:redirect>
	</c:if>
	<%@include file="navbar.jsp"%>
	<div class="container p-3">
		<h2 class="text-center">All User</h2>
		<c:if test="${not empty failedMsg }">
			<h5 class="text-center text-danger">${failedMsg}</h5>
			<c:remove var="failedMsg" scope="session" />
		</c:if>

		<c:if test="${not empty succMsg }">
			<h5 class="text-center text-success">${succMsg}</h5>
			<c:remove var="succMsg" scope="session" />
		</c:if>
		<table class="table">
			<thead class="bg-success text-white">
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Email</th>
					<th scope="col">Mob No</th>
					<th scope="col">Primary</th>
					<th scope="col">Experience</th>
				</tr>
			</thead>
			<tbody class="bg-white">
				<%
				UserDao dao = new UserDao(DBConnect.getConn());
				List<User> list = dao.getAll();
				for (User u : list) {
				%>
				<tr>
					<td><%=u.getName()%></td>
					<td><%=u.getEmail()%></td>
					<td><%=u.getMobno()%></td>
					<td><%=u.getPrimarySkill()%></td>
					<td><%=u.getExperience()%></td>
					<%-- <td><a href="edit_user.jsp?uid=<%=u.getId()%>"
						class="btn btn-sm btn-outline-success"><i class="fas fa-edit"></i>
							Edit</a> <!-- <a href="#" class="btn btn-sm btn-outline-success"><i
							class="fas fa-trash-alt"></i> Delete</a> --></td>

				</tr> --%>
				<%
				}
				%>



			</tbody>
		</table>
	</div>
</body>
</html>