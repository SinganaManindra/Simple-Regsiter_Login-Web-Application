<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
if(session.getAttribute("username") == "username"){
    response.sendRedirect("Login.jsp");
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
body{
background: linear-gradient(120deg,#2980b9,#6dd5fa);
min-height:100vh;
}

.sidebar{
height:100vh;
width:250px;
position:fixed;
top:0;
left:-250px;
background:#212529;
color:white;
transition:0.3s;
padding-top:60px;
}

.sidebar a{
color:white;
text-decoration:none;
display:block;
padding:12px 20px;
}

.sidebar a:hover{
background:#495057;
}

.sidebar.active{
left:0;
}

.content{
margin-left:0;
transition:0.3s;
}

.content.shift{
margin-left:250px;
}
</style>
</head>

<body>

<!-- Navbar -->
<nav class="navbar navbar-dark bg-dark">
<div class="container-fluid">

<button class="btn btn-light" onclick="toggleSidebar()">☰</button>

<span class="navbar-text text-white ms-auto">
Welcome, <%= session.getAttribute("username") %>
</span>

</div>
</nav>

<!-- Sidebar -->
<div id="sidebar" class="sidebar">
<h4 class="text-center mb-4">Menu</h4>

<a href="DashBoard.jsp">Home</a>
<a href="profile.jsp">Profile</a>
<a href="Login.jsp">Logout</a>
</div>

<!-- Content -->
<div id="content" class="content p-4">

<div class="container">

    <div class="card shadow-lg p-4">

        <h2 class="text-center mb-4 text-primary">
            Welcome, <%= session.getAttribute("firstname") %> 👋
        </h2>

        <hr>

        <h4 class="mb-3">User Details</h4>

        <table class="table table-bordered">

            <tr>
                <th>Username</th>
                <td><%= session.getAttribute("username") %></td>
            </tr>

            <tr>
                <th>First Name</th>
                <td><%= session.getAttribute("firstname") %></td>
            </tr>

            <tr>
                <th>Last Name</th>
                <td><%= session.getAttribute("lastname") %></td>
            </tr>

            <tr>
                <th>Email</th>
                <td><%= session.getAttribute("email") %></td>
            </tr>

        </table>

    </div>

</div>

</div>

<script>
function toggleSidebar(){
    document.getElementById("sidebar").classList.toggle("active");
    document.getElementById("content").classList.toggle("shift");
}
</script>

</body>
</html>