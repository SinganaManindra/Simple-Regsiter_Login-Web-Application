<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<html>
<head>
    <title>Update User</title>
</head>
<body>

<h2>Update User Details</h2>

<form action="UpdateServlet" method="post">

    Username: <input type="text" name="username" required><br><br>
    First Name: <input type="text" name="firstname"><br><br>
    Last Name: <input type="text" name="lastname"><br><br>
    Email: <input type="email" name="email"><br><br>
    Password: <input type="password" name="password"><br><br>

    <input type="submit" value="Update">

</form>

</body>
</html>