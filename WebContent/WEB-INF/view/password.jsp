<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="username" value="${sessionScope.username}" />
<c:set var="user" value="${sessionScope.user}" />

<!DOCTYPE html>
<html lang="en">
<head>
<base href="<%=request.getContextPath()%>/">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, shrink-to-fit=no">

<title>Envirocarbon</title>

<link rel="icon" type="image/png"
	href="assets/logo/envirocarbon_logo.png">

<meta name="msapplication-TileColor" content="#ffffff">
<meta name="msapplication-TileImage"
	content="assets/favicon/ms-icon-144x144.png">
<meta name="theme-color" content="#ffffff">

<link rel="stylesheet" href="vendors/simplebar/css/simplebar.css">
<link rel="stylesheet" href="css/vendors/simplebar.css">

<link href="css/style.css" rel="stylesheet">

<link href="vendors/@coreui/chartjs/css/coreui-chartjs.css"
	rel="stylesheet">
</head>
<body>
	<div class="sidebar sidebar-dark sidebar-fixed" id="sidebar">
		<div class="profile-section">
			<c:choose>
				<c:when test="${not empty user}">
					<!-- User Information -->
					<div class="user-info">
						<span class="user-name">${user.name}</span>
					</div>
					<div class="user-info">
						<span class="user-email">${user.email}</span>
					</div>
				</c:when>
				<c:otherwise>
					<c:redirect url="/logout" />
				</c:otherwise>
			</c:choose>

		</div>
		<ul class="sidebar-nav" data-coreui="navigation" data-simplebar="">
			<li class="nav-item"><a class="nav-link"
				href="<c:url value = "/home"/>"> <svg class="nav-icon">
              <use
							xlink:href="vendors/@coreui/icons/svg/free.svg#cil-speedometer"></use>
            </svg> Dashboard
			</a></li>
			<li class="nav-item"><a class="nav-link"
				href="<c:url value='/user' />"> <svg class="nav-icon">
                <use
							xlink:href="vendors/@coreui/icons/svg/free.svg#cil-user"></use>
              </svg> Account
			</a></li>
			<li class="nav-item"><a class="nav-link"
				href="/EnviroCarbon/submission"> <svg class="nav-icon">
              <use
							xlink:href="vendors/@coreui/icons/svg/free.svg#cil-clipboard"></use>
            </svg> Submission
			</a></li>
			<li class="nav-item"><a class="nav-link"
				href="<c:url value = "/submission/leaderboard"/>"> <svg
						class="nav-icon">
                <use
							xlink:href="vendors/@coreui/icons/svg/free.svg#cil-list-numbered"></use>
              </svg> Leaderboard
			</a></li>

			<li class="nav-item"><a class="nav-link" href="#"> <svg
						class="nav-icon">
                <use
							xlink:href="vendors/@coreui/icons/svg/free.svg#cil-settings"></use>
              </svg> Settings
			</a></li>
			<li class="nav-item"><a class="nav-link"
				href="<c:url value='/logout' />"> <svg class="nav-icon">
						<a href="<c:url value='/logout' />">Logout</a>
                <use
							xlink:href="vendors/@coreui/icons/svg/free.svg#cil-account-logout"></use>
              </svg> Log Out
			</a></li>
		</ul>
		<button class="sidebar-toggler" type="button"
			data-coreui-toggle="unfoldable"></button>
	</div>
	<div class="wrapper d-flex flex-column min-vh-100 bg-light">
		<header class="header header-sticky mb-4">
			<div class="container-fluid">
				<button class="header-toggler px-md-0 me-md-3" type="button"
					onclick="coreui.Sidebar.getInstance(document.querySelector('#sidebar')).toggle()">
					<svg class="icon icon-lg">
              <use
							xlink:href="vendors/@coreui/icons/svg/free.svg#cil-menu"></use>
            </svg>
				</button>
				<a class="header-brand d-md-none" href="#"> <svg width="118"
						height="46" alt="CoreUI Logo">
              <use xlink:href="assets/brand/coreui.svg#full"></use>
            </svg></a>
				<ul class="header-nav d-none d-md-flex">
					<li class="nav-item"><a class="nav-link" href="#">Dashboard</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Users</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Settings</a></li>
				</ul>
				<ul class="header-nav ms-auto">
					<li class="nav-item"><a class="nav-link" href="#"> <svg
								class="icon icon-lg">
                  <use
									xlink:href="vendors/@coreui/icons/svg/free.svg#cil-bell"></use>
                </svg></a></li>
					<li class="nav-item"><a class="nav-link" href="#"> <svg
								class="icon icon-lg">
                  <use
									xlink:href="vendors/@coreui/icons/svg/free.svg#cil-list-rich"></use>
                </svg></a></li>
					<li class="nav-item"><a class="nav-link" href="#"> <svg
								class="icon icon-lg">
                  <use
									xlink:href="vendors/@coreui/icons/svg/free.svg#cil-envelope-open"></use>
                </svg></a></li>
				</ul>
			</div>
			<div class="header-divider"></div>
			<div class="container-fluid">
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb my-0 ms-2">
						<li class="breadcrumb-item">
							<!-- if breadcrumb is single--> <span>Account</span>
						</li>
						<li class="breadcrumb-item active"><span>Password</span></li>
					</ol>
				</nav>
			</div>
		</header>
		<div class="container">
			<form action="<c:url value='/user/password' />" method="post">
				<div class="form-group">
					<label for="oldPassword">Old Password:</label> <input type="password"
						id="oldPassword" name="oldPassword"
						required>
				</div><div class="form-group">
					<label for="oldPassword">Password:</label> <input type="password"
						id="password" name="password"
						required>
				</div>
				<div class="form-group">
					<label for="confirmPassword">Confirm Password:</label> <input
						type="password" id="confirmPassword" name="confirmPassword"
						required>
				</div>
				<div class="button-container">
					<button type="submit" class="btn btn-success">
						<span class="cil-contrast"></span> Save
					</button>
				</div>
			</form>
		</div>
		<footer class="footer">
			<div>
				<a href="https://coreui.io">CoreUI </a><a href="https://coreui.io">Bootstrap
					Admin Template</a> © 2023 creativeLabs.
			</div>
			<div class="ms-auto">
				Powered by&nbsp;<a href="https://coreui.io/docs/">CoreUI UI
					Components</a>
			</div>
		</footer>
	</div>
	<!-- CoreUI and necessary plugins-->
	<script src="vendors/@coreui/coreui/js/coreui.bundle.min.js"></script>
	<script src="vendors/simplebar/js/simplebar.min.js"></script>
	<!-- Plugins and scripts required by this view-->
	<script src="vendors/chart.js/js/chart.min.js"></script>
	<script src="vendors/@coreui/chartjs/js/coreui-chartjs.js"></script>
	<script src="vendors/@coreui/utils/js/coreui-utils.js"></script>
	<script src="js/main.js"></script>
	<script>
		
	</script>

</body>
</html>