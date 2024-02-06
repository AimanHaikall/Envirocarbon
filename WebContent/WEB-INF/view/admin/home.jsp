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
			<li class="nav-item"><a class="nav-link"
				href="<c:url value='admin/home' />"> <svg class="nav-icon">
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
			<li class="nav-item"><a class="nav-link"
				href="<c:url value='admin/submission/leaderboard' />"> <svg
						class="nav-icon">
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

		<div class="body flex-grow-1 px-3">
			<div class="container-lg">
				<div class="row">
					<div class="col-sm-6 col-lg-3">
						<div class="card mb-4 text-white bg-primary">
							<div
								class="card-body pb-0 d-flex justify-content-between align-items-start">
								<div>
									<div class="fs-4 fw-semibold">
										<c:out value="${totalUser}" />
										<span class="fs-6 fw-normal"> </span>
									</div>
									<div>Total Users</div>
								</div>
								<div class="dropdown">
									<button class="btn btn-transparent text-white p-0"
										type="button" data-coreui-toggle="dropdown"
										aria-haspopup="true" aria-expanded="false">
										<svg class="icon">
                        <use
												xlink:href="vendors/@coreui/icons/svg/free.svg#cil-options"></use>
                      </svg>
									</button>
									<div class="dropdown-menu dropdown-menu-end">
										<a class="dropdown-item" href="#">Action</a><a
											class="dropdown-item" href="#">Another action</a><a
											class="dropdown-item" href="#">Something else here</a>
									</div>
								</div>
							</div>
							<div class="c-chart-wrapper mt-3 mx-3" style="height: 70px;">
								<canvas class="chart" id="card-chart1" height="70"></canvas>
							</div>
						</div>
					</div>
					<!-- /.col-->
					<div class="col-sm-6 col-lg-3">
						<div class="card mb-4 text-white bg-info">
							<div
								class="card-body pb-0 d-flex justify-content-between align-items-start">
								<div>
									<div class="fs-4 fw-semibold">
										<c:out value="${sizeWater}" />
									</div>
									<div>Water Submission</div>
								</div>
								<div class="dropdown">
									<button class="btn btn-transparent text-white p-0"
										type="button" data-coreui-toggle="dropdown"
										aria-haspopup="true" aria-expanded="false">
										<svg class="icon">
                        <use
												xlink:href="vendors/@coreui/icons/svg/free.svg#cil-options"></use>
                      </svg>
									</button>
									<div class="dropdown-menu dropdown-menu-end">
										<a class="dropdown-item" href="#">Action</a><a
											class="dropdown-item" href="#">Another action</a><a
											class="dropdown-item" href="#">Something else here</a>
									</div>
								</div>
							</div>
							<div class="c-chart-wrapper mt-3 mx-3" style="height: 70px;">
								<canvas class="chart" id="card-chart2" height="70"></canvas>
							</div>
						</div>
					</div>
					<!-- /.col-->
					<div class="col-sm-6 col-lg-3">
						<div class="card mb-4 text-white bg-warning">
							<div
								class="card-body pb-0 d-flex justify-content-between align-items-start">
								<div>
									<div class="fs-4 fw-semibold">

										<c:out value="${sizeElectric}" />
									</div>
									<div>Electric Submissions</div>
								</div>
								<div class="dropdown">
									<button class="btn btn-transparent text-white p-0"
										type="button" data-coreui-toggle="dropdown"
										aria-haspopup="true" aria-expanded="false">
										<svg class="icon">
                        <use
												xlink:href="vendors/@coreui/icons/svg/free.svg#cil-options"></use>
                      </svg>
									</button>
									<div class="dropdown-menu dropdown-menu-end">
										<a class="dropdown-item" href="#">Action</a><a
											class="dropdown-item" href="#">Another action</a><a
											class="dropdown-item" href="#">Something else here</a>
									</div>
								</div>
							</div>
							<div class="c-chart-wrapper mt-3" style="height: 70px;">
								<canvas class="chart" id="card-chart3" height="70"></canvas>
							</div>
						</div>
					</div>
					<!-- /.col-->
					<div class="col-sm-6 col-lg-3">
						<div class="card mb-4 text-white bg-danger">
							<div
								class="card-body pb-0 d-flex justify-content-between align-items-start">
								<div>
									<div class="fs-4 fw-semibold">

										<c:out value="${sizeRecycle}" />
										</span>
									</div>
									<div>Recyle Submissions</div>
								</div>
								<div class="dropdown">
									<button class="btn btn-transparent text-white p-0"
										type="button" data-coreui-toggle="dropdown"
										aria-haspopup="true" aria-expanded="false">
										<svg class="icon">
                        <use
												xlink:href="vendors/@coreui/icons/svg/free.svg#cil-options"></use>
                      </svg>
									</button>
									<div class="dropdown-menu dropdown-menu-end">
										<a class="dropdown-item" href="#">Action</a><a
											class="dropdown-item" href="#">Another action</a><a
											class="dropdown-item" href="#">Something else here</a>
									</div>
								</div>
							</div>
							<div class="c-chart-wrapper mt-3 mx-3" style="height: 70px;">
								<canvas class="chart" id="card-chart4" height="70"></canvas>
							</div>
						</div>
					</div>
					<!-- /.col-->
				</div>

				<!-- /.card.mb-4-->
				<div class="row">
					<div class="col-sm-6 col-lg-4">
						<div class="card mb-4" style="-cui-card-cap-bg: #3b5998">
							<div class="card-body row text-center">
								<div class="col">
									<div class="fs-5 fw-semibold">Water</div>
									<div class="text-uppercase text-medium-emphasis small">calculation</div>
								</div>
								<div class="vr"></div>
								<div class="col">
									<div class="fs-5 fw-semibold">
										<c:out value="${totalWater}"></c:out>
									</div>
									<div class="text-uppercase text-medium-emphasis small">unit</div>
								</div>
							</div>
						</div>
					</div>
					<!-- /.col-->
					<div class="col-sm-6 col-lg-4">
						<div class="card mb-4" style="-cui-card-cap-bg: #00aced">
							<div class="card-body row text-center">
								<div class="col">
									<div class="fs-5 fw-semibold">Electric</div>
									<div class="text-uppercase text-medium-emphasis small">calculation</div>
								</div>
								<div class="vr"></div>
								<div class="col">
									<div class="fs-5 fw-semibold">
										<c:out value="${totalElectric}"></c:out>
									</div>
									<div class="text-uppercase text-medium-emphasis small">units
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- /.col-->
					<div class="col-sm-6 col-lg-4">
						<div class="card mb-4" style="-cui-card-cap-bg: #4875b4">

							<div class="card-body row text-center">
								<div class="col">
									<div class="fs-5 fw-semibold">Recycle</div>
									<div class="text-uppercase text-medium-emphasis small">calculations</div>
								</div>
								<div class="vr"></div>
								<div class="col">
									<div class="fs-5 fw-semibold">
										<c:out value="${totalRecycle}"></c:out>
									</div>
									<div class="text-uppercase text-medium-emphasis small">units</div>
								</div>
							</div>
						</div>
					</div>
					<!-- /.col-->
				</div>
				<!-- /.row-->
				<div class="row">
					<div class="col-md-12">
						<div class="card mb-4">
							<div class="card-header">User &amp; Submissions</div>
							<div class="card-body">
						
								<!-- /.row-->
								<br>
								<div class="table-responsive">
									<table class="table">
										<thead>
											<tr>
												<th>ID</th>
												<th>Water</th>
												<th>Electric</th>
												<th>Recycle</th>
												<th>User</th>
												<th>Total Score</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="submission" items="${submissions}">
												<tr>
													<td>${submission.id}</td>
													<td>${submission.resultWater}</td>
													<td>${submission.resultElectric}</td>
													<td>${submission.resultRecycle}</td>
													<td>${submission.user.name}</td>
													<td>${submission.calculateTotalResult()}</td>

												</tr>
											</c:forEach>

										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
					<!-- /.col-->
				</div>
				<!-- /.row-->
			</div>
		</div>

		<footer class="footer">
			<div>
				<a href="https://coreui.io">CoreUI </a><a href="https://coreui.io">Bootstrap
					Admin Template</a> Â© 2023 creativeLabs.
			</div>
			<div class="ms-auto">
				Powered by&nbsp;<a href="https://coreui.io/docs/">CoreUI UI
					Components</a>
			</div>
		</footer>
	</div>
</body>
</html>