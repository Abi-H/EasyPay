<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*" %>
	<% 		
		String name = request.getParameter("name");
		session.setAttribute("username", name); 
        Database db = new Database();
        String cardID = db.getCardId(session.getAttribute("username").toString());
        String balance = db.getBalance(session.getAttribute("username").toString());
        db.getHistory(Integer.parseInt(cardID));
        ArrayList <String> fields = db.getFields();
     %>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>EasyPay Parking</title>
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/sticky-footer.css" rel="stylesheet">
  </head>
  <body>
  <%@ page import="com.easypay.EasyPay.Database" %>
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
      <li role="presentation" class="active"><a href="#">Dashboard</a></li>
      <li role="presentation"><a href="#">Top Up</a></li>
      <li role="presentation"><a href="#">Logout</a></li>
    </ul>
  </nav>
  <br>
  <br>
  <br>
  <br>
  <br>
  <!-- Sign in Box, created using panel -->
  <div class="container">
      <div class="panel panel-primary text-center">
      <div class="panel-heading"><center><Strong>EasyPay Balance</Strong></center></div>
        <label for="firstName" placeholder="firstName"><h3><strong><%=session.getAttribute("username")%></strong></h3></label>
        <br>
        <label for="cardID">
        </label>
        <label for="cardID" placeholder="cardID"><%=cardID%></label>
        <br>
        <label for="balance">Balance:</label>
        <label for="balance" placeholder="balance"><%=balance%></label>
        <br>
  <!-- Drop Down Button -->      
        <p>
        <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">View Transaction History
        </a>
        </p>
        <div class="collapse" id="collapseExample">
        <div class="card card-body">
        <table class="table">
        <thead>
          <tr>
            <th scope="col" placeholder="autonumber">Number</th>
            <th scope="col"placeholder="date">Date</th>
            <th scope="col"placeholder="description">Description</th>
            <th scope="col"placeholder="total">Total</th>
            <th scope="col"placeholder="balance">Balance</th>
          </tr>
        </thead>
        <tbody>
          <%
          	String entry;
          	for(int i = 0; i < fields.size(); i++){
        		entry = fields.get(i++); %>      		
            	<td><%=entry%></td>           	
            	<% entry = fields.get(i++); %>
	            <td><%=entry %> </td>
        	    <% entry = fields.get(i++); %>
	            <td><%=entry %> </td>
          	<%} %>         
        </tbody>
      </table> 
        </div>
        </div>
        </div>
        
  <!-- Drop Down Button Ends -->          
        <br>
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
