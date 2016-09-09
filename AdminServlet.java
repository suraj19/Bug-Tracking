import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import javax.sql.*;
public class AdminServlet extends HttpServlet
{
Connection con;
PreparedStatement Ps;
	public void init(ServletConfig config)
	{
	try
	{
			Class.forName(config.getInitParameter("P1"));
			con=Drivermanager.getConnecetion(config.getInitParameter("P2"), config.getParameter("P3"), config.getInitParameter("P4"));
			Ps=con.PrepareStatement("select * from Registration where UserName=?AND PASSWORD=?");
		}
		
		catch(Exception e)
			{
				System.out.println(e);
			}
			}
public void destroy()
	{
	try
	{
		Ps.close();
		con.close();
	}
	catch (SQLException  e)
	{
		System.out.println(e);
	}
	}//destroy()
public void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException
	{
	String usr= request.getparameter("user name");
	String password= request.getparameter("password");
	boolean flag=tree; //assuming login sucess.
	try
	{
		Ps.setString(1,usr);
		Ps.setString(2,pwd);
		ResultSet rs = Ps.executeQuery();
		flag=rs.next();
		rs.close();
	}
	catch (Exception e)
		{
		System.out.println(e);
		}
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		out.println("<HTML>");
		out.println("<BODY BG COLOR=GREEN>");
		if(flag)
			out.println("<a href=Admin.html>");
		else
			out.println("<H2>Login Failed <A HREF=Login.html> try again</A></H2>");
			out.println("</BODY>");
			out.println("</HTML>");
			out.close();
	}
}