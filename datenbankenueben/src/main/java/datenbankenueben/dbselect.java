package datenbankenueben;

import java.sql.*;
import java.util.ArrayList;

public class dbselect {

    public static void selectTurnier(){
        Connection con = Connect.connect();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM Turnier";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            System.out.println("ALLE TURNIERE:");
            while(rs.next()){
                System.out.println(rs.getString(1) + " " + rs.getString(2));
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        } finally {
            try {
                rs.close();
                ps.close();
                con.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static ArrayList selectSpieler(){
        ArrayList al = new ArrayList<>();
        Connection con = Connect.connect();
        try(Statement statement = con.createStatement()){
            ResultSet rs = statement.executeQuery("SELECT * FROM Spieler;");
            while(rs.next()){
                System.out.println(rs.getString(1) + " " + rs.getString(2));
                //al.add(new spieler(rs.getString(2),rs.getString(3),rs.getString(4)));
            }
            con.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return al;
    }

    // alle spieler von einem bestimmten Turnier.
    // nicht void sondern eine Liste zurückgeben.
    public static void findeSpielerEinesTurnieres(String TurnierName){

        Connection con = Connect.connect();
        try(Statement statement = con.createStatement()){
            //nach TurnierID gesucht.
            //ResultSet rs = statement.executeQuery("SELECT * FROM Spieler JOIN Spieler_nimmt_teil_Turnier ON Spieler.SpielerID = Spieler_nimmt_teil_Turnier.SpielerID WHERE TurnierID = "+TurnierID);
            ResultSet rs = statement.executeQuery(
                        "SELECT Spieler.vorname, Spieler.nachname, Turnier.TurnierName FROM Spieler " +
                            "JOIN Spieler_nimmt_teil_Turnier ON Spieler.SpielerID = Spieler_nimmt_teil_Turnier.SpielerID " +
                            "JOIN Turnier ON Spieler_nimmt_teil_Turnier.TurnierID = Turnier.TurnierID " +
                            "WHERE TurnierName like '"+TurnierName+"'");
            while(rs.next()){
                System.out.println(rs.getString(1) + " " + rs.getString(2)+ " - " + rs.getString(3));

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    // alle Runden von einem bestimmten Turnier.
    public static void findeRundenEinesTurnieres(String Turniername){
        Connection con = Connect.connect();
        try(Statement statement = con.createStatement()){
            ResultSet rs = statement.executeQuery("");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public static String getFrage(int id){
        String a = "";
        Connection con = Connect.connect();
        try(Statement statement = con.createStatement()){
            ResultSet rs = statement.executeQuery("Select frage from frage where frageid ="+id);
            while(rs.next()){
                a = rs.getString(1);
                System.out.println(rs.getString(1));
            }
            rs.close();
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return a;
    }

    public static int getAnzahlFragen(){
       int a = 0;
        Connection con = Connect.connect();
        try(Statement statement = con.createStatement()){
            ResultSet rs = statement.executeQuery("select count(antwort) from frage");
            while(rs.next()){
                a = Integer.parseInt(rs.getString(1));
            }
            rs.close();
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return a;
    }
}
