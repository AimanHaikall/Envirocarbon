<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<!--
    * CoreUI - Free Bootstrap Admin Template
    * @version v4.2.2
    * @link https://coreui.io/product/free-bootstrap-admin-template/
    * Copyright (c) 2023 creativeLabs Łukasz Holeczek
    * Licensed under MIT (https://github.com/coreui/coreui-free-bootstrap-admin-template/blob/main/LICENSE)
    -->
<!-- Breadcrumb-->
<html lang="en">
<head>
<base href="<%=request.getContextPath()%>/">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<meta name="description"
	content="CoreUI - Open Source Bootstrap Admin Template">
<meta name="author" content="Łukasz Holeczek">
<meta name="keyword"
	content="Bootstrap,Admin,Template,Open,Source,jQuery,CSS,HTML,RWD,Dashboard">
<title>CoreUI Free Bootstrap Admin Template</title>
<link rel="apple-touch-icon" sizes="57x57"
	href="assets/favicon/apple-icon-57x57.png">
<link rel="apple-touch-icon" sizes="60x60"
	href="assets/favicon/apple-icon-60x60.png">
<link rel="apple-touch-icon" sizes="72x72"
	href="assets/favicon/apple-icon-72x72.png">
<link rel="apple-touch-icon" sizes="76x76"
	href="assets/favicon/apple-icon-76x76.png">
<link rel="apple-touch-icon" sizes="114x114"
	href="assets/favicon/apple-icon-114x114.png">
<link rel="apple-touch-icon" sizes="120x120"
	href="assets/favicon/apple-icon-120x120.png">
<link rel="apple-touch-icon" sizes="144x144"
	href="assets/favicon/apple-icon-144x144.png">
<link rel="apple-touch-icon" sizes="152x152"
	href="assets/favicon/apple-icon-152x152.png">
<link rel="apple-touch-icon" sizes="180x180"
	href="assets/favicon/apple-icon-180x180.png">
<link rel="icon" type="image/png" sizes="192x192"
	href="assets/favicon/android-icon-192x192.png">
<link rel="icon" type="image/png" sizes="32x32"
	href="assets/favicon/favicon-32x32.png">
<link rel="icon" type="image/png" sizes="96x96"
	href="assets/favicon/favicon-96x96.png">
<link rel="icon" type="image/png" sizes="16x16"
	href="assets/favicon/favicon-16x16.png">
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
<!-- We use those styles to show code examples, you should remove them in your application.-->
<link href="css/examples.css" rel="stylesheet">
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
			</div>
			<div class="header-divider"></div>
			<div class="container-fluid">
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb my-0 ms-2">
						<li class="breadcrumb-item">
							<!-- if breadcrumb is single--> <span>Leaderboard</span>
						</li>
					</ol>
				</nav>
			</div>
		</header>
		<div class="logo">
			<img src="assets/logo/envirocarbon_logo.png" alt="Logo">
		</div>
		<div class="body flex-grow-1 px-3 ">
			<div class="container-lg">
				<div class="body flex-grow-1 px-3" style="margin-top: 40px">
					<div class="container-lg ">
						<div class="table-responsive " style="background-color: white;">
							<table class="table border mb-0">
								<thead class="table-light fw-semibold">
									<tr  class="align-middle">
										<th>Rank</th>
										<th>User</th>
										<th>Result Water</th>
										<th>Result Electric</th>
										<th>Result Recycle</th>
										<th>Total Result</th>
									</tr>
								</thead>
								<tbody>
									<!-- Iterate through your sorted submissions and display the data -->
									<!--<c:forEach var="submission" items="${submissions}">
										<tr class="align-middle" style="font-weight: bold">
											<td>${submissions.indexOf(submission) + 1}</td>
											<td>${submission.user.name}</td>
											<td><fmt:formatNumber value="${submission.resultWater}" pattern="#,##0.00" /></td>
											<td><fmt:formatNumber value="${submission.resultElectric}" pattern="#,##0.00" /></td>
											<td><fmt:formatNumber value="${submission.resultRecycle}" pattern="#,##0.00" /></td>
											<td><fmt:formatNumber value="${submission.calculateTotalResult()}" pattern="#,##0.00" /></td>
										</tr>
									</c:forEach>-->
									<c:forEach var="submission" items="${submissions}">
    <c:if test="${submission.resultWater != 0 && submission.resultElectric != 0 && submission.resultRecycle != 0}">
        <tr class="align-middle" style="font-weight: bold">
            <td>${submissions.indexOf(submission) + 1}</td>
            <td>${submission.user.name}</td>
            <td><fmt:formatNumber value="${submission.resultWater}" pattern="#,##0.00" /></td>
            <td><fmt:formatNumber value="${submission.resultElectric}" pattern="#,##0.00" /></td>
            <td><fmt:formatNumber value="${submission.resultRecycle}" pattern="#,##0.00" /></td>
            <td><fmt:formatNumber value="${submission.calculateTotalResult()}" pattern="#,##0.00" /></td>
        </tr>
    </c:if>
</c:forEach>
								</tbody>
							</table>
						</div>
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
	<script>
		
	</script>

</body>
</html>