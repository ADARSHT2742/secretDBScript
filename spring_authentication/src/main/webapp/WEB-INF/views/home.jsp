<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="en">
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Authentication</title>
    <!-- jQuery -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

    <!-- Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/home.css">
</head>

<body>
    <div class="centered-container">
        <div class="row">
            <div class="col-md-12 centered">
                <!-- Login radio button -->
                <div class="custom-control custom-radio mr-3">
                    <input type="radio" id="login" name="check" class="custom-control-input" value="login" checked>
                    <label class="custom-control-label" for="login">Login</label>
                </div>

                <!-- Signup radio button -->
                <div class="custom-control custom-radio">
                    <input type="radio" id="signup" name="check" class="custom-control-input" value="signup">
                    <label class="custom-control-label" for="signup">SignUp</label>
                </div>
            </div>
        </div>
        <div id="login_form">
            <h2>Login Form</h2>
            <form action="login" method="POST">
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="username_login">Username:</label>
                            <input type="text" class="form-control" name="username" id="username_login" required>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="password_login">Password:</label>
                            <input type="password" class="form-control" name="userpwd" id="password_login" required>
                        </div>
                    </div>
                </div>
                <input type="submit" class="btn btn-primary" value="Login" id="login_button">
            </form>
        </div>
        <div id="signup_form" style="display: none;">
            <h2>Sign Up Form</h2>

            <form action="signup" method="POST">
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="fullname">Full Name:</label>
                            <input type="text" class="form-control" name="fullname" id="fullname" required>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="usermail">E-Mail:</label>
                            <input type="email" class="form-control" name="usermail" id="usermail" required>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="usercontactnumber">Phone Number:</label>
                            <input type="number" class="form-control" min="0000000000" max="99999999999"
                                name="usercontactnumber" id="contact" required>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="username">Username:</label>
                            <input type="text" class="form-control" name="username" id="username_signup" required>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="userpwd">Password:</label>
                            <input type="password" class="form-control" name="userpwd" id="password_signup"
                                required>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="c_userpwd">Confirm Password:</label>
                            <input type="password" class="form-control" name="c_userpwd" id="cpassword_signup"
                                required>
                        </div>
                    </div>
                </div>
                <div class="form-group" id="messages"></div>
                <button class="btn btn-primary" id="signup_button">Sign Up</button>
            </form>

        </div>
        <div id="forgot_password">
            <a href="forgotPass">Forgot Password?</a>
        </div>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

    <!-- Custom JS -->
    <script src="${pageContext.request.contextPath}/resources/home.js"></script>
</body>

</html>