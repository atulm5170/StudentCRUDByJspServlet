<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<h1>Update Student Record</h1>

<form action="update"method="get">

 <label>Student ID:</label>
<input type="number" name="id" placeholder="Enter Student Id"required><br><br>

<label>New Name: </label>
<input type="text"name = "name" placeholder="Enter New Name"required><br><br>

 <label>New Age:</label>
<input type="number" name="age" placeholder="Enter New Age"required><br><br>

 <label>New Email:</label>
<input type="email" name="email" placeholder="Enter New Email"required><br><br>

<input type="submit"value="Update Student">

</form>
  <br>

<a href="index.jsp">Back To Home</a>
</body>
</html>