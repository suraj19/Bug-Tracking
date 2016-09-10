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
	
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        String role = request.getParameter("role");
		try{
        
        //loading drivers for mysql
        Class.forName("com.mysql.jdbc.Driver");

	//creating connection with the database 
          Connection  con=DriverManager.getConnection
                     ("jdbc:mysql:/ /localhost:3306/suraj","root","root");

        PreparedStatement ps=con.prepareStatement
                  ("insert into NewUser values(?,?,?,?)");

        ps.setString(1, name);
        ps.setString(2, email);
        ps.setString(3, pass);
	ps.setString(4, role);
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
