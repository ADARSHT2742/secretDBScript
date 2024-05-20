<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Learning Project</title>
</head>
<body>
	I am c1.
    <form action="catch_form_data" method="POST"> 
        <input type="number" name="user_id" placeholder="userid" min="1">
        <input type="text" name="user_pwd" placeholder="password">
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