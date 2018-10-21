<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Browse for movies online</title>

<style>
body {
	
	font-family:Arial;
	background-color: grey;
	background-image: url("http://www.visitroswellga.com/wp-content/uploads/2018/03/Movies.jpg");
	}
* {
	box-sizing: border-box;
	}
	
form.example input[type=text]{
	padding: 9px;
	font-size: 17px;
	border: 1px solid grey;
	float: left;
	width: 80%;
	background: #f1f1f1;
	}
	
form.example button {
	float: letf;
	
	padding: 10px;
	background: #2196F3;
	color: white;
	font-size: 17px;
	border: 1px solid grey;
	border-left: none;
	cursor: pointer;
	}
	
form.example button:hover{
	background: #0b7dda;
	}
	
form.example::after {
	content: "";
	clear: both;
	display: table;
	}

</style>
</head>
<body>

<br>
<br>

<form class="example" action="myApp" style="margin:auto;max-width:300px"  >
  <input type="text" placeholder="Search by movie title.." name="title" >
  <button type="submit"><i class="fa fa-search"></i></button>
</form>

</body>
</html>