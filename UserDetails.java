 import java.io.*;
 import javax.servlet.*;
 import javax.servlet.http.*;
 import java.sql.*;
  
 public class UserDetails extends HttpServlet {
  
     public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
         PrintWriter out = res.getWriter();
         res.setContentType("text/html");
		 out.println("<HTML>");
		out.println("<BODY BG COLOR=GREEN>");
         try {
             Class.forName("com.mysql.jdbc.Driver");
             Connection  con=DriverManager.getConnection("jdbc:mysql:/ /localhost:3306/bug_tracker","root","root");
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select * from userdetails");
             out.println("<table border=1 width=50% height=50%>");
             out.println("<tr><th>UserName</th><th>UserRole</th><th>UserEmailID</th><th>UserMobileNumber</th><th>CreatedDate</th><tr>");
             while (rs.next()) {
                 String n = rs.getString("UserName");
                 String nr = rs.getString("UserRole");
		 String EId = rs.getString("UserEmailID");
                 int MNo = rs.getInt("UserMobileNumber"); 
		 int Dt = rs.getInt("CreatedDate");
                 out.println("<tr><td>" + n + "</td><td>" + nr + "</td><td>" + EId + "</td></tr>" + MNo +"<tr><td>" + Dt + "<tr><td>"); 
             
			 }
             out.println("</table>");
             out.println("</html></body>");
             con.close();
            }
             catch (Exception e) {
             out.println("error");
         }
     }
 }
