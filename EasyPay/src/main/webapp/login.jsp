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
	<center>
    <img src="img/hutt.jpg" class="img-rounded" alt="Cinque Terre" width="700" height="40"> 
    </div>
  </header>
  <!-- Nav Bar -->
  <nav class="navbar navbar-fixed-top" role="navigation">
    <ul class="nav nav-tabs">
      <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/login.jsp">Login</a></li>
      <li role="presentation"><a href="${pageContext.request.contextPath}/register.jsp">Register</a></li>
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
      <div class="panel-heading"><center><Strong><h2>Sign in</h2></Strong></center></div>
      <div class="panel-body">
      	<form action="${pageContext.request.contextPath}/rest/login" method="GET">
	        <label for="inputEmail" class="sr-only">Email address</label>
	        <input type="email" name ="username" id="email" class="form-control" placeholder="email" required autofocus>
	        <br>
	        <label for="inputPassword" class="sr-only">Password</label>
	        <input type="password" name="password" id="password" class="form-control" placeholder="password" required auto>
	        <br>
	        <input type = "hidden" name ="session" value = "12345">
	        <button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
        </form>
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