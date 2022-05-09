package datenbankenueben.gui;

import datenbankenueben.Connect;
import datenbankenueben.dbselect;

public class main {
    public static void main(String[] args) {
        dbselect.selectSpieler();

        new myFrame();
        //Connect.connect();
    }
}
