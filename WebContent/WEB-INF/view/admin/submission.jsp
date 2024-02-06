<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="recycle" value="${sessionScope.adminRecycle}" />
<c:set var="user" value="${sessionScope.admin}" />

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
			<li class="nav-item"><a class="nav-link" href="<c:url value='admin/home' />"> <svg
						class="nav-icon">
              <use
							xlink:href="vendors/@coreui/icons/svg/free.svg#cil-speedometer"></use>
            </svg> Dashboard
			</a></li>
			<li class="nav-item"><a class="nav-link"
				href="<c:url value='admin/user' />"> <svg class="nav-icon">
                <use
							xlink:href="vendors/@coreui/icons/svg/free.svg#cil-user"></use>
              </svg> Account
			</a></li>
			<li class="nav-item"><a class="nav-link"
				href="<c:url value='admin/submission' />"> <svg class="nav-icon">
              <use
							xlink:href="vendors/@coreui/icons/svg/free.svg#cil-clipboard"></use>
            </svg> Submission
			</a></li>
			<li class="nav-item"><a class="nav-link" href="<c:url value='admin/submission/leaderboard' />">
					<svg class="nav-icon">
                <use
							xlink:href="vendors/@coreui/icons/svg/free.svg#cil-list-numbered"></use>
              </svg> Leaderboard
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
							<!-- if breadcrumb is single--> <span>Admin</span>
						</li>
						<li class="breadcrumb-item active"><span>Dashboard</span></li>
					</ol>
				</nav>
			</div>
		</header>


<div class="container">
			<form action="<c:url value='/admin/submission/getById'/>" method="get"
				class="d-flex align-items-center">
				<div>
					<label for="id" class="form-label me-2">Search ID:</label>
				</div>
				<div>
					<div class="row">
						<div class="col-md-6">
							<input type="text" name="id" class="form-control">
						</div>
						<div class="col-md-6">
							<button class="btn btn-primary ms-1" type="submit">Search</button>
						</div>
					</div>

				</div>

			</form>
			<table class="table">
				<thead>
					<tr>
						<th>ID</th>
						<th>Water</th>
						<th>Electric</th>
						<th>Recycle</th>
						<th>User</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="submission" items="${submissions}">
						<tr>
							<td>${submission.id}</td>
							<td>${submission.resultWater}</td>
							<td>${submission.resultElectric}</td>
							<td>${submission.resultRecycle}</td>
							<td><a href="<c:url value="admin/user/getById?id=${submission.user.id}"/>">${submission.user.username}</a></td>
							<td><a class="btn btn-primary"
								href="<c:url value='/admin/submission/update?id=${submission.id}'/>">Update</a>
								<a class="btn btn-danger"
								href="<c:url value='/admin/submission/delete?id=${submission.id}'/>">Delete</a>
							</td>
						</tr>
					</c:forEach>

					<c:if test="${currentView eq 'update'}">
						<tr>
							<form action="<c:url value='/admin/submission/update'/>" method="post">
								<input type="hidden" name="id" value="${idParam}">
								<td></td>
								<td><label for="newResultWater" class="form-label">New
										Water:</label><input type="text" name="newResultWater" class="form-control"></td>
								<td><label for="newResultElectric" class="form-label mx-2">New
										Electric:</label> <input type="text" name="newResultElectric"
									class="form-control"></td>
								<td><label for="newResultRecycle" class="form-label mx-2">New
										Recycle:</label> <input type="text" name="newResultRecycle"
									class="form-control"></td>
									<td><input type="hidden" name="userid" value="${submission.user.id}"></td>
								<td>
									<button class="btn btn-success" style = "height: 50px; width: 200px" type="submit">Update
										Submission</button>
								</td>
							</form>
						</tr>
					</c:if>
				</tbody>
			</table>
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
</body>
</html>