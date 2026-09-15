package com.student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/insert")
public class InsertServlet extends HttpServlet{

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		  res.setContentType("text/html");
		  
		  PrintWriter out = res.getWriter();
		  
		  // Get values from frontend
		  String name = req.getParameter("name");
		  int age = Integer.parseInt(req.getParameter("age"));
		  String email = req.getParameter("email");
		  
		  
		  // Database details
		  String url = "jdbc:mysql://localhost:3306/studentdb";
		  String username = "root";
		  String password = "atul@1234";
		  
		  String insertQuery = "INSERT INTO student (name,age,email) VALUES (?,?,?)";
		  
		  try {
			  Class.forName("com.mysql.cj.jdbc.Driver");
			  
			  try(
					  Connection con = DriverManager.getConnection(url, username, password);
					  
					  PreparedStatement ps = con.prepareStatement(insertQuery);
				){
				  
				  ps.setString(1, name);
				  ps.setInt(2, age);
				  ps.setString(3, email);
				  
				  int result = ps.executeUpdate();
				  
				  if(result>0) {
					  out.println("<h2>Student Inserted Sucessfully!</h2>");
					  
				  }else {
					  out.println("<h2>Student Insertion failed!</h2>");
				  }
				  
			  }
			  
		  }catch(ClassNotFoundException | SQLException e) {
			  out.println("Error: " + e.getMessage());
		  }
		  
	}
}
