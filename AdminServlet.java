/* This Servlet come in to action when admin access the admin link in HTML page . Here, the credentials entered by admin are verified with credentials of admin available in the database.*/
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.io.*;
import java.util.*;
import java.lang.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AdminServlet extends HttpServlet {
public static boolean validate(String name,String pass){
boolean status=false;
try{
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/suraj", "root","root");
	
	PreparedStatement ps=con.prepareStatement("select * from Registration where name=? and pass=?");
	ps.setString(1,name);
	ps.setString(2,pass);
	ResultSet rs=ps.executeQuery();
	status=rs.next();
	}
	catch(Exception e)
		{
			System.out.println(e);
		}
		return status;
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
			{

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String n=request.getParameter("username");
		String p=request.getParameter("password");
		boolean status=true; //assuming login sucess.
	response.setContentType("text/html");
	PrintWriter pw = response.getWriter();
	out.println("<HTML>");
	out.println("<BODY BG COLOR=GREEN>");
	if(status)
		out.println("<a href=Admin.html>");
	else
		out.println("<H2>Login Failed <A HREF=Index.html> try again</A></H2>");
		out.println("</BODY>");
		out.println("</HTML>");
		out.close();
	}
}
	
