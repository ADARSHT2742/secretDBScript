<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Learning Project</title>
</head>
<body>
    I am c2.
    <form action="catch_req_parameter" method="POST"> 
        <input type="text" name="user_name" placeholder="User name">
        <input type="submit" value="submit">
    </form>
    <a href="internal_forward">
        Forward Internally
    </a>
    <a href="internal_redirect">
        Redirect Internally
    </a>
    <a href="external_redirect">
        Redirect Externally
    </a>
</body>
</html>