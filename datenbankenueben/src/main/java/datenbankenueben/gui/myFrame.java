package datenbankenueben.gui;

import javax.swing.*;

public class myFrame extends JFrame {

    panelStart pStart;

    myFrame(){
        this.setTitle("Keiner ist Perfekt und dabei soll es bleiben.");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(500, 620);
        //this.setResizable(false);

        pStart = new panelStart();
        this.add(pStart);

        this.setVisible(true);
    }
}
