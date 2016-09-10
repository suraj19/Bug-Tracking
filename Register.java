/* This servlet Register.java is used to allow new user to create the account according to his role */
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.*;

public class Register extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
	
        String Fname = request.getParameter("Fname");
	String Lname = request.getParameter("Lname");
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        String role = request.getParameter("role");
	String MNo = request.getParameter("MNo");
		try{
        
        //loading drivers for mysql
        Class.forName("com.mysql.jdbc.Driver");

	//creating connection with the database 
          Connection  con=DriverManager.getConnection
                     ("jdbc:mysql:/ /localhost:3306/test","username","password");

        PreparedStatement ps=con.prepareStatement
                  ("insert into Registration values(?,?,?,?,?,?)");

        ps.setString(1, Fname);
	ps.setString(2, Lname);
        ps.setString(3, email);
        ps.setString(4, pass);
	ps.setString(5, role);
	ps.setString(6, MNo);
        int i=ps.executeUpdate();
        
          if(i>0)
          {
            out.println("You are sucessfully registered");
          }
        
        }
        catch(Exception se)
        {
            se.printStackTrace();
        }
	
      }
  }
