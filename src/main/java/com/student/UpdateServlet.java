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

@WebServlet("/update")
public class UpdateServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		res.setContentType("text/html");

        PrintWriter out = res.getWriter();
        
        // Get values from frontend
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        String email = req.getParameter("email");
        
        
        String url = "jdbc:mysql://localhost:3306/studentdb";
        String username = "root";
        String password = "atul@1234";
        
        String updateQuery = "UPDATE student SET name = ?, SET age = ?, SET email = ? WHERE id = ?";
        
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	
        	try(
        			Connection con = DriverManager.getConnection(url, username, password);
        			
        			PreparedStatement ps = con.prepareStatement(updateQuery);
        	){
        		ps.setString(1, name);
        		ps.setInt(2, age);
        		ps.setString(3, email);
        		ps.setInt(4, id);
        		
        		int result = ps.executeUpdate();
        		
        		if(result>0) {
        			out.println("<h2>Student Updated Sucessfully!</h2>");
        			
        		}else {
        			out.println("<h2>Student Updation Failed!</h2>");
        		}
        		
        	}
        	   out.println("<br>");
               out.println("<a href='index.jsp'>Back to Home</a>");
        	
        }catch(ClassNotFoundException | SQLException e) {
        	out.println("<h2>Error:" + e.getMessage() + "</h2>");
        }
	}

}
