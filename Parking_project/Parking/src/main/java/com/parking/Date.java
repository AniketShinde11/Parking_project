package com.parking;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class Date extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text.html");
		PrintWriter out = response.getWriter();
		
		
		String date= request.getParameter("d");
		
		Connection con=null;
        PreparedStatement ps=null;
		ResultSet rs=null;
		
		try
		{
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://localhost/vehicledb","root","root");
			
			ps = con.prepareStatement("select * from vehicle where date=?");
			ps.setString(1, date);
			
			rs= ps.executeQuery();
			
			
			if(rs.next())
			{
				
				out.println("<h1>VEHICLE INFORMATION</h1>");
				out.println("vehicle no is :        "+rs.getString(1) + "<br>");
				out.println("contact Number :         "+rs.getString(2) + "<br>");
				out.println("vehicle duration :       "+rs.getString(3) + "<br>");
				out.println("vehicle duration charge :"+rs.getString(4) + "<br>");

				out.println("\n");
				out.println("<input type='button' value='Go Back' onclick='history.back()'>");
				
			}
			else
			{
				out.println("<h1>NO VALID DATA</h1>");
				out.print("<a href=http://localhost:8080/Parking/Screen.html><button>Go Back</button></a>");
				
			
			
			}
			
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}

}
