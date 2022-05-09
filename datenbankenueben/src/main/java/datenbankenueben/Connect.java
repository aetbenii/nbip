package datenbankenueben;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {


    public static Connection connect(){
        String jdbcURL = "jdbc:postgresql://localhost:5432/nip_bd";
        String username = "postgres";
        String psw = "Admin";
        Connection con = null;

        try{
            con = DriverManager.getConnection(jdbcURL, username, psw);
            System.out.println("Connected!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return con;
    }
}