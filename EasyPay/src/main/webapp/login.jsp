<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>EasyPay Parking</title>
    <!-- Bootstrap  Starts-->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/sticky-footer.css" rel="stylesheet">
  </head>
  <body>
  <!-- Picture Header -->
  <header id="main-header">
    <div>
      <img src="img/ban.png" class="img-rounded" alt="Cinque Terre"> 
      <img src="img/banner.jpg" class="img-rounded" alt="Cinque Terre" width="1600">
    </div>
  </header>
  <!-- Nav Bar -->
  <nav class="navbar navbar-fixed-top" role="navigation">
    <ul class="nav nav-tabs">
      <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/login.jsp">Login</a></li>
      <li role="presentation"><a href="${pageContext.request.contextPath}/register.jsp">Register</a></li>
      <li role="presentation"><a href="#">FAQ</a></li>
    </ul>
  </nav>
  <br>
  <br>
  <br>
  <br>
  <br>
  <!-- Sign in Box, created using panel -->
  <div class="container">
      <div class="panel panel-primary">
      <div class="panel-heading"><center><Strong>Sign in</Strong></center></div>
      <div class="panel-body">
      	<form action="${pageContext.request.contextPath}/rest/login" method="GET">
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="email" id="email" class="form-control" placeholder="email" required autofocus>
        <br>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="password" class="form-control" placeholder="password" required auto>
        <br>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
    </div>
  </div>
</div>
    <!-- FOOTER -->
  <footer class="footer">
  <div class="container_footer text-center">
        <span class="text-muted">Copyright &copy; 2018 The Hutt EasyPay Parking</span>
      </div>
  </footer>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>