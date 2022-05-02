package datenbankenueben.gui;

import javax.swing.*;
import java.awt.*;

public class panelFrage extends JPanel {

    private JLabel lblFrage = new JLabel();

    panelFrage(){
        this.setLayout(null);
        lblFrage.setText(randomFrage());
        lblFrage.setBounds(50,50,300,50);
        add(lblFrage);

        setVisible(true);
    }

    public static String randomFrage(){

        return null;
    }
}
