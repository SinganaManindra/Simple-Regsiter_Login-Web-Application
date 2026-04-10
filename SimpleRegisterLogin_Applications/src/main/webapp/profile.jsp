<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
if(session.getAttribute("username") == null){
    response.sendRedirect("Login.jsp");
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
body {
	background: linear-gradient(120deg, #2980b9, #6dd5fa);
	min-height: 100vh;
}
.card {
	border-radius: 15px;
}
</style>

</head>

<body>

<div class="container mt-5">

	<div class="card shadow-lg p-4 col-md-6 mx-auto">

		<h3 class="text-center mb-4 text-primary">User Profile</h3>

		<!-- ✅ UPDATE FORM -->
		<form action="UpdateServlet" method="post">

			<div class="mb-3">
				<label>Username</label>
				<input type="text" name="username" class="form-control"
					value="<%= session.getAttribute("username") %>" readonly>
			</div>

			<div class="mb-3">
				<label>First Name</label>
				<input type="text" name="firstname" class="form-control"
					value="<%= session.getAttribute("firstname") %>">
			</div>

			<div class="mb-3">
				<label>Last Name</label>
				<input type="text" name="lastname" class="form-control"
					value="<%= session.getAttribute("lastname") %>">
			</div>

			<div class="mb-3">
				<label>Email</label>
				<input type="email" name="email" class="form-control"
					value="<%= session.getAttribute("email") %>">
			</div>

			<div class="mb-3">
				<label>Password</label>
				<input type="password" name="password" class="form-control"
					placeholder="Enter new password">
			</div>

			<div class="d-grid mb-3">
				<button type="submit" class="btn btn-primary">
					Update Profile
				</button>
			</div>

		</form>

		<hr>

		<!-- ❗ DELETE FORM (SEPARATE) -->
		<form action="DeleteServlet" method="post"
		      onsubmit="return confirm('Are you sure you want to delete your account?');">

			<input type="hidden" name="username"
				value="<%= session.getAttribute("username") %>">

			<div class="d-grid mb-3">
				<button type="submit" class="btn btn-danger">
					Delete Profile
				</button>
			</div>

		</form>

		<hr>

		<!-- Back -->
		<div class="text-center">
			<a href="DashBoard.jsp" class="btn btn-secondary">
				Back to Dashboard
			</a>
		</div>

	</div>

</div>

</body>
</html>