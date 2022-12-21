package com.parking;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



public class Screen extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NullPointerException
	{
		
		response.setContentType("text/html");
		
		PrintWriter out= response.getWriter();
		
		
		
		String opr = request.getParameter("opr");
		
		if(opr==null)
		{
			out.println("<h1>NO INPUT SELECTED</h1>");
			out.print("<a href=http://localhost:8080/Parking/Screen.html><button>Go Back</button></a>");
		}
		
		int choice=Integer.parseInt(opr);

		switch(choice)
		{
		case 1 : 
			        response.sendRedirect("http://localhost:8080/Parking/Two.html");
			        break;
		         
		
		
		case 2 : 
		          response.sendRedirect("http://localhost:8080/Parking/Four.html");
		          break;
		
		
		default : 
			      
			      out.println("heelo");
		           break;
		
		}
		
		         
		
		
		
	
	}

}
