package utillity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    static Connection conn=null;

    public static Connection getConnection() {
        try {
            //Class.forName("org.h2.Driver");
            //conn=DriverManager.getConnection("jdbc:h2:tcp://localhost//Users/Marko/Documents/University/Second year 2022-2023/Java and DB practice/Ski Resort Project/ Database/skiresortdb", "sa", "1234");}
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/skiresortdb", "root", "root");}

        catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return conn;
    }

}
