<?php

// establishing the MySQLi connection

 session_start();
    $_SESSION['message'] = '';

$con = mysqli_connect("localhost","root","","login");

if (mysqli_connect_errno())

{

echo "MySQLi Connection was not established: " . mysqli_connect_error();

}

// checking the user

if(isset($_POST['Register'])){

$password = mysqli_real_escape_string($con,$_POST['password']);

$confirmpassword = mysqli_real_escape_string($con,$_POST['confirmpassword']);
$username = mysqli_real_escape_string($con,$_POST['username']);
 $email = mysqli_real_escape_string($con,$_POST['email']);

if ($_POST['password'] === $_POST['confirmpassword']) {
        
        //define other variables with submitted values from $_POST
		$username = $con->real_escape_string($_POST['username']);
        $email = $con->real_escape_string($_POST['email']);

        
		
		$sql = "INSERT INTO users (username, email, password, confirmpassword) "
                . "VALUES ('$username', '$email', '$password', '$confirmpassword')";
                
                //check if mysql query is successful
                if ($con->query($sql) === true){
					
					
					
                    echo "<script>alert('Registration successful!')</script>";
                   
                  
                    header('Refresh:2;url=index.php');
                }
				if ($con->query($sql)!= true){
					
					
					
                    echo "<script>alert('Please correct password Registration Not successful!')</script>";
                   
                  
                    header('Refresh:0;url=index.php');
                }
				
            
		
		}

	}

?>

 