<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>

<h1>Add Student</h1>
<form action="insert"method="get">

<label>Name: </label>
<input type="text"name="name"placeholder="Enter Your Aame"><br><br>

<label>Age: </label>
<input type="number"name="age"placeholder="Enter Your Age"><br><br>

<label>Email: </label>
<input type="email"name="email"placeholder="Enter Your Email"><br><br>

<input type="submit"value="Add Student">

</form>
   <br>

    <a href="index.jsp">Back to Home</a>


</body>
</html>