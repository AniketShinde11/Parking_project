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


public class Time1 extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		response.setContentType("text.html");
		PrintWriter out=response.getWriter();
		
      String hour= request.getParameter("h");
		
		Connection con=null;
        PreparedStatement ps=null;
		ResultSet rs=null;
		
		try
		{
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://localhost/vehicledb","root","root");
			
			ps = con.prepareStatement("select * from vehicle where duration=?");
			ps.setString(1, hour);
			
			rs= ps.executeQuery();
			
			
			if(rs.next())
			{
				
				out.println("<h1>VEHICLE INFORMATION</h1>");
				out.println("vehicle no is :        "+rs.getString("vno") + "<br>");
				out.println("contant number :         "+rs.getString(2) + "<br>");
				out.println("vehicle charge :       "+rs.getString(4) + "<br>");
				out.println("Date :                    "+rs.getString(5) + "<br>");

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
		//out.println("\n");
		//out.println("<input type='button' value='Go Back' onclick='history.back()'>");
		
		
		
		

	
	
	
	
	
	
	}

}
