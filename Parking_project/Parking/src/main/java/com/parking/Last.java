package com.parking;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class Last extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		Connection con=null;
        Statement stmt=null;
		ResultSet rs=null;
		
		try
		{
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://localhost/vehicledb","root","root");
			
			stmt=con.createStatement();
			rs = stmt.executeQuery("select * from vehicle");
			
			out.println("<h2>*************BILLING INFORMATION*************</h2>");
			
			
			
			while(rs.next())
			{
				
				out.println("<h3>VEHICLE INFORMATION</h3>");
				out.println("vehicle no is :        "+rs.getString(1) + "<br>");
				out.println("contact Number :         "+rs.getString(2) + "<br>");
				out.println("vehicle duration :       "+rs.getString(3) + "<br>");
				out.println("vehicle duration charge :"+rs.getString(4) + "<br>");

				out.println("\n");
				out.println("<input type='button' value='Go Back' onclick='history.back()'>");
				
			}
			
			
				
			
			
			
			
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		
		
		
	}

}
