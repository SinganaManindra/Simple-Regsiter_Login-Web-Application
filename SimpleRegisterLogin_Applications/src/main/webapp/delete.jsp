<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<html>
<head>
    <title>Delete User</title>
</head>
<body>

<h2>Delete User</h2>

<form action="DeleteServlet" method="post">

    Username: <input type="text" name="username" required><br><br>

    <input type="submit" value="Delete">

</form>

</body>
</html>