import java.sql.*;
import javax.sql.*;

public class Main
{
    protected static final String MYSQL_DRIVER_CLASS = "com.mysql.jdbc.Driver";
    protected static final String URL_BASIC = "jdbc:mysql://127.0.0.1:3306/mysql";

    public static Connection createConnectionByDriverManager(String id, String password) throws SQLException
    {
        try
        {
            Class.forName(MYSQL_DRIVER_CLASS);
            System.out.println("연결 성공");
        }
        catch (ClassNotFoundException sException)
        {
            System.out.println("연결 성공x");
        }

        return DriverManager.getConnection(URL_BASIC, id, password);
    }

    public static void main(String[] args) throws Exception
    {
        Connection con = createConnectionByDriverManager("TEST", "test");
        System.out.println("Connection Success");
        con.close();
    }
}