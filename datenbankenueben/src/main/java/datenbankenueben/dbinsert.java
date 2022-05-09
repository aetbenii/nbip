package datenbankenueben;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class dbinsert {

    public static void spielerHinzufügen(String name){
        Connection con = Connect.connect();
        PreparedStatement ps = null;
        try{
            String sql = "INSERT INTO Spieler(spielername) VALUES(?)";
            ps = con.prepareStatement(sql);
            ps.setString(1,name);
            ps.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
