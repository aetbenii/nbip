package datenbankenueben.gui;

import javax.swing.*;
import java.awt.*;

public class myFrame extends JFrame {

    static CardLayout cardLayout = new CardLayout();
    static JPanel panelCont = new JPanel();
    panelStart pStart = new panelStart();
    panelFrage pFrage = new panelFrage();
    panelAntworten pAntworten = new panelAntworten();
    panelScore pScore = new panelScore();

    myFrame(){
        this.setTitle("Keiner ist Perfekt und dabei soll es bleiben.");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(500, 620);
        this.setResizable(false);
        //this.setResizable(false);

        panelCont.setLayout(cardLayout);
        panelCont.add(pStart, "1");
        panelCont.add(pFrage, "2");
        panelCont.add(pAntworten, "3");
        panelCont.add(pScore, "4");
        cardLayout.show(panelCont, "1");


        this.add(panelCont);

        this.setVisible(true);
    }
}
