<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Registration Form</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap 5 CDN -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>

	<div class="container-fluid mt-5">
		<div class="row">

			<!-- Left Space (3 columns) -->
			<div class="col-md-3"></div>

			<!-- Middle Form (6 columns) -->
			<div class="col-md-6">
				<div class="card shadow p-4">
					<h3 class="text-center mb-4">User Registration</h3>

					<form name="Register" action="RegisterController" method="post">

						<div class="mb-3">
							<label class="form-label">UserName</label> 
							<input type="text"
								class="form-control" name="UserName"
								placeholder="Enter username">
						</div>

						<div class="mb-3">
							<label class="form-label">FirstName</label> <input type="text"
								class="form-control" name="firstname"
								placeholder="Enter first name">
						</div>

						<div class="mb-3">
							<label class="form-label">LastName</label> <input type="text"
								class="form-control" name="LastName"
								placeholder="Enter last name">
						</div>

						<div class="mb-3">
							<label class="form-label">Email</label> <input type="email"
								class="form-control" name="Email" placeholder="Enter email">
						</div>

						<div class="mb-3">
							<label class="form-label">Password</label> <input type="password"
								class="form-control" name="Password"
								placeholder="Enter password">
						</div>

						<div class="d-grid">
							<button type="submit" class="btn btn-primary">Submit</button>
						</div>
						
						<div>
						
						<a href="./Login.jsp">Already Registered-click here to Login</a>
						</div>

					</form>

				</div>
			</div>

			<!-- Right Space (3 columns) -->
			<div class="col-md-3"></div>

		</div>
	</div>

	<!-- Bootstrap JS -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>