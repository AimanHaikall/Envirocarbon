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
					<!-- Default content for guest user or when user is not in session -->
					<div class="user-info">
						<span class="user-name">Guest</span> <span class="user-role">Guest</span>
					</div>
					<div class="user-info">
						<span class="user-email"></span>
					</div>
				</c:otherwise>
			</c:choose>
		</div>
		<ul class="sidebar-nav" data-coreui="navigation" data-simplebar="">
			<li class="nav-item"><a class="nav-link" href="index.jsp"> <svg
						class="nav-icon">
              <use
							xlink:href="vendors/@coreui/icons/svg/free.svg#cil-speedometer"></use>
            </svg> Dashboard
			</a></li>
			<li class="nav-item"><a class="nav-link" href="editProfile.jsp">
					<svg class="nav-icon">
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
			<li class="nav-item"><a class="nav-link" href="leaderboard.jsp">
					<svg class="nav-icon">
                <use
							xlink:href="vendors/@coreui/icons/svg/free.svg#cil-list-numbered"></use>
              </svg> Leaderboard
			</a></li>
			<li class="nav-item"><a class="nav-link" href="ebooks.jsp">
					<svg class="nav-icon">
                <use
							xlink:href="vendors/@coreui/icons/svg/free.svg#cil-book"></use>
              </svg> E-Books
			</a></li>
			<li class="nav-item"><a class="nav-link" href="calendar.jsp">
					<svg class="nav-icon">
                <use
							xlink:href="vendors/@coreui/icons/svg/free.svg#cil-calendar"></use>
              </svg> Calendar
			</a></li>
			<li class="nav-item"><a class="nav-link" href="settings.jsp">
					<svg class="nav-icon">
                <use
							xlink:href="vendors/@coreui/icons/svg/free.svg#cil-settings"></use>
              </svg> Settings
			</a></li>
			<li class="nav-item"><a class="nav-link" href="logout.jsp">
					<svg class="nav-icon">
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
							<!-- if breadcrumb is single-->
							<span>Home</span>
						</li>
						<li class="breadcrumb-item active"><span>Dashboard</span></li>
					</ol>
				</nav>
			</div>
		</header>

		<div class="container">
			<div class="row">
				<div class="col-md-8">
					<div>
						<iframe
							src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d10218.723941948408!2d103.6410695922391!3d1.503180835979977!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x31da9f7069682557%3A0x65f562b4eb663916!2sIskandar+Puteri%2C+Johor!5e0!3m2!1sen!2smy!4v1670349666770!5m2!1sen!2smy"
							width="600" height="450" style="border: 0;" allowfullscreen=""
							loading="lazy"></iframe>
					</div>
					<div class="mb-4">
						<h2>News</h2>
						<p>
							<b>BENGKEL PENILAIAN GERAN KOMUNITI ISKANDAR PUTERI RENDAH
								KARBON 3.0<br>23-24 Mei 2023 | Selasa - Rabu
							</b><br>
						</p>
						<p>
							Majlis Bandaraya Iskandar Puteri (MBIP) bersama-sama rakan
							strategik daripada Universiti Teknologi Malaysia (UTM), Jabatan
							Pendidikan Negeri Johor (JPNJ), Pihak Berkuasa Wilayah
							Pembangunan Iskandar (IRDA), dan SWM Environment Sdn Bhd telah
							menganjurkan Bengkel Penilaian Geran Komuniti Iskandar Puteri
							Rendah Karbon 3.0 bersama .. <a href="home.jsp">READ MORE</a>
						</p>
						<p>
							<b>BENGKEL PENILAIAN GERAN KOMUNITI ISKANDAR PUTERI RENDAH
								KARBON 3.0<br>23-24 Mei 2023 | Selasa - Rabu
							</b><br>
						</p>
						<p>
							Majlis Bandaraya Iskandar Puteri (MBIP) bersama-sama rakan
							strategik daripada Universiti Teknologi Malaysia (UTM), Jabatan
							Pendidikan Negeri Johor (JPNJ), Pihak Berkuasa Wilayah
							Pembangunan Iskandar (IRDA), dan SWM Environment Sdn Bhd telah
							menganjurkan Bengkel Penilaian Geran Komuniti Iskandar Puteri
							Rendah Karbon 3.0 bersama .. <a href="home.jsp">READ MORE</a>
						</p>
					</div>
				</div>
				<div class="col-md-4">
					<div class="statistics-container">
						<h2>GHG Emissions</h2>
						<p>Stationary Energy: xx</p>
						<p>Transportation: xx</p>
						<p>Waste: xx</p>
						<h2>Carbon Emission Status</h2>
						<p>2019 : xx</p>
						<p>2020 : xx</p>
					</div>
				</div>
			</div>
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