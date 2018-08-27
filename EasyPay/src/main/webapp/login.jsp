<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
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
	<section id="showcase">
		<div class="container">
			<form action="${pageContext.request.contextPath}/login" method="POST">
			<label>Email Address:</label>
			<input type="email" name="email" placeholder="Enter your email" class="form-control" id="email">
			<br>
			<label>Password:</label>
			&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
			<input type="password" name="password" placeholder="Enter your password" class="form-control" id="password">
			<br>
			<p> No account yet? Create an account. </p>
			<button type="login" name="login" value="login" class="button">Login</button>
			<button type="register" name="register" value="register" class="button">Register</button>
		</div>
	</section>
	</div>

	<footer id="main-footer">
		<p>Copyright &copy; 2018 The Hutt EasyPay Parking</p>
	</footer>
	</body>
</html>