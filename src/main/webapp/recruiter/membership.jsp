
<%@page import="com.model.Recruiter"%>
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
<title>Membership Page</title>
<style>
.error {
	color: white;
}
</style>

<%@include file="allcss.jsp"%>

</head>
<body style="background-color: #f0f1f2;">
	<c:if test="${empty recObj }">
		<c:redirect url="../login.jsp"></c:redirect>
	</c:if>
	<%@include file="navbar.jsp"%>
	<div class="container p-2">
		<div class="col-md-10 offset-md-1">
			<div class="card">
				<div class="card-body">
					<div class=" text-success">

						<%
						Recruiter recruiter = (Recruiter) session.getAttribute("recObj");
						if ("No".equals(recruiter.getPayment())) {
						%>
						<h4 class="text-danger text-center">Your Are Not Gold
							Membership, Pay Now</h4>
						<%
						} else {
						%>
						<h4 class="text-suc cess text-center">Now You Are Gold
							Membership</h4>
						<%
						}
						%>


						<c:if test="${not empty failedMsg }">
							<h5 class="text-center text-danger">${failedMsg}</h5>
							<c:remove var="failedMsg" scope="session" />
						</c:if>

						<c:if test="${not empty succMsg }">
							<h3 class="text-center text-success">${succMsg}</h3>
							<c:remove var="succMsg" scope="session" />
						</c:if>



						<div class="col-md-6 offset-md-3 mt-4">
							<div class="card shadow-lg p-3 mb-5 bg-success rounded">
								<div class="card-body text-white">

									<h5 class="text-center">Credit Card / Debit Card</h5>
									<form action="member" novalidate method="post" class="mt-4" id="cardform">
										<input type="hidden" value="${recObj.id }" name="id">
										<div class="form-group">
											<label>Enter Card Number</label> <input type="text"
												name="cno" class="form-control">
										</div>
										<div class="form-row">
											<div class="form-group col-md-6">
												<label>Cvv</label> <input type="text" name="cvv" required
													class="form-control">
											</div>
											<div class="form-group col-md-6">
												<label>Expiry Date</label> <input type="text" name="dt"
													 class="form-control" placeholder="01/01">
											</div>


										</div>
										<div class="form-group">
											<label>Card Holder Name</label> <input type="text"
												name="cname" required class="form-control">
										</div>
										<div class="form-group ">
											<label>Amount</label> <input type="text" name="title"
												 class="form-control" value="500"
												readonly="readonly">
										</div>

										<%
										if (recruiter.getPayment().equals("No")) {
										%>
										<button class=" btn btn-primary btn-block badge-pill">Pay
											Now</button>
										<%
										} else {
										%>
										<button class=" btn btn-primary btn-block badge-pill" disabled>Pay
											Now</button>
										<%
										}
										%>



									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	
	
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.3/dist/jquery.validate.js"></script>
	<script type="text/javascript" src="card.js"></script>
</body>
</html>