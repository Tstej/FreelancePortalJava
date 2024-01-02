<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>

<div class="container-fluid p-3 bg-light">
	<div class="row">
		<div class="col-md-6">

			<h2 class=" text-success text-center">
				<i class="fas fa-search"></i> Find Jobs
			</h2>
		</div>
		<div class="col-md-6">
			<div class="row">
				<div class="btn-group">
					<button type="button" class="btn btn-success dropdown-toggle"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						<i class="fas fa-user-circle"></i> ${recObj.recruiterName }
					</button>
					<div class="dropdown-menu">
						<a class="dropdown-item" href="view_profile.jsp">View Profile</a> <a
							class="dropdown-item" href="edit_profile.jsp">Edit Profile</a> <a
							class="dropdown-item" href="membership.jsp">Membership</a>
						<div class="dropdown-divider"></div>
					</div>
				</div>
				<a href="../logout" class="btn btn-outline-success ml-2"><i
					class="fas fa-sign-out-alt"></i> Logout</a>
			</div>
		</div>
	</div>
</div>


<nav class="navbar navbar-expand-lg navbar-dark bg-success">
	<a class="navbar-brand" href="#">Navbar</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link" href="home.jsp"><i
					class="fas fa-home"></i> Home <span class="sr-only">(current)</span></a>
			</li>
			<li class="nav-item"><a class="nav-link" href="add_job.jsp">Add
					Jobs</a></li>

			<li class="nav-item"><a class="nav-link" href="view_job.jsp">View
					Jobs</a></li>

			<li class="nav-item"><a class="nav-link" href="candidate.jsp">Candidates</a></li>
		</ul>
	</div>
</nav>




