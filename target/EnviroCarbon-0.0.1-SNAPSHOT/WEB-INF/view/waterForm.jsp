<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html><!--
    * CoreUI - Free Bootstrap Admin Template
    * @version v4.2.2
    * @link https://coreui.io/product/free-bootstrap-admin-template/
    * Copyright (c) 2023 creativeLabs Łukasz Holeczek
    * Licensed under MIT (https://github.com/coreui/coreui-free-bootstrap-admin-template/blob/main/LICENSE)
    --><!-- Breadcrumb-->
    <html lang="en">
      <head>
        <base href="./">
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <meta name="description" content="CoreUI - Open Source Bootstrap Admin Template">
        <meta name="author" content="Łukasz Holeczek">
        <meta name="keyword" content="Bootstrap,Admin,Template,Open,Source,jQuery,CSS,HTML,RWD,Dashboard">
        <title>CoreUI Free Bootstrap Admin Template</title>
        <link rel="apple-touch-icon" sizes="57x57" href="assets/favicon/apple-icon-57x57.png">
        <link rel="apple-touch-icon" sizes="60x60" href="assets/favicon/apple-icon-60x60.png">
        <link rel="apple-touch-icon" sizes="72x72" href="assets/favicon/apple-icon-72x72.png">
        <link rel="apple-touch-icon" sizes="76x76" href="assets/favicon/apple-icon-76x76.png">
        <link rel="apple-touch-icon" sizes="114x114" href="assets/favicon/apple-icon-114x114.png">
        <link rel="apple-touch-icon" sizes="120x120" href="assets/favicon/apple-icon-120x120.png">
        <link rel="apple-touch-icon" sizes="144x144" href="assets/favicon/apple-icon-144x144.png">
        <link rel="apple-touch-icon" sizes="152x152" href="assets/favicon/apple-icon-152x152.png">
        <link rel="apple-touch-icon" sizes="180x180" href="assets/favicon/apple-icon-180x180.png">
        <link rel="icon" type="image/png" sizes="192x192" href="assets/favicon/android-icon-192x192.png">
        <link rel="icon" type="image/png" sizes="32x32" href="assets/favicon/favicon-32x32.png">
        <link rel="icon" type="image/png" sizes="96x96" href="assets/favicon/favicon-96x96.png">
        <link rel="icon" type="image/png" sizes="16x16" href="assets/favicon/favicon-16x16.png">
        <link rel="manifest" href="assets/favicon/manifest.json">
        <meta name="msapplication-TileColor" content="#ffffff">
        <meta name="msapplication-TileImage" content="assets/favicon/ms-icon-144x144.png">
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
            <!-- Profile Picture -->
            <div class="profile-picture">
              <img src="assets/img/profile-picture.JPG" alt="Profile Picture">
            </div>
            <!-- User Information (if needed) -->
            <div class="user-info">
              <span class="user-name">John Doe</span>
              <span class="user-role">Participant</span>
            </div>
            <div class="user-info">
             <span class="user-email">johndoe@gmail.com</span>
            </div>
          </div>
          <ul class="sidebar-nav" data-coreui="navigation" data-simplebar="">
            <li class="nav-item"><a class="nav-link" href="index.html">
                <svg class="nav-icon">
                  <use xlink:href="vendors/@coreui/icons/svg/free.svg#cil-speedometer"></use>
                </svg> Dashboard</a></li>
            <li class="nav-item"><a class="nav-link" href="editProfile.html">
                  <svg class="nav-icon">
                    <use xlink:href="vendors/@coreui/icons/svg/free.svg#cil-user"></use>
                  </svg> Account</a></li>
            <li class="nav-item"><a class="nav-link" href="submission-menu.html">
                <svg class="nav-icon">
                  <use xlink:href="vendors/@coreui/icons/svg/free.svg#cil-clipboard"></use>
                </svg> Submission</a></li>
            <li class="nav-item"><a class="nav-link" href="leaderboard.html">
                  <svg class="nav-icon">
                    <use xlink:href="vendors/@coreui/icons/svg/free.svg#cil-list-numbered"></use>
                  </svg> Leaderboard</a></li>
            <li class="nav-item"><a class="nav-link" href="ebooks.html">
                  <svg class="nav-icon">
                    <use xlink:href="vendors/@coreui/icons/svg/free.svg#cil-book"></use>
                  </svg> E-Books</a></li>
            <li class="nav-item"><a class="nav-link" href="calendar.html">
                  <svg class="nav-icon">
                    <use xlink:href="vendors/@coreui/icons/svg/free.svg#cil-calendar"></use>
                  </svg> Calendar</a></li>
            <li class="nav-item"><a class="nav-link" href="settings.html">
                  <svg class="nav-icon">
                    <use xlink:href="vendors/@coreui/icons/svg/free.svg#cil-settings"></use>
                  </svg> Settings</a></li>
            <li class="nav-item"><a class="nav-link" href="logout.html">
                  <svg class="nav-icon">
                    <use xlink:href="vendors/@coreui/icons/svg/free.svg#cil-account-logout"></use>
                  </svg> Log Out</a></li>
          </ul>
          <button class="sidebar-toggler" type="button" data-coreui-toggle="unfoldable"></button>
        </div>
        <div class="wrapper d-flex flex-column min-vh-100 bg-light">
          <header class="header header-sticky mb-1">
            <div class="logo">
              <img src="assets/img/envirocarbon-logo.png" alt="Logo">
            </div>
            <div class="title " >
              <h1 style="max-width: 80%;">Pertandingan Kalendar Masyarakat Rendah Karbon Iskandar Puteri 2022</h1>
            </div>
            <div class="header-divider"></div>
            <div class="container-fluid">
              <nav aria-label="breadcrumb">
                <ol class="breadcrumb my-0 ms-2">
                  <li class="breadcrumb-item">
                    <!-- if breadcrumb is single--><span>Home</span>
                  </li>
                  <li class="breadcrumb-item active"><span>Submission</span></li>
                </ol>
              </nav>
            </div>
          </header>
          <div class="body flex-grow-1 px-3">
            <div class="container-lg">
              <form>
              <div class="body flex-grow-1 px-3">
                <div class="container-lg">

                  
                  
                  <div class="row mb-4" style="margin-top: 20px;">
                    <!-- <h1 class="row mb-5">Month</h1> -->
                    <div>
                      <label for="month" class="form-label">Month:</label>
                      <input type="month" id ="month" field="month" required>
                      </select>
                    </div>
                    <div class="col-sm-6 col-lg-6">
                      <div>
                          <div class="card-header position-relative d-flex justify-content-center align-items-center">
                              <label for="days" class="form-label"><h4>1. Number of Days:</h4></label>
                          </div>
                          <div class="card-body row text-center">
                              <div class="col">
                                  <input type="text" id="days" name="days" class="form-control" required>
                              </div>
                          </div>
                      </div>
                  </div>
    
      

                    <div class="col-sm-6 col-lg-6">
                      <div>
                          <div class="card-header position-relative d-flex justify-content-center align-items-center">
                              <label for="prorated" class="form-label"><h4>2. Prorated factor:</h4></label>
                          </div>
                          <div class="card-body row text-center">
                              <div class="col">
                                  <input type="text" id="prorated" name="prorated" class="form-control" required>
                              </div>
                          </div>
                      </div>
                  </div>
                  </div>
                    <!-- /.col-->
       
                    <!-- /.col-->
                  </div>
                  <!-- /.row-->
                  <div class="row mb-4">
                    <div class="col-sm-6 col-lg-6">
                      <div>
                          <div class="card-header position-relative d-flex justify-content-center align-items-center">
                              <label for="m3" class="form-label"><h4>3. Current Water consumption values (m3):</h4></label>
                          </div>
                          <div class="card-body row text-center">
                              <div class="col">
                                  <input type="text" id="m3" name="m3" class="form-control" required>
                              </div>
                          </div>
                      </div>
                  </div>
                    <!-- /.col-->
                    <div class="col-sm-6 col-lg-6">
                      <div>
                          <div class="card-header position-relative d-flex justify-content-center align-items-center">
                              <label for="rm" class="form-label"><h4>4. Current electric consumption values (RM)</h4></label>
                          </div>
                          <div class="card-body row text-center">
                              <div class="col">
                                  <input type="text" id="rm" name="rm" class="form-control" required>
                              </div>
                          </div>
                      </div>
                  </div>
                    <!-- /.col-->
                    <!--  <div>
                      <div class="card-header position-relative d-flex justify-content-center align-items-center">
                          <label for="bill" class="form-label"><h4>5. Upload bill:</h4></label>
                      </div>
                      <div class="card-body row text-center">
                          <div class="col">
                              >
                              <input type="file" id="bill" name="bill" class="form-control" accept=".pdf, .doc, .docx" required>
                          </div>
                      </div>
                  </div>-->
                    <!-- /.col-->
                  </div>
                 
                  <div class="text-end mt-3">
                    <a href="water.html" class="btn btn-secondary">Cancel</a>
                    <a href="water.jsp" class="btn btn-primary">Submit</a>
                </div>
                  </div>
          
                </div>

              </div>
              </form>
            </div>
          </div>
    
          <footer class="footer">
            <div><a href="https://coreui.io">CoreUI </a><a href="https://coreui.io">Bootstrap Admin Template</a> © 2023 creativeLabs.</div>
            <div class="ms-auto">Powered by&nbsp;<a href="https://coreui.io/docs/">CoreUI UI Components</a></div>
          </footer>
        </div>
        <!-- CoreUI and necessary plugins-->
        <script src="vendors/@coreui/coreui/js/coreui.bundle.min.js"></script>
        <script src="vendors/simplebar/js/simplebar.min.js"></script>
        <script src="vendors/chart.js/js/chart.min.js"></script>
	    <script src="vendors/@coreui/chartjs/js/coreui-chartjs.js"></script>
	    <script src="vendors/@coreui/utils/js/coreui-utils.js"></script>
	    <script src="js/main.js"></script>
        </script>
    
      </body>
    </html>