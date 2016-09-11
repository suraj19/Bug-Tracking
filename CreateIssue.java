import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.*;

public class CreateIssue extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
	
       String Isname = request.getParameter("IssueName");
       String name = request.getParameter("name");
       int Dt= Integer.parseInt(request.getParameter("Date"));
	   String Desc = request.getParameter("Description");
        try{
        
		Class.forName("com.mysql.jdbc.Driver");
		Connection  con=DriverManager.getConnection("jdbc:mysql:/ /localhost:3306/bug_tracker","root","root");
        PreparedStatement ps=con.prepareStatement("insert into NewIssue values(?,?,?,?)");
        ps.setString(1, Isname);
        ps.setString(2, name);
		ps.setInt(3,Dt);
        ps.setString(4, Desc);
        int i=ps.executeUpdate();
        
          if(i>0)
          {
            out.println("You have sucessfully created an Issue");
          }
        
        }
        catch(Exception se)
        {
            se.printStackTrace();
        }
	
      }
  }