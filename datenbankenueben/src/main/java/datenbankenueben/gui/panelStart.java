package datenbankenueben.gui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class panelStart extends JPanel{

    private CardLayout cardLayout;

    panelFrage pFrage;
    panelAntworten pAntworten;
    panelScore pScore;

    JButton btnNeuerSpieler;
    JButton btnStart = new JButton("Start!");

    ArrayList<JPanel> spielerFelder = new ArrayList<>();

    public panelStart(){



    }
}
