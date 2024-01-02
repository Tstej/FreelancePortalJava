<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>


<div class="container-fluid p-3 ">
	<div class="row">
		<div class="col-md-6">

			<h2 class=" text-primary text-center">
				<i class="fas fa-search"></i> Find Jobs
			</h2>
		</div>
		<div class="col-md-6 text-center">
			<c:if test="${empty userObj  }">
				<a href="login.jsp" class="btn btn-outline-primary">Login</a>
				<a href="register.jsp" class="btn btn-primary ml-2">Sign Up</a>
			</c:if>

			<c:if test="${not empty userObj  }">
				<div class="row">
					<div class="btn-group">
						<button type="button" class="btn btn-primary dropdown-toggle"
							data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							<i class="fas fa-user-circle"></i> ${userObj.name }
						</button>
						<div class="dropdown-menu">
							<a class="dropdown-item" href="view_profile.jsp">View Profile</a>
							<a class="dropdown-item" href="edit_profile.jsp">Edit Profile</a>
							<a class="dropdown-item" href="password.jsp">Change Password</a>
							<a class="dropdown-item" href="apply_job.jsp">Applied Jobs</a>
							<div class="dropdown-divider"></div>
						</div>
					</div>
					<a href="logout" class="btn btn-outline-primary ml-2"><i
						class="fas fa-sign-out-alt"></i> Logout</a>
				</div>
			</c:if>
		</div>
	</div>
</div>

<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
	<a class="navbar-brand" href="index.jsp">Jobs Portal</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link"
				href="index.jsp"><i class="fas fa-home"></i> Home <span
					class="sr-only">(current)</span></a></li>
			<li class="nav-item"><a class="nav-link" href="home.jsp?pgid=1"><i
					class="fas fa-server"></i> Jobs</a></li>


		</ul>
	</div>
</nav>




