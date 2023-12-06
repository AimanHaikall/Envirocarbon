<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
	<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    <link href="vendors/@coreui/chartjs/css/coreui-chartjs.css" rel="stylesheet">
</head>
<body>
     <div class="bg-light min-vh-100 d-flex flex-row align-items-center">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-lg-8">
                        	<center>
	                        	<div> <!-- Added mb-4 for margin-bottom and text-center class for centering -->
		          					<img alt="Logo Envirocarbon" src="assets/logo/envirocarbon_logo.png" width="300">
		        				</div>
                            <div class="card-body">
                                <h1>REGISTER</h1></center>
                                <form id="registerForm" action="register_process.jsp" method="post">
                                    <!-- Personal Details -->
                                    <div class="mb-3">
                                        <label for="name" class="form-label">NAME</label>
                                        <input type="text" class="form-control" id="name" name="name" required>
                                    </div>
                                    <div class="mb-3">
                                        <label for="identification" class="form-label">IDENTIFICATION NUMBER / PASSPORT</label>
                                        <input type="text" class="form-control" id="identification" name="identification" required>
                                    </div>
                                    <div class="mb-3">
                                        <label for="address" class="form-label">ADDRESS</label>
                                        <input type="text" class="form-control" id="street1" name="street1" placeholder="Street 1" required><br>
                                        <input type="text" class="form-control" id="street2" name="street2" placeholder="Street 2" required><br>
                                        <input type="text" class="form-control" id="state" name="state" placeholder="State" required>
                                    </div>
                                    <div class="mb-3">
                                        <label for="phone" class="form-label">PHONE NUMBER</label>
                                        <input type="text" class="form-control" id="phone" name="phone" required>
                                    </div>
                                    <div class="mb-3">
                                        <label for="email" class="form-label">EMAIL</label>
                                        <input type="email" class="form-control" id="email" name="email" required>
                                    </div>
                                    <!-- Account Details -->
                                    <div class="mb-3">
                                        <label for="username" class="form-label">USERNAME</label>
                                        <input type="text" class="form-control" id="username" name="username" required>
                                    </div>
                                    <div class="mb-3">
                                        <label for="password" class="form-label">PASSWORD</label>
                                        <input type="password" class="form-control" id="password" name="password" required>
                                    </div>
                                    <!-- Other Details -->
                                    <div class="mb-3">
                                        <label>STATUS APPLICATION</label>
                                        <div>
                                            <input type="radio" id="student" name="status" value="student">
                                            <label for="student">Student</label>
                                        </div>
                                        <div>
                                            <input type="radio" id="housewife" name="status" value="housewife">
                                            <label for="housewife">Housewife</label>
                                        </div>
                                        <div>
                                            <input type="radio" id="work" name="status" value="work">
                                            <label for="work">Work</label>
                                        </div>
                                    </div>
                                    <div class="mb-3">
                                        <label>CATEGORY</label>
                                        <div>
                                            <input type="radio" id="a1" name="category" value="a1">
                                            <label for="a1">A1</label>
                                        </div>
                                        <div>
                                            <input type="radio" id="a2" name="category" value="a2">
                                            <label for="a2">A2</label>
                                        </div>
                                        <div>
                                            <input type="radio" id="b1" name="category" value="b1">
                                            <label for="b1">B1</label>
                                        </div>
                                        <div>
                                            <input type="radio" id="b2" name="category" value="b2">
                                            <label for="b2">B2</label>
                                        </div>
                                        <!-- Add more options as needed -->
                                    </div>
                                    <div class="mb-3">
                                        <label for="household" class="form-label">Number of Household</label>
                                        <input type="number" class="form-control" id="household" name="household" required>
                                    </div>
                                    
                                    <center>
                                    <div class="mb-3 form-check">
                                        <input type="checkbox" id="agree" name="agree" required>
                                        <label class="form-check-label" for="agree">I agree with the <a href="https://www.linkedin.com/in/taufiqjurimi">terms and conditions</a></label>
                                    </div>
                                    </center>
                                    
                                    <center>
                                    <div>
                                        <a type="submit" class="btn btn-primary px-2" href="home.jsp">CREATE</a>
                                    </div>
                                    </center>
                                </form>
                                <div class="text-center">
                                    Already have an account? <a href="login.jsp">Login</a>
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
