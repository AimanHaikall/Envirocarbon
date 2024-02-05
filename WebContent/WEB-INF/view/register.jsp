<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<base href="./">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<meta name="description"
	content="CoreUI - Open Source Bootstrap Admin Template">
<meta name="author" content="Łukasz Holeczek">
<meta name="keyword"
	content="Bootstrap,Admin,Template,Open,Source,jQuery,CSS,HTML,RWD,Dashboard">
<title>Envirocarbon</title>
<link rel="icon" type="image/png"
	href="assets/logo/envirocarbon_logo.png">
<link rel="manifest" href="assets/favicon/manifest.json">
<meta name="msapplication-TileColor" content="#ffffff">
<meta name="msapplication-TileImage"
	content="assets/favicon/ms-icon-144x144.png">
<meta name="theme-color" content="#ffffff">
<!-- Vendors styles-->
<link rel="stylesheet" href="vendors/simplebar/css/simplebar.css">
<link rel="stylesheet" href="css/vendors/simplebar.css">
<!-- Main styles for this application-->
<link href="css/style.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<link href="vendors/@coreui/chartjs/css/coreui-chartjs.css"
	rel="stylesheet">
</head>
<body>
	<div class="bg-light min-vh-100 d-flex flex-row align-items-center">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-lg-8">
					<center>
						<div>
							<!-- Added mb-4 for margin-bottom and text-center class for centering -->
							<img alt="Logo Envirocarbon"
								src="assets/logo/envirocarbon_logo.png" width="300">
						</div>
						<div class="card-body">
							<h1>REGISTER</h1>
					</center>
					<form id="registerForm" action="/EnviroCarbon/register"
						method="post">
						<!-- Personal Details -->
						<div class="mb-3">
							<label for="name" class="form-label">NAME</label> <input
								type="text" class="form-control" id="name" name="name" required>
						</div>
						<div class="mb-3">
							<label for="phoneNum" class="form-label">PHONE NUMBER</label> <input
								type="text" class="form-control" id="phoneNum" name="phoneNum"
								required>
						</div>
						<div class="mb-3">
							<label for="email" class="form-label">EMAIL</label> <input
								type="email" class="form-control" id="email" name="email"
								required>
						</div>
						<!-- Account Details -->
						<div class="mb-3">
							<label for="username" class="form-label">USERNAME</label> <input
								type="text" class="form-control" id="username" name="username"
								required>
						</div>
						<div class="mb-3">
							<label for="password" class="form-label">PASSWORD</label> <input
								type="password" class="form-control" id="password"
								name="password" required>
						</div>
						<div class="mb-3">
							<label for="password" class="form-label"> CONFIRM
								PASSWORD</label> <input type="password" class="form-control"
								id="cpassword" name="cpassword" required>
						</div>

						<center>
							<div>
								<button type="submit" class="btn btn-primary px-2">CREATE</button>
							</div>
						</center>

					</form>
					<br />
					<div class="text-center">
						Already have an account? <a href="/EnviroCarbon/login">Login</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>

	<!-- CoreUI and necessary plugins-->
	<script src="vendors/@coreui/coreui/js/coreui.bundle.min.js"></script>
	<script src="vendors/simplebar/js/simplebar.min.js"></script>
	<!-- Plugins and scripts required by this view-->
	<script src="vendors/chart.js/js/chart.min.js"></script>
	<script src="vendors/@coreui/chartjs/js/coreui-chartjs.js"></script>
	<script src="vendors/@coreui/utils/js/coreui-utils.js"></script>
	<script src="js/main.js"></script>

</body>
</html>
