package databaseconnection;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;

public class databasecon
{

    public databasecon()
    {
    }

    public static Connection getconnection()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/suraj", "root","root");
        }
        catch(Exception e)
        {
            System.out.println("class error");
        }
        return con;
    }

    static Connection con;
}
