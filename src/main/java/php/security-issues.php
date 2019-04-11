<?php


if (sha1($password) === 'd0be2dc421be4fcd0172e5afceea3970e2f3d940') { // Noncompliant; sha1() hashing algorithm is not secure for password management

}

setcookie("TestCookie", $value, time()+3600, "/~path/", ".com", 1); // Noncompliant
session_set_cookie_params(3600, "/~path/", ".com"); // Noncompliant


$servername = "localhost";
$username = "AppLogin";
$password = "";

// MySQL
$conn = new mysqli($servername, $username, $password);

?>