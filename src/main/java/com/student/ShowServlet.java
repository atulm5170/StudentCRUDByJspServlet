package com.student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/show")
public class ShowServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		  res.setContentType("text/html");

	        PrintWriter out = res.getWriter();
	        
	        //database details
//	        String url = "jdbc:mysql://localhost:3306/studentdb";
//	        String username = "root";
//	        String password = "";
	        
	        // replaced as databse details
	        String host = System.getenv("DB_HOST");
	        String port = System.getenv("DB_PORT");
	        String database = System.getenv("DB_NAME");
	        String username = System.getenv("DB_USER");
	        String password = System.getenv("DB_PASSWORD");

	        String url = "jdbc:mysql://" + host + ":" + port + "/" + database
	                + "?sslMode=REQUIRED";
	        
	        
	        String showQuery = "SELECT * FROM student";
	        
	        try {
	        	Class.forName("com.mysql.cj.jdbc.Driver");
	        	
	        	try(	        	
	        			Connection con = DriverManager.getConnection(url, username, password);
	        			
	        			PreparedStatement ps = con.prepareStatement(showQuery);
	        			
	        			ResultSet rs = ps.executeQuery();		
	        	){
	        		out.println("<h2>Student Records</h2>");
	        		
	        		out.println("<table border='1'>");
	        		
	        		out.println("<tr>");
	        		
	        		out.println("<th>ID</th>");
	        		out.println("<th>Name</th>");
	        		out.println("<th>Age</th>");
	        		out.println("<th>Email</th>");
	        		
	        		out.println("</tr>");

	        		
	        		while(rs.next()) {
	        			
		        		out.println("<tr>");
		        		
	        			out.println("<td>" + rs.getInt("id") + "</td>");
	        			out.println("<td>" + rs.getString("name") + "</td>");
	        			out.println("<td>" + rs.getString("age") + "</td>");
	        			out.println("<td>" + rs.getString("email") + "</td>");
	        			
		        		out.println("<tr>");
	        		}
	        		 out.println("</table>");
	        		 
	        		  out.println("<br>");
	        		  
	        		  out.println("<a href='index.jsp'>Back To Home</a>");
	        }
	        	
	        }catch(ClassNotFoundException | SQLException e) {
	        	out.println("<h2>Error: " + e.getMessage() + "</h2>");
	        }          
	}
}
