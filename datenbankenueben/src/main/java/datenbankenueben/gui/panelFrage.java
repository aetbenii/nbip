package datenbankenueben.gui;

import datenbankenueben.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class panelFrage extends JPanel implements ActionListener {

    private JLabel lblFrage = new JLabel();
    private JButton btnNext = new JButton(" Nächster ");
    private JLabel lblSpieler = new JLabel();

    private int maxSpieler = panelStart.anzahlSpieler;
    private int spieler = 1;

    panelFrage(){
        this.setLayout(null);
        try{
            lblSpieler.setText("Spieler: "+spieler);
        }catch (Exception e){

        }
        lblSpieler.setBounds(50, 20, 200, 50);
        add(lblSpieler);

        lblFrage.setText("HIER KOMMT EINE FRAGE HIN");
        lblFrage.setBounds(50,50,300,50);
        add(lblFrage);

        btnNext.setBounds(60, 300, 200, 30);
        btnNext.addActionListener(this);
        add(btnNext);

        setVisible(true);
    }

    public static String randomFrage(){

        return null;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnNext){
            if(spieler < panelStart.anzahlSpieler){
                spieler++;
                lblSpieler.setText("Spieler: "+spieler);
            }
            if(spieler == panelStart.anzahlSpieler){
                btnNext.setText("Runde Beenden");
                spieler++;
            }else if(spieler > panelStart.anzahlSpieler){
                spieler = 1;
                lblSpieler.setText("Spieler: "+spieler);
                btnNext.setText("Nächster");
                repaint();
                myFrame.cardLayout.show(myFrame.panelCont, "3");

            }
            repaint();
        }
    }
}
