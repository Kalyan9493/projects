
<?php
$servername = "localhost";
$username = "root";
$password = "";
$db="login";


// Create connection
$conn = new mysqli($servername, $username, $password,$db);



// Check connection
if ($conn->connect_error) {
    die("Connection failed: " .mysql_error());
} 

	$uname = $_POST['usern'];
	$pass = $_POST['passwd'];
	$sql="SELECT username, password FROM users WHERE username=$uname";
	$qury = mysqli_query($conn,$sql);
	
	

$row = mysql_fetch_array($qury);

if($row["username"]==$email && $row["password"]==$pass){
    echo"You are a validated user.";
	header('Refresh:2;url=shomepage.php');}
else{
    echo"Sorry, your credentials are not valid, Please try again.";}
?>





