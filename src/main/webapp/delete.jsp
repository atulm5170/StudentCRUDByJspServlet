<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<h1>Deleted Student Record</h1>

<form action="delete"method="get">

<label>Student ID:</label>
<input type="number"name="id"placeholder="Enter Id For Delete Student"required><br><br>

<input type="submit"value="Delete Student">

</form>
<br>
<a href="index.jsp">Back To Home</a>


</body>
</html>