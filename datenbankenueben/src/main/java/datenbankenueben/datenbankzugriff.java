/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datenbankenueben;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Benjamin Düring
 */
public class datenbankzugriff {

    public static void main(String[] args) {

        //Zugriff auf den postgreSQL Server
        //Aufenthalt des Servers, Port, Name der Datenbank ist case sensitive
        String jdbcURL = "jdbc:postgresql://localhost:5432/nbip";
        String username = "postgres";
        String psw = "Admin";

        String erstelleTabelleBenutzer = "CREATE TABLE Benutzer(UID serial NOT NULL PRIMARY KEY, Vorname varchar(255) NOT NULL, Nachname varchar(255) NOT NULL)";

        try {
            Connection con = DriverManager.getConnection(jdbcURL, username, psw);
            //Statement erlaubt Informationsaustausch über SQL mit der Datenbank
            Statement statement = con.createStatement();
            
//            int jn = JOptionPane.showConfirmDialog(null," benutzer erstellen? ");
//            if(jn == 1){
//                System.out.println("ja");
//            }else{
//                System.out.println("nein");
//            }
            //statement.execute(erstelleTabelleBenutzer);
            //statement.execute(einfügenBenutzerDaten("Benjamin","Düring"));
            ResultSet rs = statement.executeQuery("SELECT * FROM spieler;");
            while(rs.next()){
               
                System.out.println(rs.getString(1) + " " + rs.getString(2));
                
            }
            //System.out.println("Datenbankzugriff");

        } catch (SQLException ex) {
            Logger.getLogger(datenbankzugriff.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
