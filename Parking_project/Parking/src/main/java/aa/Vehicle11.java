package aa;



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class Vehicle11 extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	response.setContentType("text/html");
		
		PrintWriter out= response.getWriter();
		
		
		String vno= request.getParameter("vno");
		String cno=request.getParameter("cno");
		String duration=request.getParameter("duration");
		String charges=request.getParameter("charges");
		String date=request.getParameter("date");
		
		//out.println("hhhhhhhh");
		
		Connection con=null;
		PreparedStatement ps=null;
		
		try
		{
			Class.forName("org.postgresql.Driver");
			
			con= DriverManager.getConnection("jdbc:postgresql://localhost/vehicledb","root","root");
			
			ps= con.prepareStatement("insert into vehicle values(?,?,?,?,?)");
			ps.setString(1,vno);
			ps.setString(2, cno);
			ps.setString(3, duration);
			ps.setString(4, charges);
			ps.setString(5, date);
		      
			
			int i=ps.executeUpdate();
			
			//out.println("hiiiiiii");
			
			if(i==0)
			{
				response.sendRedirect("http://localhost:8080/Parking/Vehicle.html");
			}
			else
			{
				//out.println("<a http://localhost:8080/Parking/payment.html<button> BACK</button></a>");
				response.sendRedirect("http://localhost:8080/Parking/payment.html");
			}
			
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
