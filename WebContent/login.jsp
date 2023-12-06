<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <base href="./">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <meta name="description" content="CoreUI - Open Source Bootstrap Admin Template">
    <meta name="author" content="Łukasz Holeczek">
    <meta name="keyword" content="Bootstrap,Admin,Template,Open,Source,jQuery,CSS,HTML,RWD,Dashboard">
    <title>Envirocarbon</title>
    <link rel="icon" type="image/png"  href="assets/logo/envirocarbon_logo.png">
    <link rel="manifest" href="assets/favicon/manifest.json">
    <meta name="msapplication-TileColor" content="#ffffff">
    <meta name="msapplication-TileImage" content="assets/favicon/ms-icon-144x144.png">
    <meta name="theme-color" content="#ffffff">
    <!-- Vendors styles-->
    <link rel="stylesheet" href="vendors/simplebar/css/simplebar.css">
    <link rel="stylesheet" href="css/vendors/simplebar.css">
    <!-- Main styles for this application-->
    <link href="css/style.css" rel="stylesheet">

    <link href="vendors/@coreui/chartjs/css/coreui-chartjs.css" rel="stylesheet">
  </head>
  <body>
	<div class="bg-light min-vh-100 d-flex flex-row align-items-center">
	  <div class="container">
	    <div class="row justify-content-center">
	      <div class="col-lg-5 text-center">
	        <div> <!-- Added mb-4 for margin-bottom and text-center class for centering -->
	          <img alt="Logo Envirocarbon" src="assets/logo/envirocarbon_logo.png" width="300">
	        </div>
	        <div class="card-group d-block d-md-flex row">
	          <div >
	            <div class="card-body" >
	              <h1>LOG IN</h1>
				  <br>
				  <div class="text-center">
	              <div class="input-group mb-3">
	                <span class="input-group-text">
	                  <svg class="icon">
	                    <use xlink:href="vendors/@coreui/icons/svg/free.svg#cil-user"></use>
	                  </svg>
	                </span>
	                <input class="form-control" type="text" placeholder="Email">
	              </div>
	              <div class="input-group mb-4">
	                <span class="input-group-text">
	                  <svg class="icon">
	                    <use xlink:href="vendors/@coreui/icons/svg/free.svg#cil-lock-locked"></use>
	                  </svg>
	                </span>
	                <input class="form-control" type="password" placeholder="Password">
	              </div>
	              </div>
	                <div>
	                  <a class="btn btn-primary px-2" type="button" href="home.jsp">LOG IN</a>
	                </div>
	                <div>
	                  New User? <a href="register.jsp">Register</a>
	                </div>
	            </div>
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
    <script>
    </script>

  </body>
</html>