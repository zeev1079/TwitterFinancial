<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Twitter Financial Analysis - Home Page</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/index.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

    <div class="site-wrapper">

      <div class="site-wrapper-inner">

        <div class="cover-container">

          <div class="masthead clearfix">
            <div class="inner">
              <h3 class="masthead-brand">Twitter Financial Analysis</h3>
              <nav>
                <ul class="nav masthead-nav">
                  <li class="active"><a href="#">Search</a></li>
                  <li><a href="/TwitterFinancial/register.jsp">Register</a></li>
                  <li><a href="/TwitterFinancial/login.jsp">Login</a></li>
                </ul>
              </nav>
            </div>
          </div>

          <div class="inner cover">
          
            <p class="lead">This search can be used as an 
            investing indicator, for marketing strategies, as an for indication popularity, and to study the correlation 
            with the response with the return of the stock price. The method in which we will resolve the problem is by 
            observing a company twitter properties such as positive, negative, volume, and etc.
            </p>
         
            <p class="lead">
            	<form  method="GET" action="SearchController"
					name="searchForm" >
              		<input type="text" name="ticker"class="form-control" placeholder="Serach company trigger"><br>
              		<button type="submit" name="search" class="btn btn-lg btn-success">Search</button>
              	</form>
            </p>
            
          </div>

          <div class="mastfoot">
            <div class="inner">
              <p>Made with <span class="glyphicon glyphicon-heart" aria-hidden="true"></span> by <a href="#">group 4</a>.</p>
            </div>
          </div>

        </div>

      </div>

    </div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
