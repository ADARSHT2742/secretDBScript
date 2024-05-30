<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Password Reset Page</title>
    <!-- jQuery -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

    <!-- Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">

    
    <script src="${pageContext.request.contextPath}/resources/fgpassword.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/fgpassword.css">
</head>
<body>
${pageContext.request.contextPath} I amasjdfjkasd
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <h2 class="text-center">Reset Your Password!</h2>
                <form action="" method="POST" class="needs-validation" novalidate>
                    <div class="form-group">
                        <label for="username">Username:</label>
                        <input type="text" class="form-control" name="username" id="username" required>
                        <div class="invalid-feedback">Please enter your username.</div>
                    </div>
                    <div class="form-group">
                        <label for="password">Password:</label>
                        <input type="password" class="form-control" name="password" id="password" required>
                        <div class="invalid-feedback">Please enter your password.</div>
                    </div>
                    <div class="form-group">
                        <label for="cpassword">Confirm Password:</label>
                        <input type="password" class="form-control" name="cpassword" id="cpassword" required>
                        <div class="invalid-feedback">Please confirm your password.</div>
                        <div id="messages"></div>
                    </div>
                    <button type="submit" class="btn btn-primary btn-block" id="resetpass" disabled>Reset My Password</button>
                </form>
            </div>
        </div>
    </div>
    
    <!-- Bootstrap JS -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
