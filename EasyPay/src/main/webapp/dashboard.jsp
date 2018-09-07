<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
      <div class="panel-heading"><center><Strong><h2>EasyPay Balance</h2></Strong></center></div>
        <label for="firstName" name="firstName" placeholder="firstName"><h3><strong>Marie_EasyPay</strong></h3></label>
        <br>
        <label for="cardID">EasyPay Card ID:</label>
        <label for="cardID" name="cardID" placeholder="cardID">0212-1245-1247</label>
        <br>
        <label for="balance">Balance:</label>
        <label for="balance" name="balance" placeholder="balance">$17.00</label>
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
            <th scope="col" name="number" placeholder="autonumber">Number</th>
            <th scope="col" name="date" placeholder="date">Date</th>
            <th scope="col" name="transactionTime" placeholder="transactionTime">Transaction Time</th>
            <th scope="col" name="description" placeholder="description">Description</th>
            <th scope="col"name="total" placeholder="total">Total</th>
            <th scope="col" name="balance" placeholder="balance">Balance</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <th scope="row">1</th>
            <td>29 Aug 2018</td>
            <td>8:00 PM</td>
            <td>Waiwhetu Rd</td>
            <td>-$1.50</td>
            <td>$17.00</td>
          </tr>
          <tr>
            <th scope="row">2</th>
            <td>28 Aug 2018</td>
            <td>9:00 PM</td>
            <td>Nae Nae Rd</td>
            <td>-$1.50</td>
            <td>$18.50</td>
          </tr>
          <tr>
            <th scope="row">3</th>
            <td>27 Aug 2018</td>
            <td>3:00 PM</td>
            <td>Waterloo Rd</td>
            <td>-$1.50</td>
            <td>$20.00</td>
          </tr>
          <tr>
            <th scope="row">4</th>
            <td>26 Aug 2018</td>
            <td>4:00 PM</td>
            <td>Parnell St</td>
            <td>-$1.50</td>
            <td>$21.50</td>
          </tr>
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