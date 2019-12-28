<?php

// establishing the MySQLi connection

 

$con = mysqli_connect("localhost","root","","login");

if (mysqli_connect_errno())

{

echo "MySQLi Connection was not established: " . mysqli_connect_error();

}

// checking the user

if(isset($_POST['submit'])){

$user = mysqli_real_escape_string($con,$_POST['username']);

$pass = mysqli_real_escape_string($con,$_POST['password']);

$sel_user = "select * from users where username='$user' AND password='$pass'";

$run_user = mysqli_query($con, $sel_user);

$check_user = mysqli_num_rows($run_user);


//validation from user table
if($check_user>0){

$_SESSION['username']=$user;
header('Refresh:0;url=shomepage.php');
//echo "<script>window.open('shomepage.php','_self')</script>";

}

else {

echo "<script>alert('Username or password is not correct, try again!')</script>";
header('Refresh:0;url=index.php');

}

}

?>

 