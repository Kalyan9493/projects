<?php
   ob_start();
   session_start();
?>






<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Login Page</title>
<link rel="stylesheet" type="text/css" href="css/style.css"></link>
<link 
  href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.css" 
  rel="stylesheet"  type='text/css'>
<link href="css/font-awesome.css" rel="stylesheet" type="text/css"/>


</head>

<body>

<div id="tab-container">




<div id="container">

<img  src="images/ad.jpg" ><br />
<h1 id="h4">Welcome To Login</h1>	
<form id="form-input" action="addb.php" method = "post">
	<input type="text" name="username" placeholder="Enter User Name" required >
    <div id="pass">
	<input type="password" name="password" placeholder=" Enter Password" required ><br><a href="#">Forget password?</a><br>
      <br /><input id="btn-login" type="submit" id="btn-login"name="submit" value="Login" onClick="return confirm('Are you sure want to login');" ><br /></div></form><form action="Reg.php">
      <input id="btn"type="submit" name="create account" value="Create Account"></form>
      
      
           
           
</div>           
</body>
</html>