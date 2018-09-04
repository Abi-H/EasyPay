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
      <img src="img/ban.png" class="img-rounded" alt="Cinque Terre"> 
      <img src="img/banner.jpg" class="img-rounded" alt="Cinque Terre" width="1600">
    </div>
  </header>
  <!-- Nav Bar -->
  <nav class="navbar navbar-fixed-top" role="navigation">
    <ul class="nav nav-tabs">
      <li role="presentation" class="active"><a href="#">Top Up</a></li>
      <li role="presentation"><a href="#">Dashboard</a></li>
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
      <div class="panel panel-primary">
      <div class="panel-heading"><center><Strong>Payment Method</Strong></center></div>
      <div class="panel-body">
      <div class="container">
      <form class="form-horizontal" role="form">
      <fieldset>
      <legend>Top Up for EasyPay Card ID: 0212-1245-1247</legend>
      <div class="form-group">
        <label class="col-sm-3 control-label" for="amount">Amount</label>
          <div class="col-sm-3">
          <input type="text" class="form-control" name="amount" id="amount" placeholder="Amount to Top Up">
          </div>
      </div>
      <div class="form-group">
        <label class="col-sm-3 control-label" for="card-holder-name">Name on Card</label>
          <div class="col-sm-6">
          <input type="text" class="form-control" name="card-holder-name" id="card-holder-name" placeholder="Card Holder's Name">
          </div>
      </div>
      <div class="form-group">
          <label class="col-sm-3 control-label" for="card-number">Card Number</label>
          <div class="col-sm-6">
          <input type="text" class="form-control" name="card-number" id="card-number" placeholder="Debit/Credit Card Number">
          </div>
      </div>
      <div class="form-group">
          <label class="col-sm-3 control-label" for="expiry-month">Expiration Date</label>
          <div class="col-sm-6">
          <div class="row">
          <div class="col-xs-3">
        <select class="form-control col-sm-2" name="expiry-month" id="expiry-month">
                <option>Month</option>
                <option value="01">Jan (01)</option>
                <option value="02">Feb (02)</option>
                <option value="03">Mar (03)</option>
                <option value="04">Apr (04)</option>
                <option value="05">May (05)</option>
                <option value="06">June (06)</option>
                <option value="07">July (07)</option>
                <option value="08">Aug (08)</option>
                <option value="09">Sep (09)</option>
                <option value="10">Oct (10)</option>
                <option value="11">Nov (11)</option>
                <option value="12">Dec (12)</option>
        </select>
        </div>
        <div class="col-xs-3">
        <select class="form-control" name="expiry-year">
                <option value="13">2013</option>
                <option value="14">2014</option>
                <option value="15">2015</option>
                <option value="16">2016</option>
                <option value="17">2017</option>
                <option value="18">2018</option>
                <option value="19">2019</option>
                <option value="20">2020</option>
                <option value="21">2021</option>
                <option value="22">2022</option>
                <option value="23">2023</option>
        </select>
        </div>
        </div>
        </div>
      </div>
      <div class="form-group">
        <label class="col-sm-3 control-label" for="cvv">Card CVV</label>
        <div class="col-sm-3">
        <input type="text" class="form-control" name="cvv" id="cvv" placeholder="Security Code">
        </div>
      </div>
      <div class="form-group">
        <div class="col-sm-offset-3 col-sm-6">
        <button class="btn btn-lg btn-primary btn-block" type="submit">Top Up</button>
        </div>
      </div>
    </fieldset>
  </form>
</div>
<!-- End of Panel -->
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