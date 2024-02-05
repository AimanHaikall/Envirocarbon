<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="username" value="${sessionScope.adminUsername}" />
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
			<li class="nav-item"><a class="nav-link" href="<c:url value='admin/leaderboard' />">
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
			<form action="<c:url value='/admin/user/getById'/>" method="get"
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
						<th>Name</th>
						<th>Phone Number</th>
						<th>Username</th>
						<th>Email</th>
						<th>Password</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="user" items="${users}">
						<tr>
							<td>${user.id}</td>
							<td>${user.name}</td>
							<td>${user.phoneNum}</td>
							<td>${user.username}</td>
							<td>${user.email}</td>
							<td>${user.password}</td>
							<td><a class="btn btn-primary"
								href="<c:url value='/admin/user/update?id=${user.id}'/>">Update</a>
								<a class="btn btn-danger"
								href="<c:url value='/admin/user/delete?id=${user.id}'/>">Delete</a>
							</td>
						</tr>
					</c:forEach>

					<c:if
						test="${currentView ne 'update' and currentView ne 'getById'}">
						<tr>
							<td colspan="1"></td>
							<td>
								<form action="<c:url value='/admin/user/add'/>" method="post"
									class="d-flex">
									<label for="name" class="form-label me-2">Name:</label> <input
										type="text" name="name" class="form-control" required>
							</td>
							<td><label for="phoneNum" class="form-label mx-2">Phone
									Num:</label> <input type="text" name="phoneNum" class="form-control"
								required></td>
							<td><label for="username" class="form-label mx-2">Username:</label>
								<input type="text" name="username" class="form-control" required></td>
							<td><label for="email" class="form-label mx-2">Email:</label>
								<input type="email" name="email" class="form-control" required></td>
							<td><label for="password" class="form-label mx-2">Password:</label>
								<input type="text" name="password" class="form-control" required></td>
							<td>
								<button class="btn btn-outline-primary" style="height: 70px;"
									type="submit">Add User</button>

							</td>
							</form>

						</tr>
					</c:if>

					<c:if test="${currentView eq 'update'}">
						<tr>
							<form action="<c:url value='/admin/user/update'/>" method="post">
								<input type="hidden" name="id" value="${idParam}">
								<td></td>
								<td><label for="newName" class="form-label">New
										Name:</label><input type="text" name="newName" class="form-control"></td>
								<td><label for="newPhoneNum" class="form-label mx-2">New
										Phone Num:</label> <input type="text" name="newPhoneNum"
									class="form-control"></td>
								<td><label for="newUsername" class="form-label mx-2">New
										Username:</label> <input type="text" name="newUsername"
									class="form-control"></td>
								<td><label for="newEmail" class="form-label">New
										Email:</label><input type="text" name="newEmail" class="form-control"></td>

								<td><label for="newPassword" class="form-label">New
										Password:</label><input type="text" name="newPassword"
									class="form-control"></td>
								<td>
									<button class="btn btn-success" type="submit">Update
										Program</button>
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