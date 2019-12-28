<?php
   ob_start();
   session_start();
?>






<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Registration Page</title>
<link rel="stylesheet" type="text/css" href="css/regstyle.css"></link>
<link 
  href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.css" 
  rel="stylesheet"  type='text/css'>
<link href="css/font-awesome.css" rel="stylesheet" type="text/css"/>


</head>

<body>

<div id="tab-container">




<div id="container">

<img  src="images/ad.jpg" ><br />
<h1 id="h4">Cerate New Account</h1>	
<form id="form-input" action="reg_validation.php" method = "post" required>
	<input type="text" name="username" placeholder="Enter User Name" required >
    <div id="ema"><input type="email" name="email" placeholder="Enter Your Email Id" required ></div>
    <div id="pass">
	<input type="password" name="password" placeholder=" Enter Password" required ><br></div>
    
    <div id="pass"><input type="password" name="confirmpassword" placeholder=" confirm password" required ><br>
    
    <input  id="btn-login" type="submit"  value="Cancel" onClick="" >
    
      <input id="btn-login" type="submit" name="Register" value="Sign UP" onClick="return confirm('Are you sure want to login');" >
		 
    
          </form></div>
           
           
</div>           
</body>
</html>