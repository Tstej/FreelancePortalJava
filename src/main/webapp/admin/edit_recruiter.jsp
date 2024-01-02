<%
response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);
%>
<%@page import="com.model.Recruiter"%>
<%@page import="com.util.DBConnect"%>
<%@page import="com.dao.RecruiterDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Recruiter</title>
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
						int id = Integer.parseInt(request.getParameter("rid"));
						RecruiterDao dao = new RecruiterDao(DBConnect.getConn());
						Recruiter r = dao.get(id);
						%>
						<h3 class="text-center">Edit Recruiter Details</h3>

						<form action="updaterec" method="post">

							<div class="form-row">

								<div class="form-group col-md-6">
									<label for="first name" class="form-label">Company Name</label>
									<input type="text" class="form-control form-control-sm"
										id="txtfname" name="cn" readonly
										value="<%=r.getCompanyName()%>">
								</div>

								<div class="form-group col-md-6">
									<label for="first name" class="form-label">Recruiter
										Name</label> <input type="text" class="form-control form-control-sm"
										id="txtfname" name="on" required
										value="<%=r.getRecruiterName()%>" readonly>
								</div>
							</div>

							<div class="form-row">

								<div class="form-group col-md-6">
									<label for="last name" class="form-label">Address</label> <input
										type="text" class="form-control" id="txtlname" name="sn"
										required value="<%=r.getAddress()%>" readonly>
								</div>

								<div class="form-group col-md-6">
									<label for="last name" class="form-label">Mobile No.:</label> <input
										type="number" class="form-control" id="txtmno" name="phno"
										required value="<%=r.getMobno()%>" readonly>
								</div>
							</div>
							<div class="form-row">
								<div class="form-group  col-md-6">
									<label for="last name" class="form-label">Email ID</label> <input
										type="email" class="form-control" id="emailid" name="em"
										required value="<%=r.getEmail()%>" readonly>
								</div>

								<div class="form-group  col-md-6">
									<label for="last name" class="form-label">Status </label> <select
										class="form-control" name="st">
										<option value="<%=r.getStatus()%>"><%=r.getStatus()%></option>
										<option>Active</option>
										<option>Inactive</option>
									</select>
								</div>
							</div>
							<input type="hidden" value="<%=r.getId()%>" name="id">

							<button type="submit" class="btn btn-success">Update</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>