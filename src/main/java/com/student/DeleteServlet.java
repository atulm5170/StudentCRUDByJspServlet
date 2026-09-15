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

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet{

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		res.setContentType("text/html");

        PrintWriter out = res.getWriter();
        
     // Get ID from frontend
        int id = Integer.parseInt(req.getParameter("id"));
        
        String url = "jdbc:mysql://localhost:3306/studentdb";
        String username = "root";
        String password = "atul@1234";
        
        String deleteQuery = "DELETE FROM student WHERE id = ?";
        
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	
        	try(
        			Connection con = DriverManager.getConnection(url, username, password);
        			
        			PreparedStatement ps = con.prepareStatement(deleteQuery);
        	){
        		ps.setInt(1, id);
        		
        		int result = ps.executeUpdate();
        		
        		if(result>0) {
        			out.println("<h2>Student Deleted Sucessfully!</h2>");
        			
        		}else {
        			out.println("<h2>Student Deletion Failed!</h2>");
        		}
        	}
        	
        	 out.println("<br>");
             out.println("<a href='index.jsp'>Back to Home</a>");
        	
        }catch(ClassNotFoundException |SQLException e) {
        	out.println("<h2>Error:" + e.getMessage() + "</h2>");
        }
	}
}
