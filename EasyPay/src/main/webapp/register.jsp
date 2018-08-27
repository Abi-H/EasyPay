<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>EasyPay Parking</title>
	<link rel="shortcut icon" href="favicon.ico" />
	<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<header id="main-header">
		<div>
			<img src="img/ban.png"/ >
			 <img src="img/banner.jpg"/ >
		</div>
	</header>

	<nav id="navbar">
		<div class="container">
			<ul>
				<li><a href="#">Login</a></li>
			</ul>
		</div>
	</nav>

	<section id="showcase">
		<div class="container">
			<p><strong>Create an Account:</strong></p>
			<label>Email Address:</label>
			&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;
			<form action="${pageContext.request.contextPath}/rest/register" method="GET">
				<input type="email" name="email" placeholder="enter your email" class="form-control" id="email">
				<br>
				<label>First Name:</label>
				&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;&nbsp;
				<input type="text" name="firstName" placeholder="enter your first name" class="form-control" id="firstName">
				<br>
				<label>LastName:</label>
				&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;&nbsp;
				<input type="text" name="lastName" placeholder="Enter your last name" class="form-control" id="lastName">
				<br>
				<label>Password:</label>
				&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="password" name="password" placeholder="Enter your password" class="form-control" id="password">
				<br>
				<br>
				<input type="submit" name="createAccount" value="Create Account" class="button">
			</form>
		</div>
	</section>
	</div>

	<footer id="main-footer">
		<p>Copyright &copy; 2018 The Hutt EasyPay Parking</p>
	</footer>
	</body>
</html>